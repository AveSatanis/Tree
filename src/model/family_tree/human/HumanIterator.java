package model.family_tree.human;

import model.family_tree.FamilyTreeItem;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem<T>> implements Iterator<T>  {
    private int curIndex;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > curIndex;
    }

    @Override
    public T next() {
        return familyTree.get(curIndex);
    }
}
