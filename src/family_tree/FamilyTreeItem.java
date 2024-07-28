package family_tree;

import human.Human;

import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T> {
   int getAge();

   String getName();

   void setId(int i);

   List<Human> getParents();

   List<T> getChildren();

   Human getSpouse();

   void setSpouse(T human2);

   long getId();
}







