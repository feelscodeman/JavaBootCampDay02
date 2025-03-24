import java.util.List;
import java.util.NoSuchElementException;

public class AnimalIterator implements BaseIterator<Animal> {

    private int curIndex;
    private final int endIndex;
    List<Animal> petList;

    public AnimalIterator(List<Animal> li) {
        petList = li;
        endIndex = li.size();
        curIndex = 0;
    }

    public Animal next() {
        if (curIndex >= endIndex)
            throw new NoSuchElementException("" + curIndex);

        return petList.get(curIndex++);
    }

    public boolean hasNext() {
        return curIndex < endIndex;
    }

    public void reset() {
        curIndex = 0;
    }

}