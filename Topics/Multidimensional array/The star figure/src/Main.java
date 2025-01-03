import java.util.Scanner;
class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int number = scanner.nextInt();
      String[][] starArray = new String[number][number];
      int midRow = number / 2;
      int midCol = number / 2;
      int rightDiag = number - 1;
      for (int i = 0; i < starArray.length; i++) {
          for (int j = 0; j < starArray[i].length; j++) {
              if (i == midRow) {
                  starArray[i][j] = "* ";
              } else if (j == midCol) {
                  starArray[i][j] = "* ";
              } else if (i == j) {
                  starArray[i][j] = "* ";
              } else {
                  starArray[i][j] = ". ";
              }
              starArray[i][rightDiag - i] = "* ";

          }
      }
      for (int count = 0; count < starArray.length; count++) {
          System.out.println();
          for (int count2 = 0; count2 < starArray[count].length; count2++) {
              System.out.print(starArray[count][count2]);
          }
      }
    }
}