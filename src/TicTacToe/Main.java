package TicTacToe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * Main class of the Java program.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe");
        TTT game = new TTT();
        game.play();
    }
}
