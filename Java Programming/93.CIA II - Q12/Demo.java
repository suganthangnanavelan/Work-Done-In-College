class Call{
     synchronized void display(String name){
         System.out.print("[");
         System.out.print("Hello");
         System.out.print("]");
         try{
             Thread.sleep(2000);
         }catch(InterruptedException e){}
         System.out.print("[");
         System.out.print("This is");
         System.out.print("]");
         System.out.print("[");
         System.out.print(name);
         System.out.println("]");
     }
}
class MultiThread extends Thread{
     Call target;
     MultiThread(Call target,String name){
         super(name);
         this.target=target;
     } 
     public void run(){
         target.display(this.getName());
     }
}

class Demo{
    public static void main(String[] args){
        Call cr=new Call();
        MultiThread t1=new MultiThread(cr,"Thread1");
        MultiThread t2=new MultiThread(cr,"Thread2");
        MultiThread t3=new MultiThread(cr,"Thread3");
        //starting all threads
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();//call waits until Thread1 terminates its execution
            t2.join();//call waits until Thread2 terminates its execution
            t3.join();//call waits until Thread3 terminates its execution
        }catch(InterruptedException e){}
    }
}