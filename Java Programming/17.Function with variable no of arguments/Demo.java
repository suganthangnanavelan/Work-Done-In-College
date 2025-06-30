//Demo
class Demo{
    static void display(String v[]){
        System.out.println("\nNo of Arguments: "+v.length);
        for(String x:v)
            System.out.println(x);
    }  
    static void display(int...v){
        System.out.println("\nNo of Arguments: "+v.length);
        for(int x:v)
            System.out.println(x);
    }
    public static void main(String args[]){
        String s1[]={"CSE","IT","ICT","AIDS"};
        display(100,200,300,400,500);
        display(s1);
    }
}
    
