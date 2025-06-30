import java.util.*;

class Test6{
    public static void main(String[] args){
        String s[]={"Alice","Bob","Clark","Darth","Alice","Darth"};
        for(var x:s)
            System.out.println(x);
        //HashMap(unsorted) - key,value pair
        HashMap<String, Integer> hm=new HashMap<String, Integer>();
        for(String x:s){
            Integer c=hm.get(x);
            if(c==null)
                hm.put(x,1); 
            else
                hm.put(x,++c); 
        }
        //key -String and Value - Frequency of that String
        System.out.println(hm);
    }
} 