package view;

import presenter.Presenter;

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

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите возраст человека");
        String strAge = scanner.nextLine();
        int age = Integer.parseInt(strAge);

        presenter.addHuman(name, age);
    }

    public void error(){
        System.out.println("Неверно введены данные!");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
