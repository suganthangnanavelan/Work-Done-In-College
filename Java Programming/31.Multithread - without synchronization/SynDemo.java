class CallMe{
    void call(String msg){
        System.out.print("[");
        System.out.print(msg);
        System.out.println("]");
    }
}

class Caller implements Runnable{
    CallMe targ;
    String msg;
    Thread t;
    Caller(CallMe targ,String msg){
        this.targ=targ;
        this.msg=msg;
        t=new Thread(this);
    }
    public void run(){
        targ.call(msg);
    }
}

class SynDemo{
    public static void main(String[] args){
        CallMe cr=new CallMe();
        Caller t1=new Caller(cr,"Welcome");
        Caller t2=new Caller(cr,"SASTRA");
        Caller t3=new Caller(cr,"Deemed University");
        t1.t.start();
        t2.t.start();
        t3.t.start();
    }
}

