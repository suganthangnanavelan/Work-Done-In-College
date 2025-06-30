#include<iostream>
#include<fstream>
#include<math.h>
using namespace std;

long int count=0;
int d;

void countsort(int* A,int n,int k);

int getdigit(int num,int i){
	num/=pow(10,i-1);
	return num%10;
}

void radixsort(int A[],int m,int n){
	for(d=1;d<=m;d++)
		countsort(A,n,9);
}

void countsort(int* A,int n,int k){
	int *C=new int[k+1];
	int *B=new int[n+1];
	for(int i=0;i<=k;i++){
		count++;
		C[i]=0;
	}
	for(int j=1;j<=n;j++){
		count++;
		C[getdigit(A[j],d)]=C[getdigit(A[j],d)]+1;
	}
	for(int i=1;i<=k;i++){
		count++;
		C[i]=C[i-1]+C[i];
	}
	for(int j=n;j>=1;j--){
		count++;
		B[C[getdigit(A[j],d)]]=A[j];
		C[getdigit(A[j],d)]=C[getdigit(A[j],d)]-1;
	}
	for(int i=1;i<=n;i++){A[i]=B[i];}
	delete(C);
}

main(){
	int n;
	ifstream  fin("input_rsort.txt");
	cout<<"Enter The Size: ";
	cin>>n;
	int A[n+1],B[n+1];
	for(int i=1;i<=n;i++){//4 digits
		fin>>A[i];
	}
	radixsort(A,4,n);
	ofstream fout("output_rsort.txt");
	for(int i=1;i<=n;i++)
		fout<<A[i]<<"\t";
	cout<<"Number of Comparisons Performed = "<<count<<endl;	
}
