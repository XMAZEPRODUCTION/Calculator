package Calculator;

import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner y = new Scanner(System.in);
        System.out.println("Введите выражение через пробел");
        String input = y.nextLine();
        String resoult = calc(input);
        System.out.println(resoult);
    }
    public static String calc (String input){
        String Error = "throws Exception";
        String [] p ;
        if (input!=""){
            p=input.split(" ");
        }else{
            System.out.print("2w");
            return Error;
        }
        try {if (p[1]==""){
        return Error;
        }if (p[2]==""){
            return Error;
        }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Cтрока не является математической операцией ");
            return Error;
        }
        if(p.length>3){
            System.out.print("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) ");
            return Error;
        }
        return String.valueOf(Eq(p));

    }



    public static String Eq (String[] p) {
        String number11 = p[0];
        String x = p[1];
        String number22 = p[2];
        int number1;
        int number2;
        try {
            number1 = Integer.parseInt(number11);
            number2 = Integer.parseInt(number22);
        }
        catch (NumberFormatException e){
            return calc("Ошибка");
        }
        return String.valueOf(CalcArab(number1,number2,x));
    }
    public static int CalcArab (int number1,int number2, String x){
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
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }else {
            System.out.println("Числа должны быть от 1 до 10 включительно");
        }return result;
    }
}
