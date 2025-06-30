class Test{
    public static void main(String[] args){
        //StringBuilder is a String that is mutable i.e objects value can be changed and it is not thread safe
        //when multiple threads access same StringBuilder object there may be value mismatch that lead to unknown result because methods are not synchronized 
        //to create an empty StringBuilder object
        StringBuilder strbuild=new StringBuilder();//creates an empty StringBuilder with capacity by default as 16 characters(32 bytes)
        System.out.println("Empty String = "+"\""+strbuild+"\""+"  Capacity = "+strbuild.capacity());

        //to create an empty StringBuilder object with capacity as 100 characters
        strbuild=new StringBuilder(100);//creates an empty StringBuilder with capacity as 100 
        System.out.println("Empty String = "+"\""+strbuild+"\""+"  Capacity = "+strbuild.capacity());
 
        //conversion from String(immutable) to StringBuilder(mutable) not possible - incompatible types
        //strbuild="Object Oriented Programming";//this is an error
        //alternatively String can be passed as an argument to constructor
        strbuild=new StringBuilder("Object Oriented Programming In JAVA");
        System.out.println("StringBuilder = "+strbuild);
        System.out.println("StringBuilder in reverse = "+strbuild.reverse());
        strbuild.reverse();//reversing two times to get the original String
        System.out.println("Length = "+strbuild.length());
        System.out.println("Capacity = "+strbuild.capacity());
        System.out.println("SubStringBuilder = "+strbuild.substring(0,6));
        //Coverting StringBuilder to String
        String temp=new String(strbuild);
        System.out.println("StringBuilder Converted to String = "+temp);
        System.out.print("Increasing Capacity = ");
        strbuild.ensureCapacity(56);//Ensures that the capacity is at least equal to 56
        System.out.println(strbuild.capacity());
        //length can be updated using setLength()
        //if the given value is greater than the original length then only the length gets updated else StringBuilder gets truncated to given value 
        System.out.println("Increasing Length of StringBuilder");
        strbuild.setLength(40);//updates the length to the value given as argument
        System.out.println("StringBuilder = "+strbuild+"\nLength = "+strbuild.length());
        System.out.println("Decreasing Length of StringBuilder");
        strbuild.setLength(27);//updates the length to the value given as argument
        System.out.println("StringBuilder = "+strbuild+"\nLength = "+strbuild.length());
        System.out.println("Capacity(Before Triming) = "+strbuild.capacity());
        strbuild.trimToSize();//it attempts to reduce the storage used(removes unused storage space)
        System.out.println("Capacity(After Triming) = "+strbuild.capacity());
        System.out.println("First Index of 'e' = "+strbuild.indexOf("e"));
        System.out.println("Last Index of 'e' = "+strbuild.lastIndexOf("e"));
        System.out.println("Traversing the StringBuilder character by character");
        for(int i=0;i<strbuild.length();i++)
            System.out.print(strbuild.charAt(i)+" ");
        System.out.println("\n");
        //compareTo() to compare two StringBuilders 
        StringBuilder t1=new StringBuilder("JAVA");     
        StringBuilder t2=new StringBuilder("java");
        System.out.println("Comparing "+t1+" to "+t2+" = "+t1.compareTo(t2)+"\n");     
        System.out.println("StringBuilder = "+strbuild);
        //append can be used to append String, int, float, double, char, boolean etc.
        System.out.println("Appending \" In Java\" = "+strbuild.append(" In Java")+"\n");     
        //setCharAt(loc,char)
        System.out.println("StringBuilder = "+strbuild);  
        strbuild.setCharAt(0,'A');
        System.out.println("Changing character at 0 with 'A' = "+strbuild+"\n");     
        //insert can be used to insert at a particular index
        //insert can be used to insert String, int, float, double, char, boolean etc.   
        System.out.println("StringBuilder = "+strbuild);  
        System.out.println("Inserting \"Fully\" at 0 index = "+strbuild.insert(0,"Fully ")+"\n");
        System.out.println("StringBuilder = "+strbuild);     
        System.out.println("Inserting \"Object\" at 6 index = "+strbuild.insert(6,"Object")+"\n");
        System.out.println("StringBuilder = "+strbuild);  
        System.out.println("Deleting Character at index 43 = "+strbuild.deleteCharAt(43)+"\n");
        System.out.println("StringBuilder = "+strbuild);     
        System.out.println("Deleting from index 12 to 18 = "+strbuild.delete(12,18)+"\n");
        System.out.println("StringBuilder = "+strbuild);      
        System.out.println("Replace 'Fully Object' with 'Object' = "+strbuild.replace(0,12,"Object")+"\n");
        strbuild.delete(6,strbuild.length());
        System.out.println("StringBuilder(mutable) value gets changed = "+strbuild+"\n");
        StringBuilder t=new StringBuilder();
        System.out.println("StringBuilder = "+"\""+t+"\"");
        System.out.println("Appending 23(int) = "+t.append(23));
        System.out.println("Deleting 23 = "+"\""+t.delete(0,t.length())+"\"");
        System.out.println("Appending z(char) = "+t.append('z'));
        System.out.println("Deleting z = "+"\""+t.delete(0,t.length())+"\"");
        System.out.println("Appending 129.8228(float) = "+t.append(129.8228));
        System.out.println("Deleting 23 = "+"\""+t.delete(0,t.length())+"\"");
        System.out.println("Appending false(boolean) = "+t.append(false));
        System.out.println("Deleting false = "+"\""+t.delete(0,t.length())+"\"");
        System.out.println("Inserting 100(int) = "+t.insert(0,100));
        System.out.println("Inserting 1.123(float) at index 1 = "+t.insert(1,1.123));
        System.out.println("Inserting 'i'(char) at last = "+t.insert(t.length(),'i'));
        System.out.println("Inserting true(boolean) at begin = "+t.insert(0,true));
        System.out.println("Deleting from 4 to 12 = "+t.delete(4,12));
    }
}



