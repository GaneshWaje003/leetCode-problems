public class Patterns {
    public static void main(String[] args) {

        int rows = 5;

        // ! pyramiids
        for (int i = 1; i <= rows; i++) {

            // ? spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // ? start
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }


        System.out.println("-----------");
        for(int i = 1; i <= rows; i++){
            
            for(int j = 1; j <= i ;j++){
                System.out.print("*");
            }

            System.out.println();

        }
        
        System.out.println("-----------");
        for(int i = 1 ; i <= rows ;i++){
            // ? spaces 
            for(int spaces = 1; spaces <= rows-i ; spaces++){
                System.out.print(" ");
            }
            
            for(int j = 1; j <=i ;j++){
                System.out.print("*");  
            }
            
            System.out.println();
            
        }


        System.out.println("-----------");
        for (int i = 1; i <= rows; i++) {

            // ? spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // ? start
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
        
        for(int i = rows;i>=1;i--){
            //? spaces 
            for(int spaces = rows-i ;spaces >= 1;spaces--){
                System.out.print(" ");
            }

            // ? stars 
            for(int j = 1  ; j <= 2 * i - 1 ;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

}
