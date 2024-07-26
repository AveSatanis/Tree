import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static String filePath = "src/writer/tree.txt";
    public static void main(String[] args) {

//        FamilyTree tree = load();
        FamilyTree tree = testTree();
        save(tree);

        System.out.println(tree);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
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