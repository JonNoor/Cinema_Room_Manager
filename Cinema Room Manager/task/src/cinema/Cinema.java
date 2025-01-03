package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int numOfRows = sc.nextInt() + 1;
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int numOfSeats = sc.nextInt() + 1;
        String[][] cinemaHall = createArray(numOfRows, numOfSeats);
        double percentage;
        int totalIncome;
        int currentIncome = 0;
        int chosenRow;
        int chosenSeat;
        int purchaseCounter = 0;
        boolean control = true;
        while (control) {
            menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Cinema:");
                    for (int i = 0; i < cinemaHall.length; i++) {
                        System.out.println();
                        for (int j = 0; j < cinemaHall[i].length; j++) {
                            System.out.print(cinemaHall[i][j]);
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    boolean exit = true;
                    while (exit) {
                        System.out.println("Enter a row number:");
                        System.out.print("> ");
                        chosenRow = sc.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        System.out.print("> ");
                        chosenSeat = sc.nextInt();
                        if (chosenRow > cinemaHall.length - 1 || chosenSeat > cinemaHall[0].length - 1) {
                            System.out.println("Wrong input!");
                        } else if (cinemaHall[chosenRow][chosenSeat] == " B") {
                            System.out.println("That ticket has already been purchased!");
                        } else if (cinemaHall[chosenRow][chosenSeat] == " S") {
                            cinemaHall[chosenRow][chosenSeat] = " B";
                            System.out.printf("Ticket price: $%d%n", pricePoint(numOfRows, numOfSeats, chosenRow));
                            purchaseCounter++;
                            currentIncome = currentIncome + pricePoint(numOfRows, numOfSeats, chosenRow);
                            exit = false;
                        }
                    }
                    break;
                case 3:
                    percentage = percentage(numOfRows, numOfSeats, purchaseCounter);
                    totalIncome = totalIncome(numOfRows, numOfSeats);
                    stats(purchaseCounter, percentage, totalIncome, currentIncome);
                    break;
                case 0:
                    control = false;
                    break;
            }
        }
    }
    public static String[][] createArray(int rows, int cols) {
        String[][] cinemaHall = new String[rows][cols];
        for (int i = 0; i < cinemaHall.length; i++) {
            for (int j = 0; j < cinemaHall[i].length; j++) {
                if (i == 0 && j == 0) {
                    cinemaHall[i][j] = " ";
                } else if (i == 0) {
                    cinemaHall[i][j] = " " + j;
                } else if (j == 0) {
                    cinemaHall[i][j] = "" + i;
                } else {
                    cinemaHall[i][j] = " S";
                }
            }
        }
        return cinemaHall;
    }
    public static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.print("> ");
    }
    public static int pricePoint(int numOfRows, int numOfSeats, int chosenRow) {
        int price;
        if ((numOfRows - 1) * (numOfSeats - 1) <= 60) {
            price = 10;
        } else if (chosenRow <= (numOfRows - 1) / 2) {
            price = 10;
        } else {
            price = 8;
        }
        return price;
    }
    public static void stats(int purchaseCounter, double percentage, int totalIncome, int currentIncome) {
        System.out.printf("Number of purchased tickets: %d%n", purchaseCounter);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }
    public static double percentage(int numOfRows, int numOfSeats, int counter) {
        return (double) counter / ((numOfRows - 1) * (numOfSeats - 1)) * 100;
    }
    public static int totalIncome(int numOfRows, int numOfSeats) {
        int totalIncome;
        if ((numOfRows - 1) * (numOfSeats - 1) <= 60) {
            totalIncome = (numOfRows - 1) * (numOfSeats  - 1) * 10;
        } else if (((numOfRows - 1) * (numOfSeats - 1)) % 2 != 0) {
            totalIncome = (((numOfRows - 1) / 2) * (numOfSeats - 1)) * 10 + (((numOfRows - 1) / 2 + 1) * (numOfSeats - 1)) * 8;
        }
        else {
            totalIncome = (((numOfRows - 1) / 2) * (numOfSeats - 1)) * 10 + (((numOfRows - 1) / 2) * (numOfSeats - 1)) * 8;
        }
        return totalIncome;
    }

}