import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportManager reportManager = new ReportManager();
        while (true) {
            printMenu();
            String command = scanner.next();
            switch (command) {
                case "1":
                    reportManager.readMonthReport();
                    break;
                case "2":
                    reportManager.readYearReport();
                    break;
                case "3":
                    reportManager.dataReconciliation();
                    break;
                case "4":
                    reportManager.printMonthReport();
                    break;
                case "5":
                    reportManager.printYearReport();
                    break;
                case "0":
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
            if (command.equals("0")) {
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("Какое действие необходимо выполнить?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}

