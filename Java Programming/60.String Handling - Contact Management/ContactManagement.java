package pkcontact;

import userdefinedexception.DuplicateContactException;
import pkcontact.Contact;
import java.util.*;

public class ContactManagement{
    ArrayList<Contact> al;
    public ContactManagement(){
        al=new ArrayList<Contact>();
    }
    public ContactManagement(ArrayList<Contact> al){
        this.al=al;
    }
    public void add(Contact x)throws DuplicateContactException{
        for(int i=0;i<al.size();i++)
            if(al.get(i).mobileno.equals(x.mobileno))
                throw new DuplicateContactException("Contact Already Exists\t"+al.get(i));
        al.add(x);   
    }
    public ArrayList<String> search(String name){
         ArrayList<String> temp=new ArrayList<String>();
         for(int i=0;i<al.size();i++){
                if(al.get(i).name.toLowerCase().indexOf(name)!=-1)
                    temp.add(al.get(i).name+"-"+al.get(i).mobileno);
         }
         return temp;
    }
    public ArrayList<Contact> display(){
        ArrayList<Contact> t=new ArrayList<Contact>(al);
        Contact temp;
        int i,j;
        for(i=0;i<t.size();i++)
            for(j=0;j<t.size()-1;j++){
                if(t.get(j).mobileno.compareTo(t.get(j+1).mobileno)>0){
                    temp=t.set(j,t.get(j+1));    
                    t.set(j+1,temp);
                }
            }
         return t;
    } 
    public String toString(){
        return al.toString();
    }
}
       