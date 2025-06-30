#include <iostream>
using namespace std;
struct node{
    int data;
    node *link;
};
struct Stack{
    int count;
    node *top;
};
class StackADT{
        Stack *S;
    public:
        StackADT(){
            S=NULL;
        }
        void CreateStack(){
            S=new Stack;
            S->count=0;
            S->top=NULL;
        }
        bool PushStack(int data){
            if(StackFull())
                return false;
            else{
                node *t=new node;
                t->data=data;
                t->link=S->top;
                S->top=t;
                S->count++;
                return true;
            }
        }
        bool PopStack(int& data){
            if(StackEmpty())
                return false;
            else{
                node *t=S->top;
                data=t->data;
                S->top=t->link;
                delete t;
                S->count--;
                return true;
            }
        }
        bool StackTop(int& data){
            if(StackEmpty())
                return false;
            else{
                data=S->top->data;
                return true;
            }
        }
        void Display(){
            node *temp=S->top;
            while(temp!=NULL){
                cout<<temp->data<<endl;
                temp=temp->link;
            }
        }
        bool StackFull(){
            node *t=new node;
            if(t==NULL)
                return true;
            else{
                delete t;
                return false;
            }
        }
        bool StackEmpty(){
            if(S->count==0)
                return true;
            else
                return false;
        }
        void DestroyStack(){
            node *temp;
            while(S->top!=NULL){
                temp=S->top;
                S->top=temp->link;
                delete temp;
            }
            delete S;
        }
};


main(){
    StackADT S;
    S.CreateStack();
    int op,data;
    cout<<"\t\t1.Push\n\t\t2.Pop\n\t\t3.Stack Top\n\t\t4.Stack Full";
    cout<<"\n\t\t5.Stack Empty\n\t\t6.Display\n\t\t7.Exit";
    do{
        cout<<"\nEnter The Option: ";
        cin>>op;
        switch(op){
        case 1: cout<<"Enter The Data: ";
                cin>>data;
                if(S.PushStack(data))
                    cout<<"Data Added to The Stack";
                else
                    cout<<"Stack Overflow";
                cout<<endl;
                break;
        case 2: if(S.PopStack(data))
                    cout<<"Popped Data is "<<data;
                else
                    cout<<"Stack Underflow";
                cout<<endl;
                break;
        case 3: if(S.StackTop(data))
                    cout<<"Stack Top is "<<data;
                else
                    cout<<"Stack is Empty";
                cout<<endl;
                break;
        case 4: if(S.StackFull())
                    cout<<"Stack is Full";
                else
                    cout<<"Stack is Not Full";
                cout<<endl;
                break;
        case 5: if(S.StackEmpty())
                    cout<<"Stack is Empty";
                else
                    cout<<"Stack is Not Empty";
                cout<<endl;
                break;
        case 6: if(S.StackEmpty()){
                    cout<<"Stack is Empty";
                    cout<<endl;
                }
                else
                    S.Display();
                break;
        case 7: S.DestroyStack();
                cout<<endl;
                break;
        default:cout<<"Invalid Option";
                cout<<endl;
                break;
        }
    }while(op!=7);
}
