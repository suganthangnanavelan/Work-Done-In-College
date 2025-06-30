#include<iostream>
using namespace std;
#define SIZE 10
class Queue{
    int q[SIZE],rear,front;
    public:
        Queue(){
            front=rear=-1;
        }
        bool enqueue(int data){
            if(fullqueue())
                return false;
            else{
                rear++;
                q[rear]=data;
                if(front==-1)
                    front++;
                return true;
            }
        }
        bool dequeue(int &data){
            if(emptyqueue())
                return false;
            else{
                data=q[front];
                if(rear==front)
                    rear=front=-1;
                else
                    front++;
                return true;}
        }
        bool queuefront(int &data){
            if(emptyqueue())
                return false;
            else{
                data=q[front];
                return true;}
        }
        bool queuerear(int &data){
            if(emptyqueue())
                return false;
            else{
                data=q[rear];
                return true;}
        }
        void display(){
            for(int i=front;i<=rear;i++)
                cout<<q[i]<<endl;
        }
        bool fullqueue(){
            if(rear==SIZE-1)
                return true;
            else
                return false;
        }
        bool emptyqueue(){
            if(front==-1)
                return true;
            else
                return false;
        }
        bool queuecount(){
            if(emptyqueue())
                return 0;
            else
                return rear-front+1;
        }
};




main(){
    Queue Q;
    int op,data;
    cout<<"\t\t1.Enqueue\n\t\t2.Dequeue\n\t\t3.Queue Rear";
    cout<<"\n\t\t4.Queue Front\n\t\t5.Full Queue\n\t\t6.Empty Queue";
    cout<<"\n\t\t7.Queue Count\n\t\t8.Display\n\t\t9.Exit";
    do{
        cout<<"\nEnter The Option: ";
        cin>>op;
        switch(op){
        case 1:cout<<"Enter The Element: ";
               cin>>data;
               if(Q.enqueue(data))
                   cout<<"Element Added to The Queue";
               else
                   cout<<"Queue Overflow";
               break;
        case 2:if(Q.dequeue(data))
                   cout<<"Popped Element is "<<data;
               else
                   cout<<"Queue Underflow";
               break;
        case 3:if(Q.queuerear(data))
                   cout<<"Queue Rear is "<<data;
               else
                   cout<<"Queue is Empty";
               break;
        case 4:if(Q.queuefront(data))
                   cout<<"Queue Front is "<<data;
               else
                   cout<<"Queue is Empty";
               break;
        case 5:if(Q.fullqueue())
                   cout<<"Queue is Full";
               else
                   cout<<"Queue is Not Full";
               break;
        case 6:if(Q.emptyqueue())
                   cout<<"Queue is Empty";
               else
                   cout<<"Queue is Not Empty";
               break;
        case 7:cout<<"Queue Count is "<<Q.queuecount();
               break;
        case 8:if(Q.emptyqueue())
                   cout<<"Queue is Empty";
               else
                   Q.display();
               break;
        case 9:cout<<"Program Ended";
               break;
        default:cout<<"Invalid Option";
               break;
        }
        cout<<endl;
    }while(op!=9);
}
