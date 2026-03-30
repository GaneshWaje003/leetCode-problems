class Prob79_wordSearch {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        
        for(int i = 0 ; i < board.length;i++){
            for (int j = 0; j < board[0].length; j++) {

                // go to recursive check only 
                // if the starting char of pos i , j is 1st char of word

                if(board[i][j] == word.charAt(0) && DFS(board ,  i , j , word , 0)) return true;

            }
        }

        return false;
    }


    private boolean DFS(char[][] board , int i , int j , String word , int k){

        // base case at k is exausted means case is true 
        if(k == word.length()) return true;

        // pruning case for checking chars match or not 
        if(i < 0 || i >= board.length || j > board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }

        char temp  = board[i][j];
        board[i][j] = '#';

        // options 
        if(DFS(board , i + 1 , j , word , k + 1)) return true;
        if(DFS(board , i - 1 , j , word , k + 1)) return true;
        if(DFS(board , i  , j + 1 , word , k + 1)) return true;
        if(DFS(board , i , j - 1 , word , k + 1)) return true;


        // backtrack
        board[i][j] = temp;

        return false;

    }
}