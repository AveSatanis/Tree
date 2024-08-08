package model.family_tree;

import model.family_tree.human.ComparatorByAge;
import model.family_tree.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;


    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList){this.humanList = humanList;}

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add( human);
            human.setId((int) humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(int humanId1, int humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 =  getById(humanId1);
            E human2 =  getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(int humanId1, int humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 =  getById(humanId1);
            E human2 =  getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public E getById(int id){
        for (E human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString(){return getInfo();};

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByAge() {
        Collections.sort(humanList, new ComparatorByAge());
    }
}
