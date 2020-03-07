import java.util.*;

class BinaryS{


    public static void main(String[] args) {
        
        int arr[]=new int[]{1,2,3,4,4,4};
        int n=arr.length;
        int key=1;
        int l=-1,h=n-1;
        while(h-l>1)
        {
            int m=l+(h-l)/2;
            if(arr[m]>=key)
            {
                h=m;
            }
            else{
                l=m+1;
            }
        }
        System.out.println(h);
        l=0;
        h=n;

        while(h-l>1)
        {
            int m=l+(h-l)/2;
            if(arr[m]<=key)
            {
                l=m;
            }
            else{
                h=m-1;
            }
        }
        System.out.println(l);
    }
}