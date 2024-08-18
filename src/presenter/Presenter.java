package presenter;

import model.family_tree.human.Gender;
import model.family_tree.human.HumanService;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private HumanService service;

    public Presenter(View view) {
        this.view = view;
        service = new HumanService();
    }


    public void addHuman(String name, LocalDate BirthDate, Gender gender) {
        service.addHuman(name, BirthDate, gender);
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
