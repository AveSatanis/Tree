import model.family_tree.FamilyTree;
import model.family_tree.human.Gender;
import model.family_tree.human.Human;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static String filePath = "src/model.family_tree.writer/tree.txt";
    public static void main(String[] args) {
        FamilyTree tree = testTree();


        System.out.println(tree);
        tree.sortByName();
        System.out.println(tree);
        tree.sortByAge();
        System.out.println(tree);
    }
    private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human vova = new Human("Владимир", Gender.Man, LocalDate.of(1953, 4, 7));
        Human katya = new Human("Екатерина", Gender.Woman, LocalDate.of(1957, 7, 25));

        tree.add(vova);
        tree.add(katya);
        tree.setWedding(vova, katya);

        Human natasha = new Human("Наталья", Gender.Woman, LocalDate.of(1977, 8, 19), vova, katya);
        Human ivan = new Human("Иван", Gender.Man, LocalDate.of(1978, 9, 11), vova, katya);

        tree.add(natasha);
        tree.add(ivan);

        Human grandMom = new Human("Лариса", Gender.Woman, LocalDate.of(1933, 2, 24));
        grandMom.addChild(vova);

        tree.add(grandMom);
        return tree;
    }
}