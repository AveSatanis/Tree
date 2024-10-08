package model.family_tree.human.comparator;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByAge<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge()- o2.getAge();
    }
}
