package model.family_tree.human.service;

import model.family_tree.FamilyTree;
import model.family_tree.human.Gender;
import model.family_tree.human.Human;
import model.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class HumanService {
    private FamilyTree<Human> familyTree;
    private HumanBuilder builder;
    final static String filePath = "scr/model.family_tree/writer/tree.txt";

    public HumanService(){
        familyTree = new FamilyTree<Human>();
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

    public void save(FamilyTree<Human> familyTree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

    public void load(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.read();
    }

    public boolean add(FamilyTree<Human> familyTree){
        return familyTree.add(new Human());
    }

    public List<Human> getSiblings(FamilyTree<Human> familyTree){
        return familyTree.getSiblings(new Human().getId());
    }
}
