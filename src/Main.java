import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static boolean correctPass(String pass) {
        Pattern allSymbol = Pattern.compile("(?:[a-zA-Z0-9_]){8,}");
        Matcher match_1 = allSymbol.matcher(pass);
        if (!match_1.matches()) {
            System.out.println("Пароль ненадёжен. Повторите ввод");
            return false;
        }
        Pattern nesSymbol = Pattern.compile("(?=.*[0,9])(?=.*[a-z])(?=.*[A-Z]).{8,}");
        Matcher match_2 = nesSymbol.matcher(pass);
        if (!match_2.matches()) {
            System.out.println("Пароль ненадёжен. Повторите ввод");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanN = new Scanner(System.in);
        boolean valid = false;

        do {
            System.out.print("Пароль: ");
            String password = scanN.nextLine();
            valid = correctPass(password);
        } while (!valid);

        System.out.print("Пароль надежен");
    }
}
