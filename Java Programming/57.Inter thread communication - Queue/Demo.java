import pkq.Queue;
import pkq.Consumer;
import pkq.Producer;
class Demo{
    public static void main(String[] args){
        Queue q=new Queue();
        Producer p=new Producer(q);
        Consumer c=new Consumer(q);
        p.t.start();
        c.t.start();
    }
}