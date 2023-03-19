package talkwalk;

import java.util.HashSet;

public class Problem05_SudokuValidity_Interview3_TechnicalInteview2_preparation {

    // Idea is to check the balance of uniqueness of numbers in all columns & rows
    // If it is so there is no need to check the sub-squares 3 of 3
    // Ass long as you found faulty line or row no need to check the rest
    public static boolean isSudokuValid(int[][] board) {
        int dim = board.length; // you can run this solution for sudoku of 4x4 etc 
        HashSet<Integer> tempHMRow = new HashSet<Integer>();
        HashSet<Integer> tempHMCol = new HashSet<Integer>();
        for (int i = 0; i < dim; i++) { // check by columns & by rows
            tempHMRow.clear();
            tempHMCol.clear();
            for (int j = 0; j < dim; j++) {
                if ( board[i][j] < 1 || board[i][j]> dim ) {
                    return false;
                }
                if ( tempHMRow.contains(board[i][j]) || tempHMCol.contains(board[j][i]) ) {
                    return false;
                }
                tempHMRow.add(board[i][j]);
                tempHMCol.add(board[j][i]);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test case 1 false
        int[][] board = {{5, 5, 5, 5, 5, 5, 5, 5, 5}, 
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5},
                         {5, 5, 5, 5, 5, 5, 5, 5, 5}};
        // Test case 2 true
        int[][] board2 ={{7, 9, 2, 1, 5, 4, 3, 8, 6}, 
                          {6, 4, 3, 8, 2, 7, 1, 5, 9},
                          {8, 5, 1, 3, 9, 6, 7, 2, 4},
                          {2, 6, 5, 9, 7, 3, 8, 4, 1},
                          {4, 8, 9, 5, 6, 1, 2, 7, 3},
                          {3, 1, 7, 4, 8, 2, 9, 6, 5},
                          {1, 3, 6, 7, 4, 8, 5, 9, 2},
                          {9, 7, 4, 2, 1, 5, 6, 3, 8},
                          {5, 2, 8, 6, 3, 9, 4, 1, 7}};
        // Test case 3 true
        int[][] board3 ={{7, 9, 2, 1, 5, 4, 3, 8, 6}, 
                           {6, 4, 3, 8, 2, 7, 1, 5, 9},
                           {8, 5, 1, 3, 9, 6, 7, 2, 4},
                          {2, 6, 5, 9, 7, 3, 8, 4, 1},
                          {4, 8, 9, 5, 6, 1, 2, 7, 3},
                          {3, 1, 7, 4, 8, 2, 9, 6, 5},
                          {1, 3, 6, 7, 4, 8, 5, 9, 2},
                          {9 ,7, 4, 2, 1, 5, 6, 3, 8},
                          {5, 2, 8, 6, 3, 9, 4, 1, 7}};
        
        System.out.println(isSudokuValid(board2));
    }

}
