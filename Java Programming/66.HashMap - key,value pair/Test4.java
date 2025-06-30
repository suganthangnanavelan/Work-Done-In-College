/*
//Map Based Data structures
HashMap, TreeMap, LinkedHashMap - set data structures
HashMap - unsorted
TreeMap - sorted
LinkedHashMap - forward and backward traverse is possible
Map-Reduce programming <key, value>
key - data
value - processed result of data

*/
import java.util.*;

class Test4{
    public static void main(String[] args){
        HashMap<String, Double> hm=new HashMap<String, Double>();
        hm.put("Alice Paul",10000.56);
        hm.put("Darth Paul",20000.56);
        hm.put("Bob Mark",50000.56);
        System.out.println(hm);
        for(Map.Entry<String, Double> me:hm.entrySet())
            System.out.println(me.getKey()+" , "+me.getValue());
        Double balance=hm.get("Alice Paul");
        hm.put("Alice Paul",balance+5000);
        System.out.println(hm);
    }
} 