//Single Linked List
#include<iostream>
using namespace std;


struct node{
    int data;
    node *link;
}; 
 
class SLL{
    private:
        node *first;
    public:
        SLL(){
            first=NULL;
        }
        void insertatbegin(int data){
            node *t=new node;
            t->data=data;
            t->link=first;
            first=t;
        }
        void insertatloc(int data,int loc){
            if(first==NULL)
                cout<<"SLL is Empty";
            else{
                node *temp=first;
                for(int i=1;i<loc-1&&temp->link!=NULL;i++)
                temp=temp->link;
                if(temp->link!=NULL&&loc!=1){
                node *t=new node;
                t->data=data;
                t->link=temp->link;
                temp->link=t;
                }
                else
                    cout<<"Invalid Location";
            }
         }    
        void insertatend(int data){
            node *t=new node;
            t->data=data;
            if(first==NULL){
                t->link=first;
                first=t;
            }
            else{
                node *temp=first;
                while(temp->link!=NULL){
                    temp=temp->link;}
                    temp->link=t;
                    t->link=NULL;
                }
        }
        void deleteatbegin(){
            if(first==NULL)
                cout<<"SLL is Empty";
            else{
                node *t=first;
                first=first->link;
                delete t;
            }
        }
        void deleteatloc(int loc){
            if(first==NULL)
                cout<<"SLL is Empty";
            else{
                node *temp=first;
                for(int i=1;i<loc-1;i++)
                    temp=temp->link;
                if(temp->link!=NULL&&loc!=1){
                node *t=temp->link;
                temp->link=t->link;
                delete t;
                }
                else
                    cout<<"Invalid Location";
            }
        }
        void traversal(){
            if(first==NULL)
                cout<<"SLL is Empty";
            else{
                node *temp=first;
                while(temp!=NULL){
                    cout<<"["<<temp->data<<"]"<<endl;
                    temp=temp->link;
                }
            }
        }
        bool Linearsearch(int target,int& locn){
            node *looker;
            bool found;
            looker=first;
            locn=1;
            while(looker->link!=NULL && target!=looker->data){
                looker=looker->link;
                locn++;
            }
            if(target==looker->data)    
                found=true;
            else
                found=false;
            return found;
        }
        void SLLreverse(){
            node *t1,*t2,*temp;
            t1=first;
            t2=t1->link;
            while(t2!=NULL){
                temp=t2->link;
                t2->link=t1;
                t1=t2;
                t2=temp;
            }
            first->link=NULL;
            first=t1;
            cout<<"SLL is Reversed";
        }
};


main(){
    SLL S;
    int op,data,loc;
    cout<<"\t\t1.Insert at Beginning\n\t\t2.Insert at Location";
    cout<<"\n\t\t3.Insert at End\n\t\t4.Delete at beginning";
    cout<<"\n\t\t5.Delete at Location\n\t\t6.Traversal";
    cout<<"\n\t\t7.Node Search\n\t\t8.SLL Reverse\n\t\t9.Exit";
    do{
        cout<<"\nEnter The Option: ";
        cin>>op;
        switch(op){
            case 1:cout<<"Enter The Data: ";
                   cin>>data;
                   S.insertatbegin(data);cout<<endl;
                   break;
            case 2:cout<<"Enter The Data: ";
                   cin>>data;
                   cout<<"Enter The Location: ";
                   cin>>loc;
                   S.insertatloc(data,loc);cout<<endl;
                   break;
            case 3:cout<<"Enter The Data: ";
                   cin>>data;
                   S.insertatend(data);cout<<endl;
                   break;
            case 4:S.deleteatbegin();cout<<endl;
                   break;
            case 5:cout<<"Enter The Location of The Node: ";
                   cin>>loc;
                   S.deleteatloc(loc);cout<<endl;
                   break;
            case 6:S.traversal();
                   break;
            case 7:cout<<"Enter The Element To Be Searched: ";;
                   cin>>data;
                   if(S.Linearsearch(data,loc))
                       cout<<"Element Found at "<<loc<<" Node";
                   else
                       cout<<"Element Not Found In The SLL";
                   cout<<endl;
                   break;
            case 8:S.SLLreverse();
                   break;
            case 9:cout<<"Program Ended";cout<<endl;
                   break;
            default:cout<<"Invalid Option";cout<<endl;
                   break;
        }
    }while(op!=9);
}
