class ThreadDemo extends Thread{
    int X;
    ThreadDemo(String name,int X){
        super(name);
        this.X=X;
    }
    public void run(){
        synchronized(System.out){
            for(int i=1;i<=10;i++){
                System.out.println(getName()+": "+X+" x "+i+" = "+(X*i));
                try{sleep(1000);}catch(InterruptedException e){}
            }
        }
    }
}

class Demo{
    public static void main(String[] args)throws InterruptedException{
        Thread t1=Thread.currentThread();
        ThreadDemo t2=new ThreadDemo("Thread1",2); 
        ThreadDemo t3=new ThreadDemo("Thread2",10); 
        t2.start();t3.start();
        synchronized(System.out){
            for(int i=1;i<=10;i++){
                System.out.println(t1.getName()+": "+5+" x "+i+" = "+(5*i));
                Thread.sleep(1000);
            }
        }
    }
}