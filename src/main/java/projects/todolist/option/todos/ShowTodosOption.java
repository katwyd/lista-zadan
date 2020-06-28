package projects.todolist.option.todos;

import projects.todolist.model.Task;
import projects.todolist.model.Todos;
import projects.todolist.option.EndOption;
import projects.todolist.service.TodosService;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class ShowTodosOption implements EndOption {

    private final TodosService todosService = new TodosService();

    @Override
    public void showWelcomeMessage() {
        System.out.println("\nListy zadań");
    }

    @Override
    public void executeOption(String option) {
        Collection<Todos> todos = todosService.findAll();
        for (Todos todo : todos) {
            printTodos(todo);
        }
    }

    private void printTodos(Todos todo) {
        System.out.printf("\t[%-4d] %s (%d)\n", todo.getId(), todo.getName(), todo.getTasks().size());

        Optional<Task> lastCompleted = todo.getTasks()
                .stream()
                .filter(t -> Objects.nonNull(t.getCompletedOn()))
                .sorted(Comparator.comparing(Task::getCompletedOn).reversed())
                .findFirst();

        lastCompleted.ifPresent(t -> System.out.printf("\t\tOstatnie zakończone zadanie: %s\n", t.getName()));

        Optional<Task> firstToComplete = todo.getTasks()
                .stream()
                .filter(t -> Objects.isNull(t.getCompletedOn()))
                .sorted(Comparator.comparing(Task::getExpectedCompletedOn))
                .findFirst();

        firstToComplete.ifPresent(t -> System.out.printf("\t\tNajbliższe zadania do zrobienia: %s\n", t.getName()));
    }
}





