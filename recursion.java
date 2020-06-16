class recursion{

    public static void paint_fill(int arr[][],int i,int j,int to_fill,int filler){

        int r=arr.length;
        int c=arr[0].length;
        if(i<0 || i>=r || j<0 || j>=c)
        {
            return;
        }
        if(arr[i][j]!=to_fill)
        {
            return;
        }
        arr[i][j]=filler;
        paint_fill(arr,i,j+1,to_fill,filler);
        paint_fill(arr,i+1,j+1,to_fill,filler);
        paint_fill(arr,i+1,j,to_fill,filler);
        paint_fill(arr,i-1,j,to_fill,filler);
    }

    public static void permutations(String s,int l,int r)
    {
        if(l==r)
        {
            System.out.println(s);
            return;
        }
        for(int i=l;i<=r;i++)
        {
            s=interchangechar(s,l,i);
            permutations(s,l+1,r);
            s=interchangechar(s,l,i);
        }
    }
    public static String interchangechar(String s,int l,int i)
    {
        char arr[]=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[l];
        arr[l]=temp;
        return String.valueOf(arr);
    }

    public static void main(String[] args) {

        int arr[][]=new int[][]{{1,5,1,1},{2,2,1,4},{0,2,2,4}};

        int r=arr.length;
        int c=arr[0].length;
        // paint_fill(arr,1,1,2,5);
        // for(int i=0;i<r;i++)
        // {
        //     for(int j=0;j<c;j++)
        //     {
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        permutations("abc",0,2);
    }
}
