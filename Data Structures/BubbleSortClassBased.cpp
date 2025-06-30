#include<iostream>
using namespace std;


class bubblesort{
    private:
        int *list,n;
    public:
        void setdata(){
            cout<<"Enter The Number of Elements: ";
            cin>>n;
            list=new int[n];
            cout<<"Enter The Elements\n";
            for(int i=0;i<n;i++)
                cin>>*(list+i);}
        void bubblesort(){
            int current,walker;
            int last;
            last=n-1;
            bool sorted;
            current=0;
            sorted=false;
            while(current<=last && sorted==false){
                walker=last;
                sorted=true;
                while(walker>current){
                    if(list[walker]<*(list+walker-1)){
                        sorted=false;
                        int temp=list[walker];
                        *(list+walker)=*(list+walker-1);
                        *(list+walker-1)=temp;
                    }
                    walker--;
                }  
            current++;
            }
        }
        void display(){
             cout<<"Sorted list\n";
             for(int i=0;i<n;i++)
                 cout<<*(list+i)<<" ";
             cout<<endl;
        }
};


main(){
    bubblesort B1;
    B1.setdata();
    B1.bubblesort();
    B1.display();
}
