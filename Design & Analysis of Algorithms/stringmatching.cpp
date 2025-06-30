#include<iostream>
using namespace std;

void naive(string T,string P,int& count){
	int flag;
	int n=T.length();
	int m=P.length();
	for(int s=0;s<=n-m;s++){
		flag=0;
		for(int j=0;j<m;j++){
			count++;
			if(P[j]!=T[s+j]){
				flag=1;
				break;
			}
		}
		if(flag==0)cout<<"Pattern occurs with valid shift = "<<s<<endl;
	}
}

int charcode(char c){
	switch(c){
		case 'A':return 1;
		case 'B':return 2;
		case 'C':return 3;
		case 'G':return 4;
		case 'T':return 5;
		case 'X':return 6;
		default:return 0;//to remove warning
	}
}

int preprocess(string P,int d,int q,int& precount){
	int p=0;
	int m=P.length();
	for(int i=0;i<m;i++){
		precount++;
		p=(d*p+charcode(P[i]))%q;
	}
	return p;
}

void RK_matcher(string T,string P,int p,int d,int q,int& count){
	int n=T.length();
	int m=P.length();
	int h=1;
	for(int i=1;i<=m-1;i++)h=(h*d)%q;
	int t0=0;
	for(int i=0;i<m;i++){
		count++;
		t0=(d*t0+charcode(T[i]))%q;
	}
	int ts=t0;
	for(int s=0;s<=n-m;s++){
		count++;
		if(p==ts){
		       	int flag=0;
			for(int j=0;j<m;j++){
				count++;
				if(P[j]!=T[s+j]){
					flag=1;
					break;
				}
			}
			if(flag==0);//cout<<"Pattern occurs with valid shift = "<<s<<endl;
		}
		if(s<n-m){
			int ts1=(d*(ts-charcode(T[s])*h)+charcode(T[s+m]))%q;
			if(ts1<0)ts1=(ts1+q)%q;
			ts=ts1;
		}
	}
					
}

void compute_prefix(string P,int pi[],int& count){
	int m=P.length();
	pi[0]=0;
	int k=0;
	for(int q=1;q<m;q++){
		count++;
		while(k>0 && P[k]!=P[q]){
			k=pi[k-1];
			count++;
		}
		if(P[k]==P[q])
			k++;
		pi[q]=k;
	}
}

void KMP_matcher(string T,string P,int pi[],int& count){
	int n=T.length();
	int m=P.length();
	int q=0;
	for(int i=0;i<n;i++){
		count++;
		while(q>0 && P[q]!=T[i]){
			q=pi[q-1];
			count++;
		}
		if(P[q]==T[i]){
			q++;
		}
		if(q==m){
			//cout<<"Pattern occurs with valid shift = "<<i-m+1<<endl;
			q=pi[q-1];
		}
	}
}

int main(){
	int ncount1,ncount2,ncount3;
	int rkcount1,rkcount2,rkcount3;
	int kmpcount1,kmpcount2,kmpcount3;
	int rkpre,kmppre;//no preprocess for naive
	int d=10,q=13;
	string T1[][3]={
		        {"ABABCABABACABABCCABABCABAB",
		         "ABABABCABABCABABCCABABABCABABABB",
		         "AABABCABCABABCABACABABCABABCABAC"},
		        {"GTGTXCGGGTXCGTXCGGGTXCGTXCGTCG",
		         "GTXCGGGTXCGTXCGGGGTXCGGGTXCGTXC",
		         "GGGTXCGGGTXCGTXCGGGTXCGGTXCGGGTXCGTXC"}
		       };
	string P1[]={"ABABCABAB","GTXCGGGTXCGTXC"};
	for(int i=0;i<2;i++){
		cout<<"Set"<<i+1<<"\n";
		ncount1=ncount2=ncount3=0;
		rkcount1=rkcount2=rkcount3=rkpre=0;
		kmpcount1=kmpcount2=kmpcount3=kmppre=0;
		cout<<"Pattern = "<<P1[i]<<"\n";
		cout<<"\nText1 = "<<T1[i][0]<<"\n";
		naive(T1[i][0],P1[i],ncount1);
		cout<<"\nText2 = "<<T1[i][1]<<"\n";
		naive(T1[i][1],P1[i],ncount2);
		cout<<"\nText3 = "<<T1[i][2]<<"\n";
		naive(T1[i][2],P1[i],ncount3);	
		
		int p=preprocess(P1[i],d,q,rkpre);
		RK_matcher(T1[i][0],P1[i],p,d,q,rkcount1);
		RK_matcher(T1[i][1],P1[i],p,d,q,rkcount2);
		RK_matcher(T1[i][2],P1[i],p,d,q,rkcount3);
		
		int pi[P1[i].length()];
		compute_prefix(P1[i],pi,kmppre);
		KMP_matcher(T1[i][0],P1[i],pi,kmpcount1);
		KMP_matcher(T1[i][1],P1[i],pi,kmpcount2);
		KMP_matcher(T1[i][2],P1[i],pi,kmpcount3);
		
		cout<<"\nAlgorithm\t\tPreprocess\tText1\tText2\tText3";	             
		cout<<"\nNaive\t\t\t"<<0<<"\t\t"<<ncount1<<"\t" <<ncount2<< "\t"<<ncount3<<"\n";
		cout<<"Rabin Karp(RK)\t\t"<<rkpre<< "\t\t" <<rkcount1<<"\t" << rkcount2<<"\t" << rkcount3<<"\n";
		cout<<"Knuth Morris Pratt(KMP)\t"<<kmppre<<"\t\t"<<kmpcount1<<"\t" <<kmpcount2<< "\t"<<kmpcount3<<"\n";
		cout<<"\n\n\n\n";
	}
	return 0;
}