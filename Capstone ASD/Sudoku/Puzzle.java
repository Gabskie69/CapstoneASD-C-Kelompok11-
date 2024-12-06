package Sudoku;
import java.util.Random;

public class Puzzle {
    public static final int GRID_SIZE = SudokuConstants.GRID_SIZE;
    int[][] numbers = new int[GRID_SIZE][GRID_SIZE];
    boolean[][] isGiven = new boolean[GRID_SIZE][GRID_SIZE];

    public void newPuzzle(int cellsToGuess) {
        generateSolvedGrid();
        randomizeGrid();
        randomizeNumbers();
        createBlanks(cellsToGuess);
    }

    // Generate a solved Sudoku grid
    private void generateSolvedGrid() {
        int[][] base = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };

        for (int row = 0; row < GRID_SIZE; row++) {
            System.arraycopy(base[row], 0, numbers[row], 0, GRID_SIZE);
        }
    }

    // Randomize grid by shuffling rows and columns within subgrids
    private void randomizeGrid() {
        Random rand = new Random();

        // Shuffle rows within each subgrid
        for (int i = 0; i < GRID_SIZE; i += 3) {
            for (int j = 0; j < 3; j++) {
                int row1 = i + j;
                int row2 = i + rand.nextInt(3);
                swapRows(row1, row2);
            }
        }

        // Shuffle columns within each subgrid
        for (int i = 0; i < GRID_SIZE; i += 3) {
            for (int j = 0; j < 3; j++) {
                int col1 = i + j;
                int col2 = i + rand.nextInt(3);
                swapColumns(col1, col2);
            }
        }
    }

    // Swap two rows
    private void swapRows(int row1, int row2) {
        int[] temp = numbers[row1];
        numbers[row1] = numbers[row2];
        numbers[row2] = temp;
    }

    // Swap two columns
    private void swapColumns(int col1, int col2) {
        for (int row = 0; row < GRID_SIZE; row++) {
            int temp = numbers[row][col1];
            numbers[row][col1] = numbers[row][col2];
            numbers[row][col2] = temp;
        }
    }

    // Randomize numbers in the grid
    private void randomizeNumbers() {
        Random rand = new Random();
        int[] map = new int[GRID_SIZE + 1];
        boolean[] used = new boolean[GRID_SIZE + 1];

        // Create a random mapping for numbers 1-9
        for (int i = 1; i <= GRID_SIZE; i++) {
            int num;
            do {
                num = rand.nextInt(GRID_SIZE) + 1;
            } while (used[num]);
            used[num] = true;
            map[i] = num;
        }

        // Apply the mapping to the grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                numbers[row][col] = map[numbers[row][col]];
            }
        }
    }

    // Create blanks in the puzzle
    private void createBlanks(int cellsToGuess) {
        Random rand = new Random();
        int blanks = 0;

        // Initialize all cells as given
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                isGiven[row][col] = true;
            }
        }

        // Randomly make cells blank until reaching the desired number
        while (blanks < cellsToGuess) {
            int row = rand.nextInt(GRID_SIZE);
            int col = rand.nextInt(GRID_SIZE);

            if (isGiven[row][col]) {
                isGiven[row][col] = false;
                blanks++;
            }
        }
    }
}
