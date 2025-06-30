import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Time implements Runnable{
    Thread t;
    Time(){
        t=new Thread(this,"Time");
    }
    public void run(){
        DateTimeFormatter d=DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm:ss");
        int i=0;
        while(i<10){
           System.out.println(d.format(LocalDateTime.now()));
           try{
           Thread.sleep(1000);
           }catch(InterruptedException e){}
           i++;
        }
    }
}
       
class MyRandom implements Runnable{
    Thread t;
    MyRandom(){
        t=new Thread(this,"Random");
    }
    public void run(){
        Random r=new Random();
        int i=0;
        while(i<10){
            System.out.println(r.nextInt(1000));
            try{
            Thread.sleep(100);
            }catch(InterruptedException e){}
        i++;
        }
    }        
}


class Demo{
    public static void main(String[] args){
        Time t1=new Time();
        MyRandom t2=new MyRandom();
        t1.t.setPriority(Thread.MIN_PRIORITY);
        t1.t.start();

        System.out.println(t1.t.getName()+":  State = "+t1.t.getState()+" IsAlive = "+t1.t.isAlive()+"  Priority = "+t1.t.getPriority());
        System.out.println(t2.t.getName()+":  State = "+t2.t.getState()+" IsAlive = "+t2.t.isAlive()+"  Priority = "+t2.t.getPriority());

        try{
                   t1.t.join();
        }catch(InterruptedException e){}

        System.out.println(t1.t.getName()+":  State = "+t1.t.getState()+" IsAlive = "+t1.t.isAlive()+"  Priority = "+t1.t.getPriority());
        System.out.println(t2.t.getName()+":  State = "+t2.t.getState()+" IsAlive = "+t2.t.isAlive()+"  Priority = "+t2.t.getPriority());

        t2.t.start();

        System.out.println(t1.t.getName()+":  State = "+t1.t.getState()+" IsAlive = "+t1.t.isAlive()+"  Priority = "+t1.t.getPriority());
        System.out.println(t2.t.getName()+":  State = "+t2.t.getState()+"  IsAlive = "+t2.t.isAlive()+"  Priority = "+t2.t.getPriority());
    }
}