package projects.todolist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.Set;

public class TodoListApp {

    private final static Logger log = LoggerFactory.getLogger(TodoListApp.class);

    public static void main(String[] args) {
        TodoListApp app = new TodoListApp();
        app.run();
    }

    public void run(Object... args) {
        log.info("Rozpoczęcie działania");
        showWelcomeMessage();
        while (true) {
            showOptions();
            String option = getOption();
            log.debug("Wybrana opcja: {}", option);
            if (isValidOption(option)) {
                executeOption(option);
                break;
            } else
                executeInvalidOption(option);
        }
    }

    private void executeInvalidOption(String option) {
        System.out.println("\nNiestety " + option + " jest niepoprawnym wyborem");
    }

    private void executeOption(String option) {
        switch (option) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
        }
    }

    private boolean isValidOption(String option) {
        Set<String> validOption = Set.of("1", "2", "3", "4");
        return validOption.contains(option);
    }

    private String getOption() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nTwój wybór: ");
        return scan.nextLine();
    }

    private void showOptions() {
        System.out.println("Menu:");
        System.out.println("\t1. Lista zadań");
        System.out.println("\t2. Zadania");
        System.out.println("\t3. Pokaż najbliższe zadania do realizacji");
        System.out.println("\t4. Zakończ");
    }

    private void showWelcomeMessage() {
        System.out.println("\n~~~ Witaj w liście zadań ~~~\n");
    }
}


