package Calculator;

import java.sql.SQLOutput;
import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner y = new Scanner(System.in);
        System.out.println("Введите выражение через пробел");
        String input = y.nextLine();
        String resoult = calc(input);
        System.out.println(resoult);
    }
    public static String calc (String input) throws ArrayIndexOutOfBoundsException {
        String [] p ;
        if (input==""){
            throw new ArrayIndexOutOfBoundsException("Строка не является математической операцией");
        }
        p=input.split(" ");
        if (p.length<3||p.length>3) {
            throw new ArrayIndexOutOfBoundsException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return String.valueOf(Eq(p));
    }

    public static String Eq (String[] p) {
        String number11 = p[0];
        String x = p[1];
        String number22 = p[2];
        int number1 = 0;
        int number2 = 0;
        try {number1 = Integer.parseInt(number11);number2 = Integer.parseInt(number22);}
        catch (NumberFormatException e){
            throw new NumberFormatException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return String.valueOf(CalcArab(number1,number2,x));
    }
    public static int CalcArab (int number1,int number2, String x) throws NumberFormatException {
        int result=0;
        if (number1>0&&number1<11&&number2>0&&number2<11){
            switch (x) {
                case "+":
                    result=number1+number2;
                    break;
                case"-":
                    result=number1-number2;
                    break;
                case"*":
                    result=number1*number2;
                    break;
                case"/":
                    result=number1/number2;
                    break;
                default:
                    throw new NumberFormatException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }else {
            throw new NumberFormatException("Числа должны быть от 1 до 10 включительно");
        }return result;
    }
}
