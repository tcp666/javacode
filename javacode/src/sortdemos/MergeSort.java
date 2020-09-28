package sortdemos;

public class MergeSort {
    void merge(int[] arr,int left,int mid,int right){
        int leftSize=mid-left;
        int rightSize=right-mid+1;
        int[] leftTemp=new int[leftSize];
        int[] rightTemp=new int[rightSize];

        for (int i=0,k=left;k<mid;){
            leftTemp[i]=arr[k];
            i++;
            k++;
        }

        for (int i=0,k=mid;k<right+1;i++){
            rightTemp[i]=arr[k];
            k++;
        }
        int i,j,k;
        i=0;
        j=0;
        k=left;
        while (i<leftSize&&j<rightSize){
            if (leftTemp[i]<rightTemp[j]){
                arr[k]=leftTemp[i];
                i++;
                k++;
            }
            else{
                arr[k]=rightTemp[j];
                j++;
                k++;
            }
        }
        while (i<leftSize){
            arr[k]=leftTemp[i];
            i++;
            k++;
        }
        while (j<rightSize){
            arr[k]=rightTemp[j];
            j++;
            k++;
        }

    }

    void mergeSort(int[] arr,int left,int right){
        if (left==right)
            return;
        else {
            int mid=(right+left)/2+1;
            mergeSort(arr,left,mid-1);
            mergeSort(arr,mid,right);
            merge(arr,left,mid,right);
        }
    }

    public static void main(String[] args) {

        int arr[]=new int[1024*10];

        for (int i=0;i<1024*10;i++){
            arr[i]=(int)(Math.random()*100000000);


        }
        new MergeSort().mergeSort(arr,0,1024*10-1);
int count=0;
        for (int x:arr){
            count++;
            System.out.print(x+"\t");
            if (count%10==0)
                System.out.println();
        }

    }
}
