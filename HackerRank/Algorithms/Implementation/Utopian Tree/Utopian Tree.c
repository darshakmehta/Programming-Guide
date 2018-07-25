#include <stdio.h>
 
int main(void) {
	int t,n,i,x,a;
	scanf("%d",&t);
	while(t--)
	{
        a=1;
		scanf("%d",&x);
		for(i=1;i<=x;i++)
        {
            if(i%2==0)
                {
                a++;
            }
            else
                a=a*2;
        }
	     printf("%d\n",a);
		
	}
	return 0;
}
