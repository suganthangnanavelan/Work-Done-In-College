/*
Unit - 3
java.util.Collections
template is used to create genric class
implement of the data structures in collections are based on var type data for genric implementation
List-data Structur(array list, linked list)
Array List - Homogenous, Ordered and element are stored in contigous memory location

set data structure -Hash Set(elements are placed based on their hash value)

tree data structure -TreeSet(elements are stored in sorted manner 
*/
//ArrayList
import java.util.*;
class ArrayListDemo{
    public static void main(String[] args){
        ArrayList<String> al=new ArrayList<String>();//Creating object of template class
        al.add("SASTRA");
        al.add("DEEMED");
        al.add("UNIVERSITY");
        System.out.println("Length..."+al.size());
        //System.out.println("Elements...."+al);
        //al.remove(object)
        //al.remove(index)   
        //System.out.println("..."+al.get(0));
        String r=al.remove(0);
        //System.out.println(r);
        //System.out.println("..."+al.set(0,r));
        al.add(2,r);
        for(var s:al)
            System.out.println(s);
    }
}
