package practise.arrays.basic;

public class Largest3rd {

    public int Find3rdLargest(int arr[]){

        int first = Integer.MIN_VALUE , sec = Integer.MIN_VALUE  , third = Integer.MIN_VALUE ;

        for(int i = 0 ;i<arr.length;i++){

            if(arr[i] > first){
                third  = sec ; 
                sec = first;
                first = arr[i];
            }else if(arr[i] > sec){
                third = sec;
                sec = arr[i];
            }else if(arr[i] > third){
                third = arr[i];
            }
            
        }
        System.out.println("3rd largest : " + third);

        return third;
    }

}
