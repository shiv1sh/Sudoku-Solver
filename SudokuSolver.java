package com.practice2;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] arr = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'8','.','.','.','6','.','.','.','3'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(arr);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
    static boolean isValid(char[][] board,int i,int j, char k){
        for(int p=0;p<9;p++){
            if(board[i][p]==k || board[p][j]==k) return false;
        }
        // i = (i/3)*3;
        // j = (j/3)*3;
        i = i - i%3;
        j = j - j%3;
        for(int p=i;p<i+3;p++){
            for(int q = j;q<j+3;q++){
                if(board[p][q] == k) return false;
            }
        }
        return true;
    }
}
