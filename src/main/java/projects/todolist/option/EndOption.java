package projects.todolist.option;

public interface EndOption extends Option{

    default void showOptions() {}

    default boolean isExitOption(String option) { return true; }

    default String getOption() {
        return "";
    }

    default boolean isValidOption(String option) { return true; }
}
