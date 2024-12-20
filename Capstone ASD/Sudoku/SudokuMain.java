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

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;

    // Private variables
    GameBoardPanel board = new GameBoardPanel(this);
    JButton btnNewGame = new JButton("New Game");
    GameTimer gameTimer = new GameTimer();
    JComboBox<Puzzle.Difficulty> difficultySelector;
    Sound sound = new Sound();
    public Clip clip;

    // Constructor
    public SudokuMain() throws LineUnavailableException, IOException {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Control panel for difficulty selector and new game button
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

        // New game button action listener
        btnNewGame.addActionListener(e -> board.newGame());
        btnNewGame.addActionListener(e -> {
            board.newGame();
            gameTimer.start();
        });

        // Initialize the game board to start the game
        board.newGame();
        gameTimer.start();
        sound.playBackgroundMusic("C:\\Users\\Gabe's Laptop\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\Backsound.wav");

        pack();     // Pack the UI components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Window closing behavior
        setTitle("Sudoku");
        setVisible(true);
    }

    // Main entry method
    public static void main(String[] args) throws LineUnavailableException, IOException {
        // Run the constructor of "Sudoku.SudokuMain"
        System.out.println("Sudoku coy!");
        SudokuMain game = new SudokuMain();
    }
}
