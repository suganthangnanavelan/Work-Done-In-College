#include<iostream>
#include<fstream>
#include<stdlib.h>
#include<time.h>
using namespace std;

const int limit=20;

void mcm_dynamic(int m[limit][limit],int s[limit][limit],int p[],int n,int& count){
	int i,j,k,l,q;
	for(i=1;i<=n;i++)
		m[i][i]=0;
	for(l=1;l<=n-1;l++){
		for(int i=1;i<=n-l;i++){
			j=i+l;
			m[i][j]=999999;
			for(k=i;k<=j-1;k++){
				count++;
				q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
				if(q<m[i][j]){
					m[i][j]=q;
					s[i][j]=k;
				}
			}
		}
	}
}

int mcm_divide_and_conquer(int p[],int i,int j,int& count){
	if(i==j)return 0;
	int t=999999;
	for(int k=i;k<=j-1;k++){
		count++;
		int q=mcm_divide_and_conquer(p,i,k,count)+mcm_divide_and_conquer(p,k+1,j,count)+p[i-1]*p[k]*p[j];
		if(q<t)t=q;
	}
	return t;	
	
}
void print(int s[limit][limit],int i,int j){
	if(i==j)
		cout<<"A"<<i<<"";
	else{
		cout<<"(";
		print(s,i,s[i][j]);
		print(s,s[i][j]+1,j);
		cout<<")";
	}
}

void rangen(){
	ofstream fout("input.txt");
	srand((long int)clock());
	for(int i=0;i<20;i++)
		fout<<rand()%30+1<<"\t";//range btw 1 to 30
	fout.close();
}

int main(){
	rangen();
	int n[]={5,7,10,12,15,17};//no of matrices
	cout<<"Input\tDivide & Conquer\tDynamic(Bottom up)\tCost\t\t\t\tMCM"<<endl;
	for(int i=0;i<6;i++){
		ifstream fin("input.txt");
		int p[n[i]+1];//dimension array
		for(int j=0;j<=n[i];j++)
			fin>>p[j];
		fin.close();
		int m[limit][limit],s[limit][limit];
		int count_dynprog=0,count_divconq=0;
		mcm_dynamic(m,s,p,n[i],count_dynprog);
		int cost=mcm_divide_and_conquer(p,1,n[i],count_divconq);//cost
		cout<<n[i]<<"\t"<<count_divconq<<"\t\t\t"<<count_dynprog<<"\t\t\t";
		cout<<cost<<"\t\t\t";
		print(s,1,n[i]);
		cout<<endl;
	}
	return 0;
}