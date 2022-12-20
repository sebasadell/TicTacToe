import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println("TicTacToe!");
        System.out.println("-------------");
        System.out.println("'X' move first.");
        System.out.println("Play as 'X'? (Y/N): ");
        Scanner input = new Scanner(System.in);
        boolean valid;
        int row = 0;
        int col = 0;

        boolean validChar = false;
        char moveFirst = ' ';
        while(!validChar){
            moveFirst = input.next().toUpperCase().charAt(0);
            if(moveFirst == 'Y' || moveFirst == 'N'){
                validChar = true;
            }
            else{
                System.out.println("Invalid. Enter again (Y/N): ");
            }
        }

        System.out.println();
        game.initializeBoard();
        game.printBoard();
        System.out.println();
        if(moveFirst == 'Y') {
            while (game.getResult() == 0) {
                System.out.print("Enter row: ");
                row = input.nextInt();
                System.out.println();
                System.out.print("Enter column: ");
                System.out.println();
                col = input.nextInt();
                valid = game.validatePosition(row, col);

                if (!valid) {
                    System.out.println("Invalid move. Enter again.");
                    continue;
                }
                game.setMovePlayer1(row, col);
                game.printBoard();
                game.getResult();
                if(game.getResult() != 0){
                    continue;
                }
                System.out.println("---------");
                System.out.println("Machine's move:");
                System.out.println("---------");

                if(game.checkWinningMove() != 0){
                    game.setSpecialMoveP2(game.checkWinningMove());
                }
                else{
                    game.setMoveComputerP2();
                }



                game.printBoard();
                game.getResult();
            }
            System.out.println();
            System.out.println();
            switch (game.getResult()){
                case 1:
                    System.out.println("YOU WIN!");
                    break;
                case 2:
                    System.out.println("COMPUTER WINS!");
                    break;
                case 3:
                    System.out.println("DRAW!");
                    break;
            }
        }
        else{
            while (game.getResult() == 0) {

                valid = false;

                System.out.println("---------");
                System.out.println("Machine's move:");
                System.out.println("---------");
                if(game.checkWinningMove() != 0){
                    game.setSpecialMoveP1(game.checkWinningMove());
                }
                else{
                    game.setMoveComputerP1();
                }
                game.printBoard();
                game.getResult();
                if(game.getResult() != 0){
                    continue;
                }

                while (!valid) {
                    System.out.print("Enter row: ");
                    row = input.nextInt();
                    System.out.println();
                    System.out.print("Enter column: ");
                    System.out.println();
                    col = input.nextInt();
                    valid = game.validatePosition(row, col);
                    if(!valid){
                        System.out.println("Invalid move. Enter again.");
                    }
                }
                game.setMovePlayer2(row, col);

                game.printBoard();
                game.getResult();
            }

            System.out.println();
            System.out.println();
            switch (game.getResult()){
                case 1:
                    System.out.println("COMPUTER WINS!");
                    break;
                case 2:
                    System.out.println("YOU WIN!");
                    break;
                case 3:
                    System.out.println("DRAW!");
                    break;




            }
        }

    }
}