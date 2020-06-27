package projects.todolist.option.todos;

import projects.todolist.model.Todos;
import projects.todolist.option.EndOption;
import projects.todolist.service.TodosService;

import java.util.Scanner;

public class AddTodosOption implements EndOption{

    private final TodosService todosService = new TodosService();

    @Override
    public void showWelcomeMessage() {
        System.out.println("\nDodaj nowy cytat");
    }

    @Override
    public void executeOption(String option) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\tPodaj nazwę listy: ");
        String todosName = scanner.nextLine();
        Todos todos = new Todos();
        todos.setName(todosName);
        todosService.saveTodos(todos);
    }
}
