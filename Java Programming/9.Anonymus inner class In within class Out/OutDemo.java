//Interface
interface In{
    void display();
}

//Out
class Out{
    int x;
    Out(int x){
        this.x=x;
    }
    void display(){
        System.out.println("X="+x);
        new In(){
            int y=20;
            public void display(){
                System.out.println("Y="+y);
            }
        }.display();
    }
}

//OutDemo
class OutDemo{
    public static void main(String args[]){
        Out o=new Out(10);
        o.display();
    }
}