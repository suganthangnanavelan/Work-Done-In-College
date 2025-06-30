#include <iostream>
using namespace std;
struct node{
    int data;
    node *link;
};
struct Queue{
    int count;
    node *rear;
    node *front;
};
class QueueADT{
        Queue *Q;
    public:
        QueueADT(){
            Q=NULL;
        }
        void CreateQueue(){
            Q=new Queue;
            Q->count=0;
            Q->rear=NULL;
            Q->front=NULL;
        }
        bool EnQueue(int data){
            if(FullQueue())
                return false;
            else{
                node *t=new node;
                t->data=data;
                t->link=NULL;
                if(EmptyQueue())
                    Q->front=t;
                else
                    Q->rear->link=t;
                Q->rear=t;
                Q->count++;
                return true;
            }
        }
        bool DeQueue(int& data){
            if(EmptyQueue())
                return false;
            else{
                node *t=Q->front;
                data=t->data;
                if(Q->count==1)
                    Q->rear=NULL;
                Q->front=t->link;
                delete t;
                Q->count--;
                return true;
            }
        }
        bool QueueFront(int& data){
            if(EmptyQueue())
                return false;
            else{
                data=Q->front->data;
                return true;
            }
        }
        bool QueueRear(int& data){
            if(EmptyQueue())
                return false;
            else{
                data=Q->rear->data;
                return true;
            }
        }
        void Display(){
            node *temp=Q->front;
            while(temp!=NULL){
                cout<<temp->data<<endl;
                temp=temp->link;
            }
        }
        bool FullQueue(){
            node *t=new node;
            if(t==NULL)
                return true;
            else{
                delete t;
                return false;
            }
        }
        bool EmptyQueue(){
            if(Q->count==0)
                return true;
            else
                return false;
        }
        int QueueCount(){
            return Q->count;
        }
        void DestroyQueue(){
            node *temp;
            while(Q->front!=NULL){
                temp=Q->front;
                Q->front=temp->link;
                delete temp;
            }
            delete Q;
        }
};

main(){
    QueueADT Q;
    Q.CreateQueue();
    int op,data;
    cout<<"\t\t1.Enqueue\n\t\t2.Dequeue\n\t\t3.Queue Rear";
    cout<<"\n\t\t4.Queue Front\n\t\t5.Full Queue\n\t\t6.Empty Queue";
    cout<<"\n\t\t7.Queue Count\n\t\t8.Display\n\t\t9.Exit";
    do{
        cout<<"\nEnter The Option: ";
        cin>>op;
        switch(op){
        case 1: cout<<"Enter The Data: ";
                cin>>data;
                if(Q.EnQueue(data))
                    cout<<"Data Added to The Queue";
                else
                    cout<<"Queue Overflow";
                cout<<endl;
                break;
        case 2: if(Q.DeQueue(data))
                    cout<<"Popped Data is "<<data;
                else
                    cout<<"Queue Underflow";
                cout<<endl;
                break;
        case 3: if(Q.QueueRear(data))
                    cout<<"Queue Rear is "<<data;
                else
                    cout<<"Queue is Empty";
                cout<<endl;
                break;
        case 4: if(Q.QueueFront(data))
                    cout<<"Queue Front is "<<data;
                else
                    cout<<"Queue is Empty";
                cout<<endl;
                break;
        case 5: if(Q.FullQueue())
                    cout<<"Queue is Full";
                else
                    cout<<"Queue is Not Full";
                cout<<endl;
                break;
        case 6: if(Q.EmptyQueue())
                    cout<<"Queue is Empty";
                else
                    cout<<"Queue is Not Empty";
                cout<<endl;
                break;
        case 7: cout<<"Queue Count is "<<Q.QueueCount();
                cout<<endl;
                break;
        case 8: if(Q.EmptyQueue()){
                   cout<<"Queue is Empty";
                   cout<<endl;
                }
                else
                    Q.Display();
                break;
        case 9: Q.DestroyQueue();
                cout<<endl;
                break;
        default:cout<<"Invalid Option";
                cout<<endl;
                break;
        }
    }while(op!=9);
}