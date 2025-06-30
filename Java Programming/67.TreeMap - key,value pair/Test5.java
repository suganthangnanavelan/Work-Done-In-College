import java.util.*;

class Test5{
    public static void main(String[] args){
        TreeMap<String, Double> tm=new TreeMap<String, Double>();
        tm.put("Alice Paul",10000.56);
        tm.put("Darth Paul",20000.56);
        tm.put("Bob Mark",50000.56);
        System.out.println(tm);
        for(Map.Entry<String, Double> me:tm.entrySet())
            System.out.println(me.getKey()+" , "+me.getValue());
        Double balance=tm.get("Alice Paul");
        tm.put("Alice Paul",balance+5000);
        System.out.println(tm);
    }
} 