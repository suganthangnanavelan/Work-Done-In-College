package pkq;
public class Queue{
    private int a[],front,rear;
    boolean empty=true,full=false;
    public Queue(){
        a=new int[5];
        front=rear=-1; 
    }
    synchronized public void EnQueue(int data){
        while(full||rear==4)
            try{wait();}catch(InterruptedException e){}
        if(front==-1)
            front++;
        a[++rear]=data;
        System.out.println("Inserted = "+data);
        if(rear==4)full=true;
        empty=false;
        notify();
    }
    synchronized public int DeQueue(){
        while(empty)
            try{wait();}catch(InterruptedException e){}
        int data=a[front];
        System.out.println("Popped = "+data);
        if(rear==5)System.out.println("REar is five");
        if(front==rear)
            front=rear=-1; 
        front++;
        if(rear==-1)empty=true;
        full=false; 
        notify();
        return data;
    }
}