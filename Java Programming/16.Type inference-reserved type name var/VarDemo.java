import java.util.Scanner;
//Myclass
class Myclass{
    int x=10;
    void get(){
        System.out.println("X="+x);
    }
}
//Derived1
class Derived1 extends Myclass{
    int y=10;
    void get(){
        System.out.println("Y="+y);
    }
}
//Derived2
class Derived2 extends Derived1{
    int z=10;
    void get(){
        System.out.println("Z="+z);
    }
}
//VarDemo
class VarDemo{
    static Myclass getObject(int c){
        switch(c){
            case 1: return new Myclass();
            case 2: return new Derived1();
            default:return new Derived2();
        }
    }
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        var v=getObject(1);v.get();
        v=getObject(2);v.get();
        v=getObject(3);v.get();
    }
}






