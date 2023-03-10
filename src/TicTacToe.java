public class TicTacToe {
    private int numRows = 3;
    private int numCols = 3;
    private char[][] board = new char[numRows][numCols];
    private char player1 = 'X';
    private char player2 = 'O';
    private char empty = ' ';

    public void initializeBoard(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = empty;
            }
        }
    }

    public void printBoard(){
        System.out.print("  ");
        for(int i = 0; i < board[0].length; i++){
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        int num = 1;
        for(int row = 0; row < board.length; row++){
            System.out.print(num + " ");
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
            num++;
        }
    }

    public boolean validatePosition(int row, int col){
        if (row >= 1 && row <= 3 && col >= 1 && col <= 3) {
            if (board[row - 1][col - 1] == empty) {
                return true;
            }
        }
        return false;
    }

    public void setMovePlayer1(int row, int col){
        board[row - 1][col - 1] = player1;
    }

    public void setMovePlayer2(int row, int col){
        board[row - 1][col - 1] = player2;
    }

    public void setMoveComputerP1(){
        boolean freeSpace = false;
        while(!freeSpace){
            int row = (int) (Math.random()*3);
            int col = (int) (Math.random()*3);
            if (board[row][col] == empty) {
                board[row][col] = player1;
                freeSpace = true;
            }
        }
    }

    public void setMoveComputerP2(){
        boolean freeSpace = false;
        while(!freeSpace){
            int row = (int) (Math.random()*3);
            int col = (int) (Math.random()*3);
            if (board[row][col] == empty) {
                board[row][col] = player2;
                freeSpace = true;
            }
        }
    }

    public int checkWinningMove() {
        if (board[0][1] == board[0][2] && board[0][1] != empty && board[0][0] == empty){
            return 1;
        }
        else if (board[0][0] == board[0][2] && board[0][0] != empty && board[0][1] == empty){
            return 2;
        }
        else if (board[0][0] == board[0][1] && board[0][0] != empty && board[0][2] == empty){
            return 3;
        }
        else if (board[1][1] == board[1][2] && board[1][1] != empty && board[1][0] == empty){
            return 4;
        }
        else if (board[1][0] == board[1][2] && board[1][0] != empty && board[1][1] == empty){
            return 5;
        }
        else if (board[1][0] == board[1][1] && board[1][0] != empty && board[1][2] == empty){
            return 6;
        }
        else if (board[2][1] == board[2][2] && board[2][1] != empty && board[2][0] == empty){
            return 7;
        }
        else if (board[2][0] == board[2][2] && board[2][0] != empty && board[2][1] == empty){
            return 8;
        }
        else if (board[2][0] == board[2][1] && board[2][0] != empty && board[2][2] == empty){
            return 9;
        }
        else if(board[1][0] == board[2][0] && board[1][0] != empty && board[0][0] == empty) {
            return 1;
        }
        else if(board[0][0] == board[2][0] && board[0][0] != empty && board[1][0] == empty) {
            return 4;
        }
        else if(board[0][0] == board[1][0] && board[0][0] != empty && board[2][0] == empty) {
            return 7;
        }
        else if(board[1][1] == board[2][1] && board[1][1] != empty && board[0][1] == empty) {
            return 2;
        }
        else if(board[0][1] == board[2][1] && board[0][1] != empty && board[1][1] == empty) {
            return 5;
        }
        else if(board[0][1] == board[1][1] && board[0][1] != empty && board[2][1] == empty) {
            return 8;
        }
        else if(board[1][2] == board[2][2] && board[1][2] != empty && board[0][2] == empty) {
            return 3;
        }
        else if(board[0][2] == board[2][2] && board[0][2] != empty && board[1][2] == empty) {
            return 6;
        }
        else if(board[0][0] == board[1][2] && board[0][0] != empty && board[2][2] == empty) {
            return 9;
        }
        else if(board[1][1] == board[2][2] && board[1][1] != empty && board[0][0] == empty) {
            return 1;
        }
        else if(board[0][0] == board[2][2] && board[0][0] != empty && board[1][1] == empty) {
            return 5;
        }
        else if(board[0][0] == board[1][1] && board[0][0] != empty && board[2][2] == empty) {
            return 9;
        }
        else if(board[1][1] == board[2][0] && board[1][1] != empty && board[0][2] == empty) {
            return 3;
        }
        else if(board[0][2] == board[2][0] && board[0][2] != empty && board[1][1] == empty) {
            return 5;
        }
        else if(board[0][2] == board[1][1] && board[0][2] != empty && board[2][0] == empty) {
            return 7;
        }
        else{
            return 0;
        }
    }

    public void setSpecialMoveP1(int x){
        switch (x){
            case 1:
                board[0][0] = player1;
                break;
            case 2:
                board[0][1] = player1;
                break;
            case 3:
                board[0][2] = player1;
                break;
            case 4:
                board[1][0] = player1;
                break;
            case 5:
                board[1][1] = player1;
                break;
            case 6:
                board[1][2] = player1;
                break;
            case 7:
                board[2][0] = player1;
                break;
            case 8:
                board[2][1] = player1;
                break;
            case 9:
                board[2][2] = player1;
                break;
        }
    }

    public void setSpecialMoveP2(int x){
        switch (x){
            case 1:
                board[0][0] = player2;
                break;
            case 2:
                board[0][1] = player2;
                break;
            case 3:
                board[0][2] = player2;
                break;
            case 4:
                board[1][0] = player2;
                break;
            case 5:
                board[1][1] = player2;
                break;
            case 6:
                board[1][2] = player2;
                break;
            case 7:
                board[2][0] = player2;
                break;
            case 8:
                board[2][1] = player2;
                break;
            case 9:
                board[2][2] = player2;
                break;
        }
    }

    public boolean checkFullBoard(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == empty){
                    return false;
                }
            }
        }
        return true;
    }

    public int getResult() {
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == player1) {
            return 1;
        }
        else if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == player2) {
            return 2;
        }
        else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == player1) {
            return 1;
        }
        else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == player2) {
            return 2;
        }
        else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == player1) {
            return 1;
        }
        else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == player2) {
            return 2;
        }
        else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == player1) {
            return 1;
        }
        else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == player2) {
            return 2;
        }
        else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == player1) {
            return 1;
        }
        else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == player2) {
            return 2;
        }
        else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == player1) {
            return 1;
        }
        else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == player2) {
            return 2;
        }
        else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player1) {
            return 1;
        }
        else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player2) {
            return 2;
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player1) {
            return 1;
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player2) {
            return 2;
        }
        else if (checkFullBoard()) {
            return 3;
        }
        return 0;
    }
}