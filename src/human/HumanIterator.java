package human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {
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
