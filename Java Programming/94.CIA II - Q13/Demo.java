import java.util.Scanner;

class Demo{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str;
        System.out.print("Enter The String: ");
        str=scan.next();
        System.out.println("Entered String: "+str);
        System.out.println("Vowels in String");
        for(char c:str.toCharArray())
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
                 System.out.println(c+" ");
        String rstr="";
        for(int i=str.length()-1;i>=0;i--)
            rstr+=str.charAt(i);
        if(str.equals(rstr))
            System.out.println("Entered String Is A Palindrome");
        else
            System.out.println("Entered String Is Not A Palindrome");

        
    }
}