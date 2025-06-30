//Inter
interface Inter{
    default void callback(){
        System.out.println("\nMethod Definition from Interface:Inter");
    }
}
//Demo1
class Demo1 implements Inter{
    public void callback(){
        System.out.println("\nMethod Definition from class:Demo1");
    }
}
//Demo2
class Demo2 implements Inter{}
//Demo
class Demo{
    public static void main(String args[]){
        Demo1 d1=new Demo1();
        d1.callback();
        Demo2 d2=new Demo2();
        d2.callback();
    }
}
