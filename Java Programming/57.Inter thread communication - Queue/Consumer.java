package pkq;
import java.util.Random;

public class Consumer implements Runnable{
    Queue q;
    public Thread t;
    public Consumer(Queue q){
        this.q=q;
        t=new Thread(this,"Consumer");
   }
   public void run(){
       Random r=new Random();
       while(true){
           q.DeQueue();
           try{
               Thread.sleep(r.nextInt(1,2000));//waits randomly between 0.001 & 2 seconds
           }catch(InterruptedException e){}       }
   }
}
