import java.util.*;
class sort{

    public static void quicksort(int arr[],int start,int end)
    {
        if(start>=end)
        {
            return;
        }
        int mid=(start+end)/2;
        int pivot=arr[mid];
        int l=start,h=end;
        
        while(l<=h)
        {
            while(arr[l]<pivot)
            {
                l++;
            }
            while(arr[h]>pivot)
            {
                h--;
            }
            if(l<=h){
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
            }
        }
        quicksort(arr,start,h);
        quicksort(arr, l, end);
        //return arr;
    }


    public static void merge(int arr[],int start,int end){

        int n=end-start+1;
        int temp[]=new int[n];
        int mid=(start+end)/2;
        int l=start;
        int h=mid+1;
        int k=0;
        while(l<=mid && h<=end)
        {
            if(arr[l]<=arr[h])
            {
                temp[k]=arr[l];
                l++;
                k++;
            }
            else{
                temp[k]=arr[h];
                k++;
                h++;
            }
        }
        while(l<=mid)
        {
            temp[k]=arr[l];
            k++;
            l++;
        }
        while(h<=end)
        {
            temp[k]=arr[h];
            k++;
            h++;
        }
        int pos=0;
        for(int i=start;i<=end;i++)
        {
            arr[i]=temp[pos];
            pos++;
        }
    }
    public static void mergesort(int arr[],int start,int end){

        if(start>=end)
        {
            return;
        }
            int mid=(start+end)/2;
            mergesort(arr, start, mid);
            mergesort(arr, mid+1, end);
            merge(arr,start,end);

    }
    public static void main(String[] args) {
        
        int arr[]=new int[]{7, 10, 5, 22, 3, 2, 1};
        int n=arr.length;
        mergesort(arr,0,n-1);

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}