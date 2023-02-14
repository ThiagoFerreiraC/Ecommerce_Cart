package general.commands;

public class CloseCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
