import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int array[][] = new int[row][col];
        int secondArray[][] = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                secondArray[i][j] = array[row - 1 - j][i];
            }
        }

        for (int i = 0; i < col; i++) {
            System.out.println();
            for (int j = 0; j < row; j++) {
                System.out.print(secondArray[i][j] + " ");
            }
        }
    }
}