class Test{
    public static void main(String[] args){
        //String objects are immutable so it not possible to change its value
        //String class does not have a reverse method
        //therfore all member functions return the resultant String(substring,concat,etc..) 
        //conversion of byte[], int[], char[] to String objects
        byte by[]={74,65+32,86+32,65+32};//Java (ASCII value of characters)
        System.out.println(new String(by));//String constructor with byte[] as argument
        int in[]={74+32,68+32,75+32,50,48};//jdk20 (ASCII value of characters)
        System.out.println(new String(in,0,in.length));//String constructor with int[] as argument
        char ch[]={'P','r','o','g','r','a','m','m','i','n','g'};
        System.out.println(new String(ch));//String constructor with char[] as argument
        System.out.println();
        String str=new String("Object Oriented Programming");
        System.out.println("String = "+str);
        System.out.println("String(Lowercase) = "+str.toLowerCase());
        System.out.println("String(Uppercase) = "+str.toUpperCase());
        System.out.println("String is empty = "+str.isEmpty());
        System.out.println("Length = "+str.length());
        System.out.println("Substring = "+str.substring(0,6));
        System.out.println("Length of substring = "+str.substring(0,6).length());
        System.out.println("String concatenation = "+str.concat(" in java"));
        System.out.println("First Index of 'e' = "+str.indexOf('e'));
        System.out.println("Last Index of 'e' = "+str.lastIndexOf("e"));
        System.out.println("Traversing the String character by character");
        for(int i=0;i<str.length();i++)
            System.out.print(str.charAt(i)+" ");
        System.out.println();
        //equality should be checked between two strings using equals() instead of == operator
        //== operator checks whether the left and right operand refers the same object
        System.out.println("Substring equal to 'object' = "+str.substring(0,6).equals("object"));
        System.out.println("Substring equal to 'object' (Ignore case) = "+str.substring(0,6).equalsIgnoreCase("object"));
        System.out.println("String starts with 'java' = "+str.startsWith("java"));
        System.out.println("String starts with 'Obj' = "+str.startsWith("Obj"));
        System.out.println("String ends with 'ing' = "+str.endsWith("ing"));
        //region matches is used to compare 
        //a particular region of the invoking String object with a particular region of String argumnet
        //regionMatches(offsetof invoking obj, string x, offsetof string x, noofchars to compare) 
        //regionMatches(ignore case, offsetof invoking obj, string x, offsetof string x, noofchars to compare) 
        System.out.println("Region matching of \"Object\" with string(0(index),6(noofchars)) = "+str.regionMatches(0,"Object",0,6));
        String temp="hi program";
        System.out.println("Region matching of \"program\" with string(16(index),23(noofchars)) = "+str.regionMatches(16,temp,3,7));
        System.out.println("Region matching of \"program\" with string(16(index),23(noofchars))-Ignore case) = "+str.regionMatches(true,16,temp,3,7));
        System.out.println("Character at index 16 = "+str.charAt(16));
        System.out.println("Replace first 'O' with 'Q' = "+str.replaceFirst("O","Q"));
        System.out.println("Replace all 'O' with 'Q' = "+str.replaceAll("O","Q"));
        System.out.println("String spliting (delimiter = ' ')");
        String iterable[]=str.split(" ");//returns an String[]
        for(String x:iterable)
            System.out.print(x+"\n");//string concatenation using + operator
        //join() is a static method in String class
        System.out.println("Joining Strings (delimiter = '_') = "+String.join("_","Programming","in","java"));
        temp="   Programming in java   ";//there are two leading and trailing whitespace characters
        System.out.println("String = "+"\""+temp+"\"");
        System.out.println("Triming whitespaces = "+"\""+temp.trim()+"\"");
        System.out.println("Strip leading whitespaces = "+"\""+temp.stripLeading()+"\"");
        System.out.println("Strip trailing whitespaces = "+"\""+temp.stripTrailing()+"\"");
        System.out.println("Strip leading and trailing whitespaces = "+"\""+temp.strip()+"\"");
        //valueOf() is used to convert different types to String 
        System.out.println("Coverting 10(int) to String = "+String.valueOf(10));
        System.out.println("Coverting 1.234(float) to String = "+String.valueOf(1.234));
        System.out.println("Coverting 'x'(char) to String = "+String.valueOf('x'));
        System.out.println("Coverting true(boolean) to String = "+String.valueOf(true));
        //String class doesnt have a method to reverse a String
        //this is one way to reverse a String
        temp="hello";//not a palindrome
        System.out.println("String = "+temp);
        String rstr="";
        for(int i=temp.length()-1;i>=0;i--)
            rstr+=String.valueOf(temp.charAt(i));//charAt() returns a character to convert it into a String we use valueOf()
        System.out.println("String in reverse = "+rstr);
        temp="racecar";//palindrome
        System.out.println("String = "+temp);
        rstr="";
        for(int i=temp.length()-1;i>=0;i--)
            rstr+=String.valueOf(temp.charAt(i));//charAt() returns a character to convert it into a String we use valueOf()
        System.out.println("String in reverse = "+rstr);
        //converting String to byte[] using getBytes()
        temp="This was converted into a byte[]";
        byte bdata[]=temp.getBytes();
        //Byte[] is to be converted again to String to display
        System.out.print("String = ");
        for(var x:bdata)
            System.out.print((char)x);
        System.out.println();
        //coverting String to char[] can be done using getChars() or toCharArray(returns an array)
        char cdata[]=new char[50];
        temp="This was converted into a char[] using getChars()";
        //getChars(start,stop,destination,destination begin index)
        temp.getChars(5,temp.length(),cdata,0);
        System.out.print("String = ");
        for(var x:cdata)
            System.out.print(x);
        System.out.println();
        temp="This was converted into a char[] using toCharArray()";
        System.out.print("String = ");
        for(var x:temp.toCharArray())
            System.out.print(x);
        System.out.println();
        //As String is immutable the value of it remains same
        System.out.println("String value remains unchanged(immutable type) = "+str);
        //compareTo() to compare two Strings - used for sorting array of String objects
        String S[]={"IT","CSE","ICT","MECH","AIDS"};
        System.out.println("Unsorted Array");
        for(var x:S)
            System.out.print(x+"  ");
        System.out.println();
        for(int i=0;i<S.length;i++)
            for(int j=0;j<S.length;j++)
                if(S[i].compareTo(S[j])<0){
                    String t=S[i];
                    S[i]=S[j];
                    S[j]=t;
                }
        System.out.println("Sorted Array");
        for(var x:S)
            System.out.print(x+"  ");
        System.out.println();
    }     
}



