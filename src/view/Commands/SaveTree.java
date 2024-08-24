package view.Commands;

import model.family_tree.FamilyTree;
import model.family_tree.human.Human;
import model.family_tree.human.service.HumanService;
import view.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить семейное древо",consoleUI);
    }

    public void save(FamilyTree<Human> familyTree){
        HumanService saveTree = new HumanService();
        saveTree.save(familyTree);
    }

    @Override
    public void execute() {
        getConsoleUI().save(new FamilyTree<>());
    }
}
