class Maze{

    public static boolean isPath(int mz[][],int n,int i,int j){

        if(i>=n || j>=n || mz[i][j]==1)
        {
            return false;
        }
        if(i==n-1 && j==n-1)
        {
           
            return true;
        }
        
        mz[i][j]=1;
        boolean r=isPath(mz, n, i+1, j);
        boolean d=isPath(mz, n, i, j+1);
        return d||r;
    } 

    public static void printPath(int mz[][],int sol[][],int n,int i,int j){

        if(i>=n || j>=n)
        {   
        
            return;
        }
        if(mz[i][j]==1)
        {
            sol[i][j]=-1;
            return;
        }
        if(i==n-1 && j==n-1)
        {
           for(int x=0;x<n;x++)
           {
               for(int y=0;y<n;y++)
               {
                   System.out.print(sol[x][y]);
               }
               System.out.println();
           }
           System.out.println("****************");
            return;
        }
        
        sol[i][j]=1;
        printPath(mz,sol, n, i+1, j);
        printPath(mz,sol, n, i, j+1);
        sol[i][j]=0;
    } 
    public static void main(String[] args) {
        
        int mz[][]=new int[][]{{0,0,0,0},
                                {0,0,0,1},{0,0,0,0},{0,1,0,0}};
        
        //System.out.println(isPath(mz,4,0,0));
        int sol[][]=new int[4][4];
        printPath(mz, sol, 4, 0, 0);
        ;            }
    }
