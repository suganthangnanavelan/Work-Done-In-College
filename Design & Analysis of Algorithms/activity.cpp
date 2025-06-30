#include<iostream>
using namespace std;

void greedy_activity_selector(int a[],int s[],int f[],int n){
	int i=0;
	a[i++]=1;//activity one is always included
	int k=0;
	for(int m=1;m<n;m++)
		if(s[m]>=f[k]){
			a[i++]=m+1;//index + 1
			k=m;	
		}
}

void recursive_activity_selector(int a[],int i,int s[],int f[],int k,int n){
	int m=k+1;
	if(i==0)a[i++]=1;
	while(m<=n && s[m]<f[k])m++;
	if(m<n){
		a[i++]=m+1;
		recursive_activity_selector(a,i,s,f,m,n);
	}
}

int main(){
	int n=6;
	int s[]={1,3,0,5,5,8};
	int f[]={2,4,6,7,9,9};
	int a[n],b[n];
	for(int i=0;i<n;i++)a[i]=0;
	greedy_activity_selector(a,s,f,n);
	recursive_activity_selector(b,0,s,f,0,n);
	cout<<"Activity Selection\n";
	bool flag=true;
	cout<<"Greedy = {";
	for(int i=0;i<n;i++)
		if(a[i]!=0){
			if(flag){flag=false;}
			else cout<<",";
			cout<<"A"<<a[i];
		}
	cout<<"}"<<endl;
	flag=true;
	cout<<"Recursive = {";
	for(int i=0;i<n;i++)
		if(a[i]!=0){
			if(flag){flag=false;}
			else cout<<",";
			cout<<"B"<<b[i];
		}
	cout<<"}"<<endl;
	return 0;
}