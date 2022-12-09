import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanN = new Scanner(System.in);
        System.out.print("Дата: ");
        String data = scanN.nextLine();
        scanN.close();

        Pattern block = Pattern.compile("(?:[0-9]{2}[\\/]){2}[0-9]{4}");
        Matcher match = block.matcher(data);
        boolean valid = match.matches();

        if (!valid) {
            System.out.print("Введеное выражение не соответствует заданному формату даты dd/mm/yyyy");
            System.exit(0);
        }

        int year = Integer.parseInt(data.substring(6,10));
        if (year < 1900) {
            System.out.print("Введенное выражение не является датой");
            System.exit(0);
        }

        int month = Integer.parseInt(data.substring(3,5));
        if (month == 0 || month > 12) {
            System.out.print("Введенное выражение не является датой");
            System.exit(0);
        }

        int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Integer.parseInt(data.substring(0, 2));
        if (day > maxMonthDays[month-1]) {
            System.out.print("Введенное выражение не является датой");
            System.exit(0);
        }
        System.out.print("Введенное выражение является датой");
    }
}