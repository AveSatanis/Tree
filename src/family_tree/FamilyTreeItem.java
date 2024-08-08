package family_tree;

import human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>, Serializable {
   int getAge();

   String getName();

   void setId(int i);

   List<T> getParents();

   List<T> getChildren();

   T getSpouse();

   void setSpouse(T human);

   long getId();

   boolean addChild(T human);

   boolean addParent(T human);

   T getMom();

   T getDad();

}







