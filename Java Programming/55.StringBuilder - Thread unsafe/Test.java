class ThreadA extends Thread{
    StringBuilder strbuild;
    ThreadA(StringBuilder strbuild){
        this.strbuild=strbuild;
    }
    public void run(){
        String s[]={" Object "," Oriented "," Programming "};
        int i=0;
        while(i<s.length){
            s[i]=s[i].toLowerCase();
            strbuild.append(s[i]);
            i++;
        }
    }
}

class ThreadB extends Thread{
    StringBuilder strbuild;
    ThreadB(StringBuilder strbuild){
        this.strbuild=strbuild;
    }
    public void run(){
        String s[]={" In "," JAVA "};
        int i=0;
        while(i<s.length){
            s[i]=s[i].toLowerCase();
            strbuild.append(s[i]);
            i++;
        }
    }
}

class Test{
    public static void main(String[] args)throws InterruptedException{
        StringBuilder str=new StringBuilder();
        ThreadA A=new ThreadA(str);
        ThreadB B=new ThreadB(str);
        A.start();B.start();
        A.join();B.join();
        System.out.println(str);
    }
}