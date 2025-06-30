/*
suspend(), resume(), stop(), join()
stop()-thread gets terminated immediately
join()-thread gets terminated after completing its execution
suspend()-thread state is changed from runnable to blocked
resume()-thread state is changed from blocked to runnable
suspend() and resume() and stop() are depricated i.e 
they are not to be used but they are still there
sleep()-is not needed for multithreading in GUI
join()-
isalive()-return boolean based on the state of the thread invokiing it
getState()
getPriority()
*/

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
        while(true){
           System.out.println(d.format(LocalDateTime.now()));
           try{
           Thread.sleep(1000);
           }catch(InterruptedException e){}
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
        while(true){
            System.out.println(r.nextInt(1000));
            try{
            Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }        
}

class Demo{
    public static void main(String[] args){
        Time t1=new Time();
        MyRandom t2=new MyRandom();
        t1.t.start();
        t2.t.start();
    }
}





