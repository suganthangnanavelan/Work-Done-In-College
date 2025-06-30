#include<iostream>
using namespace std;


bool binarySearch(int list[],int last,int target,int& locn){
    int begin,mid,end;
    bool found;
    begin=0;
    end=last;
    while(begin<=end){
        mid=(begin+end)/2;
        if(target>list[mid])
            begin=mid+1;
        else if(target<list[mid])
            end=mid-1;
        else
            begin=end+1;
    }
    locn=mid;
    if(target==list[mid])
        found=true;
    else
        found=false;
    return found;
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
    if(binarySearch(list,n-1,target,location)){
      cout<<"Target Found at "<<location<<" Location";}
    else
      cout<<"Target Not Found";
    cout<<endl;
}
