package subway.adapter.in.client;

import java.util.function.Supplier;
import subway.application.port.in.SubwayUseCase;

public class SubwayClient {

    private final SubwayUseCase subwayUseCase;
    private final InputView inputView;

    public SubwayClient(SubwayUseCase subwayUseCase, InputView inputView) {
        this.inputView = inputView;
        this.subwayUseCase = subwayUseCase;
    }

    public void run() {
        while (true) {
            GameCommand playerInput = askRetry();
            if (playerInput == GameCommand.QUIT) {
                return;
            }
            calculateDistance();
        }
    }

    private void calculateDistance() {
        while (true) {
            DistanceType distanceType = askType();
            if (distanceType == DistanceType.BACK) {
                return;
            }
        }
    }

    private GameCommand askRetry() {
        return repeat(inputView::askRetry);
    }

    private <T> T repeat(Supplier<T> playerInput) {
        try {
            return playerInput.get();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return repeat(playerInput);
        }
    }

    private DistanceType askType() {
        return repeat(inputView::askType);
    }
}
