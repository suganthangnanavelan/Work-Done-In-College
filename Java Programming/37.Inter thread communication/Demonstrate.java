//Inter-Thread-Communication
/*
Only used for Synchronised Threads
One Thread can wait until other thread sends a signal.
waiting time will get reduced
one thread has control over other thread
//wait(),notify(),notifyAll()
wait()-it waits util some event to occur whereasfor example sleep() waits for some time that is given as argument
notify()-after completing the event it can notify the other thread to resume its exceution
notifyAll()-signals all other threads to resume their exceution

All are final and non-static
without common resource there is no synchronized threading
without synchronized execution there is no inter thread communication
"dead-lock" - even when the resources are free non of the threads try to access and they just infinitly wait for getting their requitred resource
*/

class Q{
    int n;
    boolean f=false;
    synchronized void put(int n){
        while(f)
        try{
            wait();
        }catch(InterruptedException e){}
        this.n=n;
        System.out.println("put..."+n);
        try{
            Thread.sleep(300);
        }catch(InterruptedException e){}
        f=true;
        notify();
    }
    synchronized int get(){
        while(!f)
        try{
            wait();
        }catch(InterruptedException e){}
        System.out.println("got..."+n);
        try{
            Thread.sleep(300);
        }catch(InterruptedException e){}
        f=false;
        notify();
        return n;
    }
}

class Producer implements Runnable{
    Q q;
    Thread t;
    Producer(Q q){
        this.q=q;
        t=new Thread(this,"Producer");
    }
    public void run(){
        int i=0;
        while(true)
            q.put(i++);
    }
}  

class Consumer implements Runnable{
    Q q;
    Thread t;
    Consumer(Q q){
        this.q=q;
        t=new Thread(this,"Consumer");
    }
    public void run(){
        while(true)
            q.get();
    }
}

class Demonstrate{
    public static void main(String[] args){
        Q q=new Q();
        Producer p=new Producer(q);
        Consumer c=new Consumer(q);
        p.t.start();
        c.t.start();   
    }
}