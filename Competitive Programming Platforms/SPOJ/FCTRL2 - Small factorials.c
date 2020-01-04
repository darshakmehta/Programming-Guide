#include<stdio.h>
inline long long int scan()
{
    long long int n=0;
    char ch=getchar_unlocked();
    while(ch<'0'||ch>'9')
        ch=getchar_unlocked();
    while(ch>='0'&&ch<='9')
    {
        n=(n<<3)+(n<<1)+ch-'0';
        ch=getchar_unlocked();
    }
    return n;
}
int main()
{
    int t,a[200],n,temp,m,i,j,x;
   	t=scan();
    while(t--)
    {
        n=scan();
        temp=0;
        a[0]=1,m=1;
        if(n!=1)
        for(i=2;i<=n;i++)
        {
            temp=0;
            for(j=0;j<m;j++)
            {
                x=a[j]*i+temp;
                a[j]=x%10;
                temp=x/10;
            }
            while(temp)
            {
                m=m+1;
                a[m-1]=temp%10;
                temp=temp/10;
            }
        }
    for(i=m-1;i>=0;i--)
        printf("%d",a[i]);
    printf("\n");
    }
    return 0;
}  