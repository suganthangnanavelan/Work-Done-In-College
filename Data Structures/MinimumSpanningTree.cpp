#include<iostream>
using namespace std;


struct ga;
struct gv{
    gv* nextvertex;
    char name;
    bool intree;
    ga* firstarc;
};


struct ga{
    gv* adj;
    int weight;
    ga* link;
};

class Span{
    gv* first;
  public:
    Span(){
        first=NULL;
    }
    void insertVertex(char d){
        gv* nn=new gv;
        nn->nextvertex=NULL;
        nn->name=d;
        nn->intree=false;
        nn->firstarc=NULL;
        if(first==NULL)
            first=nn;
        else{
            gv* temp=first;
            while(temp->nextvertex!=NULL) 
                temp=temp->nextvertex;
            temp->nextvertex=nn;
        }
    }
    void insertArc(char d1,char d2,int w){
        gv *temp1,*temp2;
        temp1=first;
        temp2=first;
        while(temp1!=NULL&&temp1->name!=d1) 
            temp1=temp1->nextvertex;
        while(temp2!=NULL&&temp2->name!=d2) 
            temp2=temp2->nextvertex;
        if(temp1==NULL||temp2==NULL)
            cout<<"Wrong Entry"<<endl;
        else{
            ga* nn=new ga;
            nn->adj=temp2;
            nn->weight=w;
            nn->link=temp1->firstarc;
            temp1->firstarc=nn;
            nn=new ga;
            nn->adj=temp1;
            nn->weight=w;
            nn->link=temp2->firstarc;
            temp2->firstarc=nn;
        }
    }
    void display(){
        gv* v=first;
        while(v!=NULL){
            ga* a=v->firstarc;
            cout<<v->name<<"->";
            while(a!=NULL){
                cout<<a->adj->name<<",";
                a=a->link;
            }
            cout<<"null"<<endl;
            v=v->nextvertex;
        }
    }
    void mst(){ 
        if(first==NULL)return; 
        gv* temp=first;
        while(temp!=NULL){
            temp->intree=false;
            temp=temp->nextvertex;
        }
        temp=first;
        bool treecomp=false;
        temp->intree=true;
        int sum=0;
        while(!treecomp){
            treecomp=true;
            int minedge=9999;
            gv* src=NULL;
            ga* minedgeloc=NULL;
            temp=first;
            while(temp!=NULL){
                if(temp->intree==true&&temp->firstarc!=NULL){
                    ga* a=temp->firstarc;
                    while(a!=NULL){
                        if(a->adj->intree==false){
                            treecomp=false;
                            if(a->weight<minedge){
                                minedge=a->weight;
                                minedgeloc=a;
                                src=temp;
                            }
                         }
                         a=a->link;
                    } 
                 }
                 temp=temp->nextvertex;
             }
             if(minedgeloc!=NULL){
                 sum+=minedge;
                 minedgeloc->adj->intree=true;
                 cout<<src->name<<"---"<<minedge<<"---"<<minedgeloc->adj->name <<endl;
             }
         }
         cout<<"Cost of MST = "<<sum<<endl;
    }
};

    
main(){
    Span gph;
    char op,data1,data2;
    int weight;
    cout<<"\t\t1.Insert Vertex\n\t\t2.Insert Arc\n\t\t3.Display\n\t\t4.Minimum Spanning Tree\n\t\t5.Exit\n";
    do{
        cout<<"Enter The Choice: ";
        cin>>op;
        switch(op){
            case '1':cout<<"Enter Vertex: ";
                    cin>>data1;
                    gph.insertVertex(data1);
                    break;
            case '2':cout<<"Enter Edge: ";
                    cin>>data1>>data2;
                    cout<<"Enter Weight of the Edge: ";
                    cin>>weight;
                    gph.insertArc(data1,data2,weight);
                    break;				   
            case '3':gph.display();
                    cout<<endl;
                    break; 
            case '4':gph.mst();
                    break;
            case '5':cout<<"Exited"<<endl;
                    break;
            default:cout<<"Invalid Choice"<<endl;
        }
    }while(op!='5');
}