import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calc {
    public static void main(String[] args) throws SomethingWentWrong {
        String expr = EnteringTheString.gettingString();
        char num1, num2;
        int res = 0;
        String fres ;
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher(expr);

        if (Character.isDigit(expr.charAt(0))) {
            if (m.find()) {
                throw new SomethingWentWrong("Введите выражение, состоящее только из двух арабских или римских цифр от 1 до 10 включительно");
            } else {
                if (expr.startsWith("10")) {
                    num2 = expr.charAt(3);
                    int n2 = Character.getNumericValue(num2);
                    int n1 = 10;
                    res = CalcMethods.calc(n1, n2, res, expr);
                    System.out.println("Результат: " + res);
                } else if (expr.endsWith("10")) {
                    num1 = expr.charAt(0);
                    int n1 = Character.getNumericValue(num1);
                    int n2 = 10;
                    res = CalcMethods.calc(n1, n2, res, expr);
                    System.out.println("Результат: " + res);
                } else if (expr.length() == 3) {
                    num1 = expr.charAt(0);
                    num2 = expr.charAt(2);
                    int n1 = Character.getNumericValue(num1);
                    int n2 = Character.getNumericValue(num2);
                    res = CalcMethods.calc(n1, n2, res, expr);
                    System.out.println("Результат: " + res);
                }
            }
        } else {
            int n1 = 0, n2 = 0;
            if (expr.matches(".*\\d+.*")) {
                throw new SomethingWentWrong("Введите выражение, состоящее только из двух арабских или римских цифр от 1 до 10 включительно");
            } else {
                if (expr.length() <= 9) {
                    n1 = RomanianNums.beginning(expr, n1);
                    n2 = RomanianNums.ending(expr, n2);
                    res = CalcMethods.calc(n1, n2, res, expr);
                    fres = RomanianNums.transl(res);
                    System.out.println("Результат: " + fres);
                } else {
                    throw new SomethingWentWrong("Введите выражение корректно");
                }
            }
        }
    }
static class CalcMethods {
    public static int calc(int x, int y, int r, String expr) throws SomethingWentWrong {  //метод, отвечающий за вычисления
        if (expr.contains("+")) {
            r = x + y;
        } else if (expr.contains("-")) {
            r = x - y;
        } else if (expr.contains("*")) {
            r = x * y;
        } else if (expr.contains("/")) {
            r = x / y;
        }
        else{
            throw new SomethingWentWrong("Введите выражение, состоящее только из двух арабских или римских цифр от 1 до 10 включительно");
        }
        return r;
    }
}
static class EnteringTheString {
        public static String gettingString() {      //метод, отвечающий за ввод выражения
            System.out.println("Введите выражение");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            return str;
        }
}
public static class RomanianNums {
        public static int beginning(String str, int num) throws SomethingWentWrong {  //метод для работы с римскими цифрами, который обрабатывает
            if (str.startsWith("VIII+", 0)) {
                num = 8;
            } else if (str.startsWith("VIII-", 0)) {
                num = 8;
            } else if (str.startsWith("VIII*", 0)) {
                num = 8;
            } else if (str.startsWith("VIII/", 0)) {
                num = 8;
            } else if (str.startsWith("III-", 0)) {
                num = 3;
            } else if (str.startsWith("III+", 0)) {
                num = 3;
            } else if (str.startsWith("III*", 0)) {
                num = 3;
            } else if (str.startsWith("III/", 0)) {
                num = 3;
            } else if (str.startsWith("VII-", 0)) {
                num = 7;
            } else if (str.startsWith("VII+", 0)) {
                num = 7;
            } else if (str.startsWith("VII*", 0)) {
                num = 7;
            } else if (str.startsWith("VII/", 0)) {
                num = 7;
            } else if (str.startsWith("IV-", 0)) {
                num = 4;
            } else if (str.startsWith("IV+", 0)) {
                num = 4;
            } else if (str.startsWith("IV*", 0)) {
                num = 4;
            } else if (str.startsWith("IV/", 0)) {
                num = 4;
            } else if (str.startsWith("IX-", 0)) {
                num = 9;
            } else if (str.startsWith("IX+", 0)) {
                num = 9;
            } else if (str.startsWith("IX*", 0)) {
                num = 9;
            } else if (str.startsWith("IX/", 0)) {
                num = 9;
            } else if (str.startsWith("VI-", 0)) {
                num = 6;
            } else if (str.startsWith("VI+", 0)) {
                num = 6;
            } else if (str.startsWith("VI*", 0)) {
                num = 6;
            } else if (str.startsWith("VI/", 0)) {
                num = 6;
            } else if (str.startsWith("II-", 0)) {
                num = 2;
            } else if (str.startsWith("II+", 0)) {
                num = 2;
            } else if (str.startsWith("II*", 0)) {
                num = 2;
            } else if (str.startsWith("II/", 0)) {
                num = 2;
            } else if (str.startsWith("I-", 0)) {
                num = 1;
            } else if (str.startsWith("I+", 0)) {
                num = 1;
            } else if (str.startsWith("I*", 0)) {
                num = 1;
            } else if (str.startsWith("I/", 0)) {
                num = 1;
            } else if (str.startsWith("V-", 0)) {
                num = 5;
            } else if (str.startsWith("V+", 0)) {
                num = 5;
            } else if (str.startsWith("V*", 0)) {
                num = 5;
            } else if (str.startsWith("V/", 0)) {
                num = 5;
            } else if (str.startsWith("X-", 0)) {
                num = 10;
            } else if (str.startsWith("X+", 0)) {
                num = 10;
            } else if (str.startsWith("X*", 0)) {
                num = 10;
            } else if (str.startsWith("X/", 0)) {
                num = 10;
            }
            else {
                throw new SomethingWentWrong("Введите выражение, состоящее только из двух арабских или римских цифр от 1 до 10 включительно");
            }
            return num;
        }
    public static int ending(String str, int num) throws SomethingWentWrong {  //метод для работы с римскими цифрами, который обрабатывает
        if (str.endsWith("VIII")) {                                           //конец строки и присваивает значение второй переменной
            num = 8;
        } else if (str.endsWith("III")) {
            num = 3;
        } else if (str.endsWith("VII")) {
            num= 7;
        } else if (str.endsWith("IV")) {
            num = 4;
        } else if (str.endsWith("VI")) {
            num = 6;
        } else if (str.endsWith("IX")) {
            num = 9;
        } else if (str.endsWith("II")) {
            num = 2;
        }else if (str.endsWith("X")) {
                num = 10;
        } else if (str.endsWith("I")) {
            num = 1;
        } else if (str.endsWith("V")) {
            num = 5;
        }
        else{
            throw new SomethingWentWrong("Введите выражение, состоящее только из двух арабских или римских цифр от 1 до 10 включительно");
        }
        return num;
    }
    public static String romanianDigit(int n, String one, String five, String ten){

        if(n >= 1)
        {
            if(n == 1)
            {
                return one;
            }
            else if (n == 2)
            {
                return one + one;
            }
            else if (n == 3)
            {
                return one + one + one;
            }
            else if (n==4)
            {
                return one + five;
            }
            else if (n == 5)
            {
                return five;
            }
            else if (n == 6)
            {
                return five + one;
            }
            else if (n == 7)
            {
                return five + one + one;
            }
            else if (n == 8)
            {
                return five + one + one + one;
            }
            else if (n == 9)
            {
                return one + ten;
            }

        }
        return "";
    }

    public static String transl(int number){

        String romanOnes = romanianDigit( number%10, "I", "V", "X");
        number /=10;
        String romanTens = romanianDigit( number%10, "X", "L", "C");
        number /=10;
        String romanHunds = romanianDigit(number%10, "C", "D", "M");
        number /=10;

        String result = romanHunds + romanTens + romanOnes;
        return result;

    }
}
}
class SomethingWentWrong extends Exception {    //класс, отвечающий за правильность данных, введенных пользователем

    public SomethingWentWrong(String message) {
        super(message);
    }
}



