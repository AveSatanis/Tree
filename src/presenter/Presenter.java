package presenter;

import model.family_tree.human.HumanService;
import view.ConsoleUI;
import view.View;

public class Presenter {
    private View view;
    private HumanService service;

    public Presenter(View view) {
        this.view = view;
        service = new HumanService();
    }

    public Presenter(ConsoleUI consoleUI) {
    }


    public void addHuman(String name, int age) {
        service.addHuman(name, age);
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }
}
