package model.family_tree.human;

import model.family_tree.FamilyTree;
import model.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class HumanService {
    private FamilyTree familyTree;
    private HumanBuilder builder;
    final static String filePath = "scr/model.family_tree/writer/tree.txt";

    public HumanService(){
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String name, LocalDate BirthDate, Gender gender){
        Human human = builder.setHumanName(name).setBirthDate(BirthDate).setGender(gender).build();
        familyTree.add(human);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (Object human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void save(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

    public void load(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.read();
    }
}
