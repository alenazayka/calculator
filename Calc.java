import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calc {
    public static void main(String[] args) throws SomethingWentWrong {
        String expr = EnteringTheString.gettingString();
        char num1, num2;
        int res = 0;
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher(expr);

        if (Character.isDigit(expr.charAt(0))) {
            if (m.find()) {
                throw new SomethingWentWrong("Введите выражение, состоящее только из арабских или римских цифр");
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
                throw new SomethingWentWrong("Введите выражение, состоящее только из арабских или римских цифр");
            } else {
                if (expr.length() <= 9) {
                    n1 = RomanianNums.beginning(expr, n1);
                    n2 = RomanianNums.ending(expr, n2);
                    res = CalcMethods.calc(n1, n2, res, expr);
                    System.out.println("Результат: " + res);
                } else {
                    throw new SomethingWentWrong("Введите выражение корректно");
                }
            }
        }
    }
static class CalcMethods {
    public static int calc(int x, int y, int r, String expr) {  //метод, отвечающий за вычисления
        if (expr.contains("+")) {
            r = x + y;
        } else if (expr.contains("-")) {
            r = x - y;
        } else if (expr.contains("*")) {
            r = x * y;
        } else if (expr.contains("/")) {
            r = x / y;
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
        public static int beginning(String str, int num){  //метод для работы с римскими цифрами, который обрабатывает
            if (str.startsWith("VIII")) {                 //начало строки и присваивает значение первой переменной
                num = 8;
            } else if (str.startsWith("III")) {
                num = 3;
            } else if (str.startsWith("VII")) {
                num = 7;
            } else if (str.startsWith("IV")) {
                num = 4;
            } else if (str.startsWith("IX")) {
                num = 9;
            } else if (str.startsWith("VI")) {
                num = 6;
            } else if (str.startsWith("II")) {
                num = 2;
            } else if (str.startsWith("I")) {
                num = 1;
            } else if (str.startsWith("V")) {
                num = 5;
            } else if (str.startsWith("X")) {
                num = 10;
            }
            return num;
        }
    public static int ending(String str, int num){  //метод для работы с римскими цифрами, который обрабатывает
        if (str.endsWith("VIII")) {                 //конец строки и присваивает значение второй переменной
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
        } else if (str.endsWith("I")) {
            num = 1;
        } else if (str.endsWith("V")) {
            num = 5;
        } else if (str.endsWith("X")) {
            num = 10;
        }
        return num;
    }
}
}
class SomethingWentWrong extends Exception {    //класс, отвечающий за правильность данных, введенных пользователем

    public SomethingWentWrong(String message) {
        super(message);
    }
}



