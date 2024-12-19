///**
// * ES234317-Algorithm and Data Structures
// * Semester Ganjil, 2024/2025
// * Group Capstone Project
// * Group #11
// * 1 - 5026231036 - Shafly Hidayatullah
// * 2 - 5026231071 - Aryabima Kurnia Pratama Santoso
// * 3 - 5026231189 - Gabriel Hadi Melvanto Sihaloho
// */
//package Sudoku;
//
//import javax.sound.sampled.*;
//import javax.swing.*;
//import java.awt.*;
//import java.io.File;
//
//public class SudokuMain extends JFrame {
//    private static final long serialVersionUID = 1L;
//
//    // Private variables
//    GameBoardPanel board = new GameBoardPanel();
//    JButton btnNewGame = new JButton("New Game");
//    GameTimer gameTimer = new GameTimer();
//    JComboBox<Puzzle.Difficulty> difficultySelector;
//
//    // Constructor
//    public SudokuMain() {
//        Container cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//
//        cp.add(board, BorderLayout.CENTER);
//
//        // Control panel for difficulty selector and new game button
//        JPanel controlPanel = new JPanel();
//        difficultySelector = new JComboBox<>(Puzzle.Difficulty.values());
//        difficultySelector.addActionListener(e -> {
//            Puzzle.Difficulty selectedDifficulty = (Puzzle.Difficulty) difficultySelector.getSelectedItem();
//            board.setDifficulty(selectedDifficulty);
//        });
//
//        controlPanel.add(gameTimer);
//        controlPanel.add(new JLabel("Select Difficulty:"));
//        controlPanel.add(difficultySelector);
//        controlPanel.add(btnNewGame);
//
//        cp.add(controlPanel, BorderLayout.SOUTH);
//
//        // New game button action listener
//        btnNewGame.addActionListener(e -> {
//            board.newGame();
//            gameTimer.start();
//        });
//
//        // Initialize the game board to start the game
//        board.newGame();
//        gameTimer.start();
//
//        // Play background music when the game starts
//        playBackgroundMusic("C:\\Users\\FARIS\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\SOUND\\Backsound.wav");
//
//        pack();     // Pack the UI components
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Window closing behavior
//        setTitle("Sudoku");
//        setVisible(true);
//    }
//
//    // Method to play background music
//    private void playBackgroundMusic(String filePath) {
//        try {
//            File audioFile = new File(filePath);
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioStream);
//            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the background music
//        } catch (Exception ex) {
//            System.out.println("Error playing background music: " + ex.getMessage());
//        }
//    }
//
//    // Method to play the "Win" sound effect
//    public void playWinSound() {
//        playSoundEffect("C:\\Users\\FARIS\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\SOUND\\Menang.wav");
//    }
//
//    // Method to play the "Lose" sound effect
//    public void playLoseSound() {
//        playSoundEffect("C:\\Users\\FARIS\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\SOUND\\Kalah.wav");
//    }
//
//    // Method to play any sound effect (e.g., Win or Lose)
//    private void playSoundEffect(String filePath) {
//        try {
//            File audioFile = new File(filePath);
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioStream);
//            clip.start();  // Play the sound effect
//        } catch (Exception ex) {
//            System.out.println("Error playing sound effect: " + ex.getMessage());
//        }
//    }
//
//    // Main entry method
//    public static void main(String[] args) {
//        // Run the constructor of "Sudoku.SudokuMain"
//        System.out.println("Sudoku coy!");
//        SwingUtilities.invokeLater(SudokuMain::new);
//    }
//}