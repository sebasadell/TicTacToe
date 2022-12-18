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

        char moveFirst = input.next().toUpperCase().charAt(0);
        if(moveFirst == 'Y') {
            System.out.println();
            game.initializeBoard();
            game.printBoard();
            System.out.println();
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
                game.setMoveComputerP2();
                game.printBoard();
                game.getResult();
            }
            System.out.println();
            System.out.println();
            switch (game.getResult()){
                case 0:
                    System.out.println("DRAW!");
                    break;
                case 1:
                    System.out.println("YOU WIN!");
                    break;
                case 2:
                    System.out.println("COMPUTER WINS!");
                    break;
            }
        }
        else{
            System.out.println();
            game.initializeBoard();
            game.printBoard();
            System.out.println();
            while (game.getResult() == 0) {

                valid = false;

                System.out.println("---------");
                System.out.println("Machine's move:");
                System.out.println("---------");
                game.setMoveComputerP1();
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
                case 0:
                    System.out.println("DRAW!");
                    break;
                case 1:
                    System.out.println("COMPUTER WINS!");
                    break;
                case 2:
                    System.out.println("YOU WIN!");
                    break;
            }
        }

    }
}