import java.util.*;

class dp{

    ///fib
   public static int fib(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static int fibMemo(int n,int []dp)
    {
        if(n==1 || n==0)
        {   
            dp[n]=n;
            return n;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int r=fibMemo(n-1,dp)+fibMemo(n-2,dp);
        dp[n]=r;
        return r;
    }
    public static int fibDP(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }



    //Reduce to one by n/3 or n/2 or n-1
    public static int reduceToOne(int n)
    {
        if(n==1)
        {
            return 0;
        }
        int f=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        int t=Integer.MAX_VALUE;

        if(n%3==0)
        {
            f=reduceToOne(n/3);
        }
        if(n%2==0)
        {
            s=reduceToOne(n/2);
        }
        t=reduceToOne(n-1);

        int ans=Math.min(f,Math.min(s,t))+1;
        return ans;
    }
    public static int reduceToOneMemo(int n,int []dp)
    {
        if(n==1)
        {
            dp[n]=1;
            return 0;
        }
        int f=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        int t=Integer.MAX_VALUE;

        if(dp[n]!=-1)
        {
            return dp[n];
        }
        if(n%3==0)
        {
            f=reduceToOneMemo(n/3,dp);
        }
        if(n%2==0)
        {
            s=reduceToOneMemo(n/2,dp);
        }
        t=reduceToOneMemo(n-1,dp);

        int ans=Math.min(f,Math.min(s,t))+1;
        dp[n]=ans;
        
        return ans;
    }
    public static int reduceToOneDP(int n)
    {
        int dp[]=new int[n+1];
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
        
        for(int i=4;i<=n;i++)
        {
            int c1=Integer.MAX_VALUE;
            int c2=Integer.MAX_VALUE;
            int c3=Integer.MAX_VALUE;

            c1=dp[i-1];
            if(i%3==0)
            {
                c2=dp[i/3];
            }
            if(i%2==0)
            {
                c3=dp[i/2];
            }
            dp[i]=Math.min(c1,Math.min(c2,c3))+1;


        }
        return dp[n];
    }



    ///count board path

    public static int countBoardPath(int start,int end)
    {
        if(start==end)
        {
            return 1;
        }
        if(start>end)
        {
            return 0;
        }
        int c=0;
        for(int i=1;i<=6;i++)
        {
            c+=countBoardPath(start+i, end);
        }
        return c;
    }
    public static int countBoardPathMemo(int start,int end,int dp[])
    {
        if(start==end)
        {
            dp[start]=1;
            return 1;
        }
        if(start>end)
        {
            
            return 0;
        }
        int c=0;
        
        if(dp[start]!=-1)
        {
            return dp[start];
        }

        for(int i=1;i<=6;i++)
        {
            c+=countBoardPathMemo(start+i, end,dp);
            
        }
        dp[start]=c;

        for(int i=0;i<=10;i++)
        {
            System.out.print(dp[i]+"\t");
        }
        
        System.out.println();

        return c;
    }

    public static int countBoardPathDP(int start,int end)
    {
        int n=end;
        int dp[]=new int[n+1];
        dp[n]=1;
        for(int i=n;i>=0;i--)
        {
            for(int j=1;j<=6;j++)
            {
                if(i+j>end)
                {
                    break;
                }
                dp[i]+=dp[i+j];
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        
        int x,n=10;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        //x=fibDP(n);
        //x=reduceToOneDP(n);
        x=countBoardPathDP(0, n);
        System.out.println(x);

    }
}