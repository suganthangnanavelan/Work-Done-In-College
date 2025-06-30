//Test
class Test{
    final int x=10;
    void display(){
        System.out.println("X="+x);
    }
}

//TestDerived
class TestDerived extends Test{
    void display(){
        System.out.println("Derived:data="+x);
    }
}

//TestDemo
class TestDemo{
    public static void main(String args[]){
        //Test t=new Test();
        //t.display();//X=10
        TestDerived t=new TestDerived();
        t.display();//Derived:data=10
    }
}