package Sudoku;

import java.awt.*;
import javax.swing.*;
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameTimer gameTimer = new GameTimer();
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(gameTimer, BorderLayout.WEST);
        topPanel.add(btnNewGame, BorderLayout.EAST);
        cp.add(topPanel, BorderLayout.NORTH);

        // Tombol "New Game"
        btnNewGame.addActionListener(e -> {
            board.newGame();
            gameTimer.start(); // Reset dan mulai timer baru
        });

        // Initialize the game board to start the game
        board.newGame();
        gameTimer.start();

        ImageIcon icon = new ImageIcon("C:\\Users\\Aryabima\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\logo.jpg"); // Path ke file gambar
        setIconImage(icon.getImage()); // Aryabima
        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("Always GASDOR Sudoku");
        setVisible(true);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(new BorderLayout());

        // Inisialisasi board
        board = new GameBoardPanel();

        // Tambahkan dropdown untuk memilih tingkat kesulitan
        String[] difficulties = {"Easy", "Medium", "Hard"};
        JComboBox<String> difficultySelector = new JComboBox<>(difficulties);
        difficultySelector.setSelectedIndex(0); // Default ke "Easy"
        difficultySelector.addActionListener(e -> {
            String selectedDifficulty = (String) difficultySelector.getSelectedItem();
            int cellsToGuess = switch (selectedDifficulty) {
                case "Easy" -> 20;    // 20 sel kosong
                case "Medium" -> 40;  // 40 sel kosong
                case "Hard" -> 60;    // 60 sel kosong
                default -> 30;        // Default fallback
            };
            board.puzzle.newPuzzle(cellsToGuess);
            board.newGame();
        });

        // Tambahkan komponen ke frame
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Difficulty:"));
        topPanel.add(difficultySelector);

        frame.add(topPanel, BorderLayout.NORTH); // Tambahkan dropdown di atas
        frame.add(board, BorderLayout.CENTER);  // Tambahkan papan sudoku di tengah

        frame.setVisible(true);
    }

    /** The entry main() entry method */
    public static void main(String[] args) {
        // [TODO 1] Check "Swing program template" on how to run
        //  the constructor of "Sudoku.SudokuMain"
        // .........
        System.out.println("Sudoku coy!");
        SudokuMain game = new SudokuMain();
    }
}
