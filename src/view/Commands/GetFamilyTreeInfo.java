package view.Commands;

import view.ConsoleUI;

public class GetFamilyTreeInfo extends Command{

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super("Показать семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}
