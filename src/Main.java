import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input){

        int result;
        char operation = ' ';
        int isEnd = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+': operation ='+'; isEnd=1; break;
                case '-': operation ='-'; isEnd=1; break;
                case '*': operation ='*'; isEnd=1; break;
                case '/': operation ='/'; isEnd=1; break;
                default: ;
            if(isEnd == 1)
                break;
            }
        }

        String[] parts = input.split("[+-/*]");
        if(parts.length!=2)
            trowEx();
        String a = parts[0].trim();
        String b = parts[1].trim();
        int num1 = ToNum(a);
        int num2 = ToNum(b);
        if (num1 < 0 || num2 < 0 || num1 >10 || num2>10) {
            result = 0;
        }
        else {
            result = calculation(num1, num2, operation);
            String resultRoman = ToRoman(result);
            return resultRoman;
        }
        num1 = Integer.parseInt(a);
        num2 = Integer.parseInt(b);
        if(num1 < 0 || num2 < 0 || num1 >10 || num2>10)
        {
            trowEx();
        }
        result = calculation(num1, num2, operation);
        return Integer.toString(result);
    }
    static int calculation(int a, int b, char oper) {
        int result = -11;
        switch (oper)
        {
            case'+': result = a+b; break;
            case'-': result = a-b; break;
            case'/': result = a/b; break;
            case'*': result = a*b; break;
            default: trowEx();
        }
        return result;
    }
    static void trowEx()
    {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static String ToRoman (int num) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String romanNum = roman[num];
        return romanNum;
    }

    static int ToNum(String roman)
    {   try {
            if (roman.equals("I")) {return 1;}
            else if (roman.equals("II")) {return 2;}
            else if (roman.equals("III")) {return 3;}
            else if (roman.equals("IV")) {return 4;}
            else if (roman.equals("V")) {return 5;}
            else if (roman.equals("VI")) {return 6;}
            else if (roman.equals("VII")) {return 7;}
            else if (roman.equals("VIII")) {return 8;}
            else if (roman.equals("IX")) {return 9;}
            else if (roman.equals("X")) {return 10;}
            }
            catch (InputMismatchException e) {
                throw new InputMismatchException();
            }
            return -1;
    }
}
