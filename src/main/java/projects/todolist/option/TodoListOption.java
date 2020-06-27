package projects.todolist.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.todolist.option.todos.ManageTodosOption;

import java.util.Set;

public class TodoListOption implements Option {

    private static final Logger log = LoggerFactory.getLogger(TodoListOption.class);

    @Override
    public void showWelcomeMessage() {
        System.out.println("\nWitamy w Liście Zadań");
    }

    @Override
    public void showOptions() {
        System.out.println("\nMenu:");
        System.out.println("\t1. Listy zadań");
        System.out.println("\t2. Zadania");
        System.out.println("\t3. Pokaż najbliższe zadania do realizacji");
        System.out.println("\t4. Zakończ");
    }

    @Override
    public boolean isValidOption(String option) {
        return Set.of("1", "2", "3", "4").contains(option);
    }

    @Override
    public void executeOption(String option) {
        switch (option) {
            case "1": {
                new ManageTodosOption().run();
                break;
            }
        }
    }

    @Override
    public boolean isExitOption(String option) {
        return "4".equals(option);
    }

    @Override
    public void showExitMessage() {
        System.out.println("\nDo zobaczenia!");
    }
}
