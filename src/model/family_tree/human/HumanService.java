package model.family_tree.human;

import model.family_tree.FamilyTree;

public class HumanService {
    private FamilyTree familyTree;
    private HumanBuilder builder;

    public HumanService(){
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String humanName, int humanAge){
        Human human = builder.setHumanAge(humanAge).setHumanName(humanName).build();
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
}
