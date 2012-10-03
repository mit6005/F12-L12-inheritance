package beforeclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CountingList_subclassing<E> extends ArrayList<E> {
    private int elementsAdded = 0;
    
    public int getAddCounter() {
        return elementsAdded;       
    }
    
    @Override
    public boolean add(E e) {
        ++elementsAdded;
        return super.add(e);
    }
    
    @Override
    public boolean addAll(Collection<? extends E> es) {
        elementsAdded += es.size();
        return super.addAll(es);
    }
    
    public static void main(String[] args) {
        CountingList_subclassing<Integer> list = new CountingList_subclassing<Integer>();
        list.add(1);
        list.add(2);
        list.addAll(Arrays.asList(new Integer[] {3,4,5}));
        System.out.println(list.getAddCounter());
    }
}
