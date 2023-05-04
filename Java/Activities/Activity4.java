package activities;

public class Activity4 {
    public static void main(String[] args) {
        int[] arr={4,3,2,10,12,1,5,6};
        int temp;
        for(int j=0;j<arr.length;j++){
            for (int i=1;i<arr.length-j;i++){
                if(arr[i-1]>arr[i]){
                    temp=arr[i-1];
                    arr[i-1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}
