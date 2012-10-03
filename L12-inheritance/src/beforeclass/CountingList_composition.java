package beforeclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CountingList_composition<E> implements List<E> {
    private List<E> list;
    private int elementsAdded = 0;
    
    public CountingList_composition(List<E> list) {
        this.list = list;
    }
    
    public int getAddCounter() {
        return elementsAdded;       
    }
    
    @Override
    public boolean add(E e) {
        ++elementsAdded;
        return list.add(e);
    }
    
    @Override
    public boolean addAll(Collection<? extends E> es) {
        elementsAdded += es.size();
        return list.addAll(es);
    }
    
    public static void main(String[] args) {
        CountingList_composition<Integer> list = new CountingList_composition<Integer>(new ArrayList<E>());
        list.add(1);
        list.add(2);
        list.addAll(Arrays.asList(new Integer[] {3,4,5}));
        System.out.println(list.getAddCounter());
    }
}
