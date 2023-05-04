package activities;

public class Activity2 {

    public static void main(String[] args) {
        int[] arr={10, 77, 10, 54, -11, 10};
        int searchNum=10;
        int expectedOutputVal=30;
        results( arr, searchNum,expectedOutputVal);

    }
    public static boolean results(int[] arr,int searchNum,int expectedOutputVal){
        int totalSum = 0;
        for(int num:arr){
            if(num==searchNum) {
                totalSum+=num;
            }
            if(totalSum>expectedOutputVal){
                break;
            }

        }
        System.out.println(totalSum);
        if(totalSum==expectedOutputVal){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        return totalSum==expectedOutputVal;
    }
}
