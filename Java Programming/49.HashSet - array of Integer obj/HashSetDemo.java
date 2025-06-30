import java.util.*;
class HashSetDemo{
    public static void main(String[] args){
        HashSet<Integer> al=new HashSet<Integer>();//Creating object of template class
        al.add(10212);
        al.add(29208);
        al.add(32082);
        System.out.println("Length..."+al.size());
        //System.out.println("Elements...."+al);
        //al.remove(object)
        //al.remove(index)   
        //System.out.println("..."+al.get(0));
        //String r=al.remove(0);
        //System.out.println(r);
        //System.out.println("..."+al.set(0,r));
        //al.add(2,r);
        for(var s:al)
            System.out.println(s);
    }
}