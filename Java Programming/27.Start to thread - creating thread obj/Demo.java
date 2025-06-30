class Demo{
    public static void main(String[] args){
        Thread t=Thread.currentThread();
        try{
            for(int i=0;i<5;i++){
                System.out.println(t.getName()+"\t"+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Caught "+e);
        }
    }
}     