public class Problem {
    public static void main(String[] args) {
        

        
        int arr[] = {12 , 4 , 1 , 9 , 29 , 11 , 16};
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

    }
}

