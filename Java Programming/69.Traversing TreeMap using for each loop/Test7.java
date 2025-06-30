import java.util.*;

class Test7{
    public static void main(String[] args){
        String s[]={"Alice","Bob","Clark","Darth","Alice","Darth"};
        for(var x:s)
            System.out.println(x);
        //TreeMap(Sorted) - key,value pair
        TreeMap<String, Integer> tm=new TreeMap<String, Integer>();
        for(String x:s){
            Integer c=tm.get(x);
            if(c==null)
                tm.put(x,1); 
            else
                tm.put(x,++c); 
        }
        //Here key - String and Value - Frequency of that String
        System.out.println(tm);
    }
} 