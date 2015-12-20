package com.company;
import java.util.*;
public class Main
{
    public static void print(String string) {
        System.out.print(string);
    }
    public static void print(int integer) {
        System.out.print(integer);
    }
    public static void println(String string) {
        System.out.println(string);
    }
    public static void println(int integer) {
        System.out.println(integer);
    }
    public static void showBoard(String[][] myGame)
    {
        System.out.println();
        for (int r = 0; r < myGame.length; r++)
        {
            for (int c = 0; c < myGame[0].length; c++)
            {
                if (c == 0)
                {
                    System.out.print(r);
                    System.out.print("  ");
                }
                else System.out.print(" ");
                System.out.print(myGame[r][c]);
                if (c < myGame[0].length - 1) System.out.print(" |");
                else System.out.println();
            }
            if (r < myGame.length - 1) System.out.println("-----------");
        }
        System.out.println("\n   0   1   2\n");
    }
    public static void fillBoard (String[][] board) { //not needed for this program
        for (int row =0; row<board.length; row++) {
            for (int col =0; col<board.length; col++) {
                board[row][col] = "";
            }
        }
    }
    public static boolean isThere (String[][] board, int row, int col) { //Checks if there is a number in that position
        if (board[row][col].isEmpty()) //if is empty so should be false
            return false;
        return true;
    }
    public static void suckyAI (String[][] board) {
        while (true) {
            int row = (int)(Math.random()*3);
            int col = (int)(Math.random()*3);
            if (!isThere(board,row, col)) {
                board[row][col] = "o";
                break;
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        println("This is a tick-tack-toe Game!!!");
        println("You are player one.\n you are going to be Player \"X\"");
        boolean win = false;
        String[][] board = new String[3][3];
        fillBoard(board);
        showBoard(board);
        int moveNum = 0;
        while (moveNum<3) {
            moveNum++;
            println("This is your " + moveNum + "th try.");
            print("Enter the column number of the desired position:");
            int col = sc.nextInt();
            print("Enter the row number of the desired position:");
            int row = sc.nextInt();
            board[row][col] = "x";
            showBoard(board);
            println("Now it is the computer's turn.");
            suckyAI(board);
            showBoard(board);
        }
    }
}
