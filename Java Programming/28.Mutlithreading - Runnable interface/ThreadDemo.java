class Thread1 implements Runnable{
    Thread t;
    Thread1(){
        t=new Thread(this,"Thread1");
        t.start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(t.getName()+"\t10 x "+i+" = "+(10*i));
                Thread.sleep(500);
            }
        }catch(InterruptedException e){}
    }
}
    

class Thread2 implements Runnable{
    Thread t;
    Thread2(){
        t=new Thread(this,"Thread2");
        t.start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(t.getName()+"\t10 + "+i+" = "+(10+i));
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
        System.out.println(t1.t.getName()+"\tState = "+t1.t.getState()+"\tPriority = "+t1.t.getPriority());
        System.out.println(t2.t.getName()+"\tState = "+t2.t.getState()+"\tPriority = "+t2.t.getPriority());
        System.out.println(t.getName()+"\tState = "+t.getState()+" \tPriority = "+t.getPriority());
    }
}