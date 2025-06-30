#include<iostream>
#include<fstream>
#include <cstring>

using namespace std;

void countsort(int* A,int* B,int n,int k,int& count){
	int *C=new int[k+1];
	for(int i=0;i<=k;i++){
		count++;
		C[i]=0;
	}
	for(int j=1;j<=n;j++){
		count++;
		C[A[j]]=C[A[j]]+1;
	}
	for(int i=1;i<=k;i++){
		count++;
		C[i]=C[i-1]+C[i];
	}
	for(int j=n;j>=1;j--){
		count++;
		B[C[A[j]]]=A[j];
		C[A[j]]=C[A[j]]-1;
	}
}

int main(){
	int size[] = {10,50,100,500,1000,5000,10000};
	int count=0;
	for(int i=0; i<7; i++) {
		char fname[25]="input_csort_";
		char ext[2];
		ext[0] = '1'+i;
		ext[1] = '\0';
		strcat(fname, ext);
		strcat(fname,".txt");
		int n = size[i];
		int* a=new int[n],*b=new int[n];
		ifstream fin(fname);
		for(int i=0;i<n;i++)
			fin>>a[i];
		fin.close();
		int max=a[0];for(int i=1;i<n;i++)if(a[i]>max)max=a[i];
		countsort(a,b,n,max,count);
		char ofname[30]="output_csort_";
		strcat(ofname, ext);
		strcat(ofname,".txt");
		ofstream fout(ofname);
		for(int i=0;i<n;i++)
			fout<<b[i]<<"\t";
		fout.close();
		cout<<"Number of Comparisons for Size "<<n<<": "<<count<<endl;
	}
	return 0;
}
