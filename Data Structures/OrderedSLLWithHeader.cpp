#include <iostream>
using namespace std;
struct node{
    int data;
    node *link;
};
struct list{
    int count;
    node *head;
};
class SLL{
        list *Slist;
    public:
        SLL(){
            Slist=NULL;
        }
        void Createlist(){
            Slist=new list;
            Slist->count=0;
            Slist->head=NULL;
        }
        bool Search(node*& ppre,node*& ploc,int target){
            ploc=Slist->head;
            ppre=NULL;
            while(ploc!=NULL && target>ploc->data){
                ppre=ploc;
                ploc=ploc->link;
            }
            if(ploc==NULL)
                return false;
            else{
                if(target==ploc->data)
                   return true;
                else
                    return false;
            }
        }
        void Insert(node*& ppre,node*& ploc,int target){
            node *pnew=new node;
            pnew->data=target;
            if(ppre==NULL){
                pnew->link=ploc;
                Slist->head=pnew;
            }
            else{
                pnew->link=ploc;
                ppre->link=pnew;
            }
            Slist->count=Slist->count+1;
        }
        void Delete(node*& ppre,node*& ploc){
            if(ppre==NULL)
                Slist->head=ploc->link;
            else
                ppre->link=ploc->link;
            delete ploc;
            Slist->count=Slist->count-1;
        }
        bool Fulllist(){
            node *t=new node;
            if(t==NULL)
                return true;
            else{
                delete t;
                return false;
            }
        }
        bool Emptylist(){
            if(Slist->count==0)
                return true;
            else
                return false;
        }
        void Traversal(){
            node *temp=Slist->head;
            while(temp!=NULL){
                cout<<temp->data<<endl;
                temp=temp->link;
            }
        }
        void Destroylist(){
            node *temp;
            while(Slist->head!=NULL){
                temp=Slist->head;
                Slist->head=temp->link;
                delete temp;
                Slist->count=Slist->count-1;
            }
        }
};


main(){
    SLL S;
    S.Createlist();
    int op,data;
    cout<<"\t\t1.Insert\n\t\t2.Delete\n\t\t3.Search\n\t\t4.Empty";
    cout<<"\n\t\t5.Full\n\t\t6.Traversal\n\t\t7.Destroy\n\t\t8.Exit\n";
    node *ppre,*ploc;
    do{
        cout<<"Enter The Option: ";
        cin>>op;
        switch(op){
            case 1: cout<<"Enter The Data: ";
                    cin>>data;
                    if(S.Search(ppre,ploc,data))
                        cout<<"Can't Perform Insert, Data Already Exits";
                    else
                        S.Insert(ppre,ploc,data);
                    cout<<endl;
                    break;
            case 2: cout<<"Enter The Data: ";
                    cin>>data;
                    if(S.Search(ppre,ploc,data))
                        S.Delete(ppre,ploc);
                    else
                        cout<<"Cant Perform Delete, Data Doesn't Exist";
                    cout<<endl;
                    break;
            case 3: cout<<"Enter The Data: ";
                    cin>>data;
                    if(S.Search(ppre,ploc,data))
                        cout<<"Data Found";
                    else
                        cout<<"Data Not Found";
                    cout<<endl;
                    break;
            case 4: if(S.Emptylist())
                        cout<<"List is Empty";
                    else
                        cout<<"List is Not Empty";
                    cout<<endl;
                    break;
            case 5: if(S.Fulllist())
                        cout<<"List is Full";
                    else
                        cout<<"List is Not Full";
                    cout<<endl;
                    break;
            case 6: if(S.Emptylist())
                        cout<<"List is Empty"<<endl;
                    else
                        S.Traversal();
                    break;
            case 7: S.Destroylist();
                    cout<<"List is Destroyed";
                    cout<<endl;
                    break;
            case 8: cout<<"Program Ended";
                    cout<<endl;
                    break;
            default:cout<<"Invalid Choice";
                    cout<<endl;
        }
    }while(op!=8);
}