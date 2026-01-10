package practise.arrays.basic;

public class Largest2 {
    public static void main(String[] args) {
        
        int arr[] = {12 , 4 , 1 , 9 , 29 , 11 , 16};

        int larg = -1 , larg2 = -1 ;

        System.out.println("second largest : ");

        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] > larg){
                larg2 = larg;
                larg = arr[i];
            }else if(arr[i] < larg && arr[i] > larg2){
                larg2 = arr[i];
            }
        }

        System.out.println("2nd largest : " + larg2);
    }
}
