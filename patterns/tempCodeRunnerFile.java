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


    }

}
