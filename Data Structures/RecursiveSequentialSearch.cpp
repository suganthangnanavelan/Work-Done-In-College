#include<iostream>
using namespace std;
bool RecursiveLinearSearch(int list[],int index,int last,int& locn,int target){
    if(index>last){
        locn=-1;
        return false;
    }
    if(target==list[index]){
        locn=index;
        return true;
    }
    return RecursiveLinearSearch(list,index+1,last,locn,target);
}


main(){
    int n,target,location,index=0;
    cout<<"Enter The Number of Elements: ";
    cin>>n;
    int list[n];
    cout<<"Enter The Elements\n";
    for(int i=0;i<n;i++)
        cin>>list[i];
    cout<<"Enter The Target: ";
    cin>>target;
    if(RecursiveLinearSearch(list,index,n-1,location,target)){
      cout<<"Target Found at "<<location<<" Location";}
    else
      cout<<"Target Not Found";
    cout<<endl;
}