import java.util.Arrays;

public final class TicTacToeChecker {
    public static void main() throws Exception {
        int [][] array = new int[][] {
            {1, 2, 1},
            {1, 1, 2},
            {2, 1, 2}
        };
        final int result = isSolved(array);
        System.out.println(result);
    }
    
    /**
     * @param array
     * @return
     */
    public static int isSolved(int[][] board) {
        
        // Check diagonals
        final int centerPoint = board[1][1];
        if (centerPoint !=0) {
            // Check 1st diago
            if (board[0][0] == centerPoint && board[2][2] == centerPoint) {
                return centerPoint;
            }  
            //Check opposite diago      
            if (board[0][2] == centerPoint && board[2][0] == centerPoint) {
                return centerPoint;
            }
        }
        // Check lines
        for (int i = 0; i < board.length; i++) {
            // Row check
            final int rowComparaisonPoint = board[i][0];
            if (rowComparaisonPoint != 0 && board[i][1] == rowComparaisonPoint && board[i][2] == rowComparaisonPoint) {
                return rowComparaisonPoint; 
            }
            // Column check
            final int columnComparaisonPoint = board[0][i];
            if (columnComparaisonPoint != 0 && board[1][i] == columnComparaisonPoint && board[2][i] == columnComparaisonPoint) {
                return columnComparaisonPoint;
            }
        }

        final int[] flattenArray = ArrayUtils.flatten(board);
        // Game is draw ? 
        if (Arrays.stream(flattenArray).noneMatch(e -> e == 0))
            return 0;

        return -1;
    }
}
