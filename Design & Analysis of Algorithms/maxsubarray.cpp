#include <iostream>
#include<fstream>

using namespace std;

long int count=0;

int* find_max_cross_subarray(int* A,int low,int mid,int high);

int* find_max_subarray(int* A,int low,int high){
    if(low==high){
        int *rtn=new int[3];
        rtn[0]=low;rtn[1]=high;rtn[2]=A[low];
        return rtn;
    }
    else{
        int mid=(low+high)/2;
        int *l=find_max_subarray(A,low,mid);
        int l_low=l[0],l_high=l[1],l_sum=l[2];
        int *r=find_max_subarray(A,mid+1,high);
        int r_low=r[0],r_high=r[1],r_sum=r[2];
        int *c=find_max_cross_subarray(A,low,mid,high);
        int c_low=c[0],c_high=c[1],c_sum=c[2];
        if(l_sum>=r_sum and l_sum>=c_sum){
            int *rtn=new int[3];
            rtn[0]=l_low;rtn[1]=l_high;rtn[2]=l_sum;
            return rtn; 
        }
        else if(r_sum>=l_sum and r_sum>=c_sum){
            int *rtn=new int[3];
            rtn[0]=r_low;rtn[1]=r_high;rtn[2]=r_sum;
            return rtn; 
        }
        else{
            int *rtn=new int[3];
            rtn[0]=c_low;rtn[1]=c_high;rtn[2]=c_sum;
            return rtn; 
        }
    }
}


int* find_max_cross_subarray(int* A,int low,int mid,int high){
    int left_sum=-999999;
    int sum=0;
    int max_left,max_right;
    for(int i=mid;i>=low;i--){
        count++;
        sum+=A[i];
        if(sum>left_sum){
            left_sum=sum;
            max_left=i;
        }
    }
    int right_sum=-999999;
    sum=0;
    for(int j=mid+1;j<=high;j++){
        count++;
        sum+=A[j];
        if(sum>right_sum){
            right_sum=sum;
            max_right=j;
        }
    }
    int *rtn=new int[3];
    rtn[0]=max_left;rtn[1]=max_right;rtn[2]=left_sum+right_sum;
    return rtn; 
}

int main(){
	int n;
	cout<<"Enter the number of elements: ";
	cin>>n;
	int *A=new int[n];
	ifstream fin("input_maxSubarray.txt");
	for(int i=0;i<n;i++)fin>>A[i];
	fin.close();
	cout<<"[";
	for(int i=0;i<n;i++){
		cout<<A[i];
		if(i==n-1)break;
		cout<<",";
	}
	cout<<"]"<<endl;
	int *rtn=find_max_subarray(A,0,n-1);
	cout<<"\n[";
	for(int i=rtn[0];1;i++){
		cout<<A[i];
		if(i==rtn[1])break;
		cout<<",";
	}
	cout<<"]"<<endl;
	cout<<"Sum = "<<rtn[2]<<endl;
	cout<<"Total Number of Comparisons = "<<count<<endl;
	return 0;
}
