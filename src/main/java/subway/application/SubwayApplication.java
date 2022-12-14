package subway.application;

import subway.application.port.in.MinimumDistanceCommand;
import subway.application.port.in.SubwayUseCase;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.SubwayResultDto;

public class SubwayApplication implements SubwayUseCase {

    private final LineRepository lineRepository = new LineRepository();
    private final StationRepository stationRepository = new StationRepository();

    @Override
    public SubwayResultDto calculateResult(MinimumDistanceCommand minimumDistanceCommand) {
        validate(minimumDistanceCommand);
        if (minimumDistanceCommand.getFindByType().equals("1")) {
            return calculateByDistance();
        }
        if (minimumDistanceCommand.getFindByType().equals("2")) {
            return calculateByTime();
        }
        throw new IllegalArgumentException("입력 타입이 잘못되었습니다");
    }

    private void validate(MinimumDistanceCommand minimumDistanceCommand) {
        String startStation = minimumDistanceCommand.getStartStation();
        String endStation = minimumDistanceCommand.getFinishStation();
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
        }
    }

    private SubwayResultDto calculateByDistance() {

    }

    private SubwayResultDto calculateByTime() {

    }

}
