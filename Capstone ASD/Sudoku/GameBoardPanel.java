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
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;
import javax.swing.*;
public class GameBoardPanel extends JPanel{
  
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // Define named constants for UI sizes
    public static final int CELL_SIZE = 60;   // Sudoku.Cell width/height in pixels
    public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
    // Board width/height in pixels

    // Define properties
    /** The game board composes of 9x9 Cells (customized JTextFields) */
    private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    /** It also contains a Sudoku.Puzzle with array numbers and isGiven */
    private Puzzle puzzle = new Puzzle();
    GameTimer gameTimer = new GameTimer();
    Sound sound = new Sound();

    private Puzzle.Difficulty currentDifficulty = Puzzle.Difficulty.EASY; // Default difficulty

    private SudokuMain mainFrame;
    /** Constructor */
    public GameBoardPanel(SudokuMain mainFrame) {
        this.mainFrame = mainFrame;
        super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel

        // Allocate the 2D array of Sudoku.Cell, and added into JPanel.
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);   // JPanel
            }
        }
        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));


        //Ini gk jelas
        // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
        //  Cells (JTextFields)
        CellInputListener listener = new CellInputListener();

        // [TODO 4] Adds this common listener to all editable cells
        for (int row = 0; row < SudokuConstants.GRID_SIZE; row ++) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; col ++) {
                if (cells[row][col].isEditable()) {
                    cells[row][col].addActionListener(listener);   // For all editable rows and cols
                }
            }
        }
    }
    public void setDifficulty(Puzzle.Difficulty difficulty) {
        this.currentDifficulty = difficulty;
    }

    /**
     * Generate a new puzzle; and reset the game board of cells based on the puzzle.
     * You can call this method to start a new game.
     */
    public void newGame() {
        // Generate a new puzzle
        sound.stopBackgroundMusic();
        puzzle.newPuzzle(2);
        puzzle.newPuzzle(currentDifficulty);


        // Initialize all the 9x9 cells, based on the puzzle.
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            }
        }
        gameTimer.start();
//        sound.playBackgroundMusic("C:\\Users\\Gabe's Laptop\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\Backsound.wav");
    }

    /**
     * Return true if the puzzle is solved
     * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
     */
    public boolean isSolved() {
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
                    return false;
                }
            }
        }
        return true;
    }


    // [TODO 2] Define a Listener Inner Class for all the editable Cells
    public class CellInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get a reference of the JTextField that triggers this action event
            Cell sourceCell = (Cell)e.getSource();

            // Retrieve the int entered
            int numberIn = Integer.parseInt(sourceCell.getText());
            // For debugging
            System.out.println("You entered " + numberIn);

            /*
             * [TODO 5] (later - after TODO 3 and 4)
             * Check the numberIn against sourceCell.number.
             * Update the cell status sourceCell.status,
             * and re-paint the cell via sourceCell.paint().
             */
            if (numberIn == sourceCell.number) {
                sourceCell.status = CellStatus.CORRECT_GUESS;
                sourceCell.paint(Cell.BG_CORRECT_GUESS);
                sourceCell.status = CellStatus.CORRECT_GUESS;
                sourceCell.paint(Cell.BG_CORRECT_GUESS);
            } else {
                sourceCell.status = CellStatus.WRONG_GUESS;
                sourceCell.paint(Color.RED);
                sourceCell.paint(Color.RED);
            }// re-paint this cell based on its status
            sourceCell.paint(Color.red);
            /*
             * [TODO 6] (later)
             * Check if the player has solved the puzzle after this move,
             *   by calling isSolved(). Put up a congratulation JOptionPane, if so.
             */
            if (isSolved()) {
                mainFrame.sound.stopBackgroundMusic();
                mainFrame.gameTimer.stop();
                mainFrame.sound.playSoundEffect("C:\\Users\\Gabe's Laptop\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\Menang.wav");
//                File file = new File("C:\\Users\\Gabe's Laptop\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\Menang.wav");
//                AudioInputStream audioStream =null;
//                try {
//                    audioStream = AudioSystem.getAudioInputStream(file);
//                } catch (UnsupportedAudioFileException f) {
//                    throw new RuntimeException(f);
//                } catch (IOException f){
//                    throw new RuntimeException(f);
//                }
//                Clip clip = null;
//                try{
//                    clip =AudioSystem.getClip();
//                }catch(LineUnavailableException f){
//                    throw new RuntimeException(f);
//                }
//                try {
//                    clip.open(audioStream);
//                } catch (LineUnavailableException ex) {
//                    throw new RuntimeException(ex);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//                clip.start();
//                mainFrame.playSoundEffect("C:\\Users\\Gabe's Laptop\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\Menang.wav");
                int option = JOptionPane.showConfirmDialog(
                        GameBoardPanel.this,
                        "Congratulations! You've solved the puzzle!\nWould you like to start a new game?",
                        "Sudoku.Puzzle Solved!",
                        JOptionPane.YES_NO_OPTION

                );

//                // Method to play the "Lose" sound effect
//                public void playLoseSound() {
//                    playSoundEffect("C:/Users/Gabe's Laptop/Downloads/Kalah.wav");
//                }

                // If the user chooses "Yes", reset the game
                if (option == JOptionPane.YES_OPTION) {
                    sound.stopBackgroundMusic();
                    newGame(); // Restart the game
                    mainFrame.gameTimer.start();
                    sound.playBackgroundMusic("C:\\Users\\Gabe's Laptop\\Documents\\CapstoneASD-C-Kelompok11-\\Capstone ASD\\Sudoku\\Backsound.wav");
                }
                else{
                    System.exit(0);
                }
            }
        }
    }
}
