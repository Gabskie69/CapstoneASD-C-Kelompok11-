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

public enum CellStatus {
   /**
    * An enumeration of constants to represent the status
    * of each cell.
    */
   GIVEN,         // clue, no need to guess
   TO_GUESS,      // need to guess - not attempted yet
   CORRECT_GUESS, // need to guess - correct guess
   WRONG_GUESS    // need to guess - wrong guess
   // The puzzle is solved if none of the cells have
   //  status of TO_GUESS or WRONG_GUESS
}
