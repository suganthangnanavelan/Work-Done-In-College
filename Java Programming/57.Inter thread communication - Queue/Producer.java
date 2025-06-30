package pkq;
import java.util.Random;

public class Producer implements Runnable{
    Queue q;
    public Thread t;
    public Producer(Queue q){
        this.q=q;
        t=new Thread(this,"Producer");
   }
   public void run(){
       Random r=new Random();
       while(true){
           q.EnQueue(r.nextInt(100));      
           try{
               Thread.sleep(r.nextInt(1,2000));//waits randomly between 0.001 & 2 seconds
           }catch(InterruptedException e){}
       }
   }
}

   
    