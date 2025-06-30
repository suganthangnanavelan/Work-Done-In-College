class Test{
    public static void main(String[] args){
        //StringBuffer is a String that is mutable i.e objects value can be changed and it is not thread safe
        //multiple threads access same StringBuffer object there may be value mismatch becaus methods are synchronized 
        //to create an empty StringBuffer object
        StringBuffer buffstr=new StringBuffer();//creates an empty StringBuffer with capacity by default as 16 characters(32 bytes)
        System.out.println("Empty String = "+"\""+buffstr+"\""+"  Capacity = "+buffstr.capacity());

        //to create an empty StringBuffer object with capacity as 100 characters
        buffstr=new StringBuffer(100);//creates an empty StringBuffer with capacity as 100 
        System.out.println("Empty String = "+"\""+buffstr+"\""+"  Capacity = "+buffstr.capacity());
 
        //conversion from String(immutable) to StringBuffer(mutable) not possible - incompatible types
        //buffstr="Object Oriented Programming";//this is an error
        //alternatively String can be passed as an argument to constructor
        buffstr=new StringBuffer("Object Oriented Programming In JAVA");
        System.out.println("StringBuffer = "+buffstr);
        System.out.println("StringBuffer in reverse = "+buffstr.reverse());
        buffstr.reverse();//reversing two times to get the original String
        System.out.println("Length = "+buffstr.length());
        System.out.println("Capacity = "+buffstr.capacity());
        System.out.println("SubStringBuffer = "+buffstr.substring(0,6));
        //Coverting StringBuffer to String
        String temp=new String(buffstr);
        System.out.println("StringBuffer Converted to String = "+temp);
        System.out.print("Increasing Capacity = ");
        buffstr.ensureCapacity(56);//Ensures that the capacity is at least equal to 56
        System.out.println(buffstr.capacity());
        //length can be updated using setLength()
        //if the given value is greater than the original length then only the length gets updated else StringBuffer gets truncated to given value 
        System.out.println("Increasing Length of StringBuffer");
        buffstr.setLength(40);//updates the length to the value given as argument
        System.out.println("StringBuffer = "+buffstr+"\nLength = "+buffstr.length());
        System.out.println("Decreasing Length of StringBuffer");
        buffstr.setLength(27);//updates the length to the value given as argument
        System.out.println("StringBuffer = "+buffstr+"\nLength = "+buffstr.length());
        System.out.println("Capacity(Before Triming) = "+buffstr.capacity());
        buffstr.trimToSize();//it attempts to reduce the storage used(removes unused storage space)
        System.out.println("Capacity(After Triming) = "+buffstr.capacity());
        System.out.println("First Index of 'e' = "+buffstr.indexOf("e"));
        System.out.println("Last Index of 'e' = "+buffstr.lastIndexOf("e"));
        System.out.println("Traversing the StringBuffer character by character");
        for(int i=0;i<buffstr.length();i++)
            System.out.print(buffstr.charAt(i)+" ");
        System.out.println("\n");
        //compareTo() to compare two StringBuffers 
        StringBuffer t1=new StringBuffer("JAVA");     
        StringBuffer t2=new StringBuffer("java");
        System.out.println("Comparing "+t1+" to "+t2+" = "+t1.compareTo(t2)+"\n");     
        System.out.println("StringBuffer = "+buffstr);
        //append can be used to append String, int, float, double, char, boolean etc.
        System.out.println("Appending \" In Java\" = "+buffstr.append(" In Java")+"\n");     
        //setCharAt(loc,char)
        System.out.println("StringBuffer = "+buffstr);  
        buffstr.setCharAt(0,'A');
        System.out.println("Changing character at 0 with 'A' = "+buffstr+"\n");     
        //insert can be used to insert at a particular index
        //insert can be used to insert String, int, float, double, char, boolean etc.   
        System.out.println("StringBuffer = "+buffstr);  
        System.out.println("Inserting \"Fully\" at 0 index = "+buffstr.insert(0,"Fully ")+"\n");
        System.out.println("StringBuffer = "+buffstr);     
        System.out.println("Inserting \"Object\" at 6 index = "+buffstr.insert(6,"Object")+"\n");
        System.out.println("StringBuffer = "+buffstr);  
        System.out.println("Deleting Character at index 43 = "+buffstr.deleteCharAt(43)+"\n");
        System.out.println("StringBuffer = "+buffstr);     
        System.out.println("Deleting from index 12 to 18 = "+buffstr.delete(12,18)+"\n");
        System.out.println("StringBuffer = "+buffstr);      
        System.out.println("Replace 'Fully Object' with 'Object' = "+buffstr.replace(0,12,"Object")+"\n");
        buffstr.delete(6,buffstr.length());
        System.out.println("StringBuffer(mutable) value gets changed = "+buffstr+"\n");
        StringBuffer t=new StringBuffer();
        System.out.println("StringBuffer = "+"\""+t+"\"");
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



