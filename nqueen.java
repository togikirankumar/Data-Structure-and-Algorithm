import java.util.*;

class nqueen{

    public static boolean isPossible(int arr[][],int row,int col,int n)
    {
        for(int i=row-1;i>=0;i--)
        {
            if(arr[i][col]==1)
            {
                return false;
            }
        }
        int x=row;
        int y=col;
        while(x>=0 && y>=0)
        {
            if(arr[x][y]==1)
            {
                return false;
            }
            x--;
            y--;
        }
        x=row;
        y=col;
        while(x>=0 && y<n)
        {
            if(arr[x][y]==1)
            {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
    static int c=0;
    public static boolean cqueen(int arr[][],int row,int n)
    {
        if(row==n)
        {
            c++;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(arr[i][j]==1)
                    {
                        System.out.print(" Q ");
                    }
                    else{
                        System.out.print(" _ ");
                    }
                }
                System.out.println();
            }
            System.out.println("*******************************************");
            return true;
        }
        for(int col=0;col<n;col++)
        {
            if(isPossible(arr,row,col,n)){

                arr[row][col]=1;
                boolean ans=cqueen(arr, row+1, n);
                // if(ans)
                // {
                //     return true;
                // }
                arr[row][col]=0;
            }
        }
        return false;
    }  
    public static void main(String[] args) {
        
            int n=8;
            int arr[][]=new int[n][n];
            int r=4;
            boolean x=cqueen(arr,0,n);
            System.out.println(c);
    }
}