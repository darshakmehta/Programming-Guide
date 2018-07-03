#include<stdio.h>
#include <iostream>
using namespace std;
#define size 1000000
long long int s[size],c[size];
int compare (const void * a, const void * b)
{
  return ( *(int*)a - *(int*)b );
}
int main()
{
    	long long int i,j,n,sum;
	scanf("%lld",&n);
	for(i=0;i<n;i++)
	scanf("%lld",&s[i]);
	for(i=0;i<n;i++)
	scanf("%lld",&c[i]);
	qsort(s,n,sizeof(long long int),compare);
	qsort(c,n,sizeof(long long int),compare);
	sum=0;
	for(i=0;i<n;i++)
	{
		sum+=s[i]*c[i];
	}
	printf("%lld\n",sum);
	return 0;
}