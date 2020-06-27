package projects.todolist.option;

import java.util.Scanner;

public class ManageTodosOption {

    public static void main(String[] args) {
        showMessage();
        showListOptions();
        getOption();
    }


    private static String getOption() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nTwój wybór: ");
        return scan.nextLine();
    }

    private static void showListOptions() {
        System.out.println("Menu:");
        System.out.println("\t1. Dodaj listę zadań");
        System.out.println("\t2. Pokaż listy zadan");
        System.out.println("\t3. Usuń listę zada");
        System.out.println("\t4. Wróć");
    }


    private static void showMessage() {
        System.out.println("\n~~~ Zarządzanie listami zadań ~~~\n");
    }
}