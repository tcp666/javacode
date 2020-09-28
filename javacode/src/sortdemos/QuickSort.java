package sortdemos;

public class QuickSort {
    public void quickSort(int[] arr,int left,int right){
        if (right-left==0)
            return;
        int l=left;
        int r=right;
        int base=left;

        while (l<r){
            while (arr[r]>arr[base]&&l!=r){
                r--;
            }
            while (arr[l]<=arr[base]&&l!=r){
                l++;
            }
            if (l!=r){
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
            else break;

        }
        if (l==r)
            base=l;
        quickSort(arr,left,base);
        quickSort(arr,base+1,right);




    }

    public static void main(String[] args) {
        int arr[]={1,5,4,3,2};


        new QuickSort().quickSort(arr,0,4);
        int count=0;    for (int x:arr){

            System.out.print(x+"\t");

        }

    }
}
