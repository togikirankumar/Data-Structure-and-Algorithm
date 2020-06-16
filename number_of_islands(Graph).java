import java.util.*;

class Graph{

    static boolean visited[][]=new boolean[5][5];

    public static boolean isSafe(int i,int j)
    {
        if((i>=0&&i<5)&&(j>=0&&j<5))
        {
            return true;
        }
        return false;
    }

    public static void dfs(int arr[][],int i,int j)
    {
        if(isSafe(i,j+1)&&(visited[i][j+1]==false)&&(arr[i][j+1]==1))
        {
            visited[i][j+1]=true;
            dfs(arr,i,j+1);
        }
        if(isSafe(i,j-1)&&(visited[i][j-1]==false)&&(arr[i][j-1]==1))
        {
            visited[i][j-1]=true;
            dfs(arr,i,j-1);
        }
        if(isSafe(i+1,j)&&(visited[i+1][j]==false)&&(arr[i+1][j]==1))
        {
            visited[i+1][j]=true;
            dfs(arr,i+1,j);
        }
        if(isSafe(i-1,j)&&(visited[i-1][j]==false)&&(arr[i-1][j]==1))
        {
            visited[i-1][j]=true;
            dfs(arr,i-1,j);
        }
        if(isSafe(i+1,j+1)&&(visited[i+1][j+1]==false)&&(arr[i+1][j+1]==1))
        {
            visited[i+1][j+1]=true;
            dfs(arr,i+1,j+1);
        }
        if(isSafe(i-1,j-1)&&(visited[i-1][j-1]==false)&&(arr[i-1][j-1]==1))
        {
            visited[i-1][j-1]=true;
            dfs(arr,i-1,j-1);
        }
        if(isSafe(i+1,j-1)&&(visited[i+1][j-1]==false)&&(arr[i+1][j-1]==1))
        {
            visited[i+1][j-1]=true;
            dfs(arr,i+1,j-1);
        }
        if(isSafe(i-1,j+1)&&(visited[i-1][j+1]==false)&&(arr[i-1][j+1]==1))
        {
            visited[i-1][j+1]=true;
            dfs(arr,i-1,j+1);
        }
    }

    public static void main(String[] args) {

        int arr[][]=new int[][]{{1,1,0,0,0},
                                {0,1,0,0,1},
                                {1,0,0,1,1},
                                {0,0,0,0,0},
                                {1,0,1,0,1}};
        int c=0;

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(arr[i][j]==1 && visited[i][j]==false)
                {
                    c++;
                    dfs(arr,i,j);
                }
            }
        }
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(c);
    }
}
