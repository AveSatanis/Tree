package human;

import family_tree.FamilyTree;

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
}
