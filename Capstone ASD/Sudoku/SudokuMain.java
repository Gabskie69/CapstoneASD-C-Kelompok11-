/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2024/2025
 * Group Capstone Project
 * Group #11
 * 1 - 5026231036 - Shafly Hidayatullah
 * 2 - 5026231071 - Aryabima Kurnia Pratama Santoso
 * 3 - 5026231189 - Gabriel Hadi Melvanto Sihaloho
 */
package Sudoku;

import java.awt.*;
import javax.swing.*;
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");
    GameTimer gameTimer = new GameTimer();
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

        controlPanel.add(gameTimer);
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
