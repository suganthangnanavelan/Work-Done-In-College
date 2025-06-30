//Test
class Test{
    int a;
    Test(){
        a=10;
    }
    Test(int a){
        this.a=a;
    }
    Test(Test t){
        this.a=(t.a++);
    }
    void update(){
        a+=10;
    }
    /*Test update(Test t){
         return new Test(this.a+t.a);
    }*/
    void update(Test t){
         this.a=(t.a++);
    }
    public String toString(){
        return "a="+a;
    }
}

//TestDemo
class TestDemo{ 
    public static void main(String args[]){
        Test t1=new Test();
        Test t2=new Test(5);
        //Test t3=new Test();
        System.out.println("Before: t1:"+t1+" t2:"+t2);
        t1.update();
        t2.update(t1);
        //t3=t2.update(t1);
        System.out.println("After: t1:"+t1+" t2:"+t2);   
    }
}
        
