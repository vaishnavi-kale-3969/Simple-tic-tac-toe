package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        //Stage 1/5
//        System.out.println("X O X\nO X O\nX X O");
        //stage 2/5
        System.out.println("Enter cells: ");
        String str = scanner.next();
        //taking input from the user
        int n = 0;
        int count_x = 0;
        int count_y = 0;
        String string;
        String[][] matrix = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                string = str.substring(n,n+1);
                matrix[i][j] = string;
                if(string.equals("X")){
                    count_x += 1;
                } else if(string.equals("O")){
                    count_y += 1;
                }
                n+=1;
            }
        }
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
//        System.out.println(count_x);
//        System.out.println(count_y);
        //stage 3/5
        int flag_x = 0;
        int flag_y = 0; //y means "O"
        //checking horizontal equals
        for(int i = 0; i < 3; i++){
            if(matrix[i][0].equals(matrix[i][1]) && matrix[i][1].equals(matrix[i][2])){
                if(matrix[i][0].equals("X")){
                     flag_x = 1;
                } else{
                     flag_y = 1;
                }
            }
        }
        //checking vertical equals
        for(int i = 0; i < 3; i++){
            if(matrix[0][i].equals(matrix[1][i]) && matrix[1][i].equals(matrix[2][i])){
                if(matrix[0][i].equals("X")){
                    flag_x = 1;
                }else {
                    flag_y = 1;
                }
            }
        }
        //checking diagonally equals from left to right
        if(matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])){
            if(matrix[0][0].equals("X")){
                flag_x = 1;
            }else {
                flag_y = 1;
            }
        }
        //checking another diagonal from right to left
        if(matrix[2][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[0][2])){
            if(matrix[1][1].equals("X")){
                flag_x = 1;
            }else if(matrix[1][1].equals("O")){
                flag_y = 1;
            }
        }
        //There are total 5 states:
        //xwins, ywins, draw, game not finished,impossible
        //draw condition
        int flag_draw = 0;
        if(count_x + count_y == 9){
            if(flag_x != 1){
                if(flag_y != 1){
                    flag_draw = 1;
                    System.out.println("Draw");
                }
            }
        }
        //or
        //if flag_x == 1 and flag_y == 1
        //impossible condition
        int impossible_flag = 0;
        if(Math.abs(count_x - count_y) > 1 ){
            impossible_flag = 1;
            System.out.println("Impossible");
        }

        if(impossible_flag == 0 && flag_draw == 0){
            if(flag_x == 1 && flag_y == 0){
                System.out.println("X wins");
            }else if(flag_x == 0 && flag_y == 1){
                System.out.println("O wins");
            } else if (flag_x == 1 && flag_y == 1){
                System.out.println("Impossible");
            } else {
                System.out.println("Game not finished");
            }
        }

//        System.out.println(flag_x);
//        System.out.println(flag_y);
    }
}
