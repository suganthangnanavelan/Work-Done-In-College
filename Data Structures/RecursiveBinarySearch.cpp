#include<iostream>
using namespace std;


bool RecursiveBinarySearch(int list[],int first,int last,int target,int& loc){
    int mid;
    if(last<first){
        loc=-1;
        return false;
    }
    else{
        mid=(first+last)/2;
        if(target<list[mid]){
            return RecursiveBinarySearch(list,first,mid-1,target,loc);}
        else if(target>list[mid]){
            return RecursiveBinarySearch(list,mid+1,last,target,loc);}
        else{
            loc=mid;
            return true;
        }
    }
}


main(){
    int n,target,location;
    cout<<"Enter The Number of Elements: ";
    cin>>n;
    int list[n];
    cout<<"Enter The Elements\n";
    for(int i=0;i<n;i++)
        cin>>list[i];
    cout<<"Enter The Target: ";
    cin>>target;
    if(RecursiveBinarySearch(list,0,n-1,target,location)){
      cout<<"Target Found at "<<location<<" Location";}
    else
      cout<<"Target Not Found";
    cout<<endl;
}