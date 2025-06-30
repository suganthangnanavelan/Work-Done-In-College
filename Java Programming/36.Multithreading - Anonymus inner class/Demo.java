class Test{
    void display(){
        new Thread(){
            public void run(){
                for(int i=0;i<3;i++)
                    System.out.println("i = "+i);
            }
        }.start();
    }
}

class Demo{
    public static void main(String[] args){
        Test t=new Test();
        t.display();
    }
}