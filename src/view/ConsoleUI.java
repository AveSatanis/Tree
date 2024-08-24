package view;

import model.family_tree.FamilyTree;
import model.family_tree.human.Gender;
import presenter.Presenter;
import view.Commands.LoadTree;
import view.Commands.SaveTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветсвие!");
        while (work){
            System.out.println(menu.menu());
            String strChoice = scanner.nextLine();
            int choice = Integer.parseInt(strChoice);
            menu.execute(choice);
        }
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void save(FamilyTree familyTree){
        presenter.save(familyTree);
    }

    public void load(){
        presenter.load();
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения человека");
        String BirthDate = scanner.nextLine();
        LocalDate birthDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = birthDate.format(formatter);
        System.out.println("Введите пол человека");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addHuman(name, birthDate, gender);
    }

    public void error(){
        System.out.println("Неверно введены данные!");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
