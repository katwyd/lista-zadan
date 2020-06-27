package projects.todolist.option.todos;

import projects.todolist.option.Option;
import java.util.Set;

public class ManageTodosOption implements Option {

    @Override
    public void showWelcomeMessage() {
        System.out.println("\n~~~ Zarządzanie listami zadań ~~~\n");
    }

    @Override
    public void showOptions() {
        System.out.println("Menu:");
        System.out.println("\t1. Dodaj listę zadań");
        System.out.println("\t2. Pokaż listy zadan");
        System.out.println("\t3. Usuń listę zadań");
        System.out.println("\t4. Wróć");
    }

    @Override
    public boolean isValidOption(String option) {
        return Set.of("1", "2", "3", "4").contains(option);
    }

    @Override
    public void executeOption(String option) {
        switch (option) {
            case "1": {
                AddTodosOption addTodosOption = new AddTodosOption();
                addTodosOption.run();
                break;
            }
        }
    }

    @Override
    public boolean isExitOption(String option) {
        return "4".equals(option);
    }
}


