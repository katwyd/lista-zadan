package projects.todolist.option;

import java.util.Scanner;

public interface Option {

    default void run(Object... args) {
        showWelcomeMessage();
        while (true) {
            showOptions();
            String option = getOption();
            if (isValidOption(option)) {
                executeOption(option);
                if (isExitOption(option)) {
                    break;
                }
            } else {
                executeInvalidOption(option);
            }
        }
        showExitMessage();
    }

    default void showWelcomeMessage() {}

    void showOptions();

    default String getOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTwór wybór: ");
        return scanner.nextLine();
    }

    boolean isValidOption(String option);

    void executeOption(String option);

    boolean isExitOption(String option);

    default void executeInvalidOption(String option) {
        System.out.println("\nNiestety '" + option + "' jest niepoprawnym wyborem");
    }

    default void showExitMessage() {}


}
