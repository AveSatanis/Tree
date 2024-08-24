package view.Commands;

import model.family_tree.human.service.HumanService;
import view.ConsoleUI;

public class LoadTree extends Command {

    public LoadTree(ConsoleUI consoleUI){
        super("Загрузить семейное древо", consoleUI);
    }

    public void load(){
        HumanService loadTree = new HumanService();
        loadTree.load();
    }

    @Override
    public void execute() {
        getConsoleUI().load();
    }
}
