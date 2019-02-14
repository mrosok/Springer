public class Springer {

    private static int FRI = -1;
    private static int n = 5;

    //løser brettet fra x,y startposisjon

    public static boolean solve(int x, int y) {
        int[][] board;
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = FRI;
            }
        }

        board[x][y] = 0;

        if(!finnVei(x,y,1, board)) {
            System.out.println("Ingen løsning");
            return false;
        }

        else {
            printBoard(board);
            return true;
        }
    }

    private static void printBoard(int[][] board) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%02d", board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    //rekursiv algoritme som finner løsningen
    public static boolean finnVei(int i, int j, int step, int[][] board) {

        if (step == n*n) {
            return true;
        }

        //2 opp, 1 høyre
        if (isValid(i-2, j+1, board)) {
            board[i-2][j+1] = step;
            if(finnVei(i-2,j+1,step+1, board))
                return true;
            else
                board[i-2][j+1] = FRI;
        }

        //1 opp, 2 høyre
        if (isValid(i-1, j+2, board)) {
            board[i-1][j+2] = step;
            if(finnVei(i-1,j+2,step+1, board))
                return true;
            else
                board[i-1][j+2] = FRI;
        }

        //1 ned, 2 høyre
        if (isValid(i+1, j+2, board)) {
            board[i+1][j+2] = step;
            if(finnVei(i+1,j+2,step+1, board))
                return true;
            else
                board[i+1][j+2] = FRI;
        }

        //2 ned, 1 høyre
        if (isValid(i+2, j+1, board)) {
            board[i+2][j+1] = step;
            if(finnVei(i+2,j+1,step+1, board))
                return true;
            else
                board[i+2][j+1] = FRI;
        }

        //2 ned, 1 venstre
        if (isValid(i+2, j-1, board)) {
            board[i+2][j-1] = step;
            if(finnVei(i+2,j-1,step+1, board))
                return true;
            else
                board[i+2][j-1] = FRI;
        }

        //1 ned, 2 venstre
        if (isValid(i+1, j-2, board)) {
            board[i+1][j-2] = step;
            if(finnVei(i+1,j-2,step+1, board))
                return true;
            else
                board[i+1][j-2] = FRI;
        }

        //1 opp, 2 venstre
        if (isValid(i-1, j-2, board)) {
            board[i-1][j-2] = step;
            if(finnVei(i-1,j-2,step+1, board))
                return true;
            else
                board[i-1][j-2] = FRI;
        }

        //2 opp, 1 venstre
        if (isValid(i-2, j-1, board)) {
            board[i-2][j-1] = step;
            if(finnVei(i-2,j-1,step+1, board))
                return true;
            else
                board[i-2][j-1] = FRI;
        }

        return false;
    }

    public static boolean isValid(int x, int y, int[][] board) {
        return (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == FRI);

    }


}
