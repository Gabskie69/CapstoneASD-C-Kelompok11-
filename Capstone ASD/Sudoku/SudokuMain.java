package Sudoku;

import java.awt.*;
import javax.swing.*;
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");
    JComboBox<Puzzle.Difficulty> difficultySelector;

    // Constructor
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        // ......
        JPanel controlPanel = new JPanel();
        difficultySelector = new JComboBox<>(Puzzle.Difficulty.values());
        difficultySelector.addActionListener(e -> {
            Puzzle.Difficulty selectedDifficulty = (Puzzle.Difficulty) difficultySelector.getSelectedItem();
            board.setDifficulty(selectedDifficulty);
        });

        controlPanel.add(new JLabel("Select Difficulty:"));
        controlPanel.add(difficultySelector);
        controlPanel.add(btnNewGame);

        cp.add(controlPanel, BorderLayout.SOUTH);

        btnNewGame.addActionListener(e -> board.newGame());

        // Initialize the game board to start the game
        board.newGame();

        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);
    }

    /** The entry main() entry method */
    public static void main(String[] args) {
        // [TODO 1] Check "Swing program template" on how to run
        //  the constructor of "Sudoku.SudokuMain"
        // .........
        System.out.println("Sudoku coy!");
        SudokuMain game = new SudokuMain();
        SwingUtilities.invokeLater(SudokuMain::new);
    }
}
