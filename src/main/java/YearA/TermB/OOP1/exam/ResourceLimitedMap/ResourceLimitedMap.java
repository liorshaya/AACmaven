package YearA.TermB.OOP1.exam.ResourceLimitedMap;

import java.util.*;

public class ResourceLimitedMap<K,V> {
    private Map<K,V> data;
    private int maxSize;

    public ResourceLimitedMap(int maxSize){
        this.data = new LinkedHashMap<>();
        this.maxSize = maxSize;
    }

    public void addNewElement(K key , V value){
        if(maxSize > this.data.size()){
            this.data.put(key, value);
        }
        else if(maxSize == this.data.size()){
            K firstKey = this.data.keySet().iterator().next();
            this.data.remove(firstKey);
            data.put(key, value);
        }
    }

    public List<K> getInsertionOrder(){
        List<K> allKeys = new ArrayList<>();
        for (K elements : data.keySet()){
            allKeys.add(elements);
        }
        return allKeys;
    }
}
