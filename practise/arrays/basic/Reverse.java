// package practise.arrays.basic;

public class Reverse {

    public void reverse(int arr[]) {

        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

    }


    public void ReverseInGroup(int arr[]){
        
    }

    public static void main(String[] args) {
        int[] arr = { 12, 4, 1, 9, 29, 11, 16 };
     
        Reverse rev = new Reverse();
        rev.reverse(arr);


        for(int i:arr) System.out.print(i + " ");

    }
}
