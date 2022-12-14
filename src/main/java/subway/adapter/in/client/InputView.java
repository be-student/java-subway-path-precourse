package subway.adapter.in.client;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    public InputView(Scanner scanner){
        this.scanner=scanner;
    }

    public GameCommand askRetry(){
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        return GameCommand.fromCommand(scanner.nextLine());
    }
}
