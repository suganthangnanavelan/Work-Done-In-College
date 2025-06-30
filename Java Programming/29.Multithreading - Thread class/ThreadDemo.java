class Thread1 extends Thread{
    Thread1(){
        super("Thread1");
        start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(getName()+"\t10 x "+i+" = "+(10*i));
                Thread.sleep(500);
            }
        }catch(InterruptedException e){}
    }
}

class Thread2 extends Thread{
    Thread2(){
        super("Thread1");
        start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(getName()+"\t10 x "+i+" = "+(10*i));
                Thread.sleep(500);
            }
        }catch(InterruptedException e){}
    }
}
class ThreadDemo{
    public static void main(String[] args){
        Thread t=Thread.currentThread();
        Thread1 t1=new Thread1();
        Thread2 t2=new Thread2();
        try{
            for(int i=0;i<5;i++){
              System.out.println(t.getName()+"\t10 - "+i+" = "+(10-i));
                Thread.sleep(500);
            }
        }catch(InterruptedException e){}
        System.out.println(t1.getName()+"\tState = "+t1.getState()+"\tPriority = "+t1.getPriority());
        System.out.println(t2.getName()+"\tState = "+t2.getState()+"\tPriority = "+t2.getPriority());
        System.out.println(t.getName()+"\tState = "+t.getState()+" \tPriority = "+t.getPriority());
    }
}