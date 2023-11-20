package Calculator;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args){
        Scanner y = new Scanner(System.in);
        System.out.println("Введите выражение через пробел");
        String input = y.nextLine();
        String resoult = Error(input);
        System.out.println(resoult);
    }
    public static String Error (String input){
        String Error = "Ошибка, формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        String [] p ;
        if (input!=""){
            p=input.split(" ");
        }else{
            return Error;
        }
        try {if (p[1]==""){
            return Error;
        }else if (p[2]==""){
            return Error;
        }
        }
        catch (ArrayIndexOutOfBoundsException e){
            return Error;
        }
        if(p.length>3){
            return Error;
        }
        if (RimisArab(input)==0){
            return String.valueOf(Eq(p));
        }
        else if (RimisArab(input)==2){
            return CalcRim(p);
        }
        return Error;
    }
    public static int RimisArab (String input){
        String [] p = input.split(" ");
        String [] Arab = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int a=0;
        int b=0;
        for (String Arab1 : Arab){
            if (p[0].equals(Arab1)){
                a=1;
                break;
            }
        }
        for (String Arab2 : Arab){
            if (p[2].equals(Arab2)) {
            b=1;
            break;}
        }return a+b;
    }
    public static String CalcRim (String [] p){
        String [] Rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int number1 =0;
        int number2 =0;
        String x=p[1];
        for (int i=0;i<=Rim.length;i++){
            if(p[0].equals(Rim[i])){
                number1=i;
                break;
            }
        }
        for (int i=0;i<=Rim.length;i++){
            if(p[2].equals(Rim[i])){
                number2=i;
                break;
            }
        }
        int c = CalcArab(number1,number2,x); // (int)
        return Rim[c];
    }

    public static String Eq (String[] p) {
        String number11 = p[0];
        String x = p[1];
        String number22 = p[2];
        int number1;
        int number2;
        try{number2 = Integer.parseInt(number22);}
        catch (NumberFormatException e){
            return Error("Ошибка");
        }
        number1 = Integer.parseInt(number11);

        return String.valueOf(CalcArab(number1,number2,x));
    }
    public static int CalcArab (int number1,int number2, String x){
        int result=0;
        if (number1>=0&&number1<=10&&number2>=0&&number2<=10){
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
                    if (number2==0){
                        System.out.println("Делить на ноль нельзя");
                        result=0;
                    }
                    result=number1/number2;
                    break;
                default:
                    System.out.println("Ошибка");
            }return result;
        }else {
            System.out.println("Ошибка");
        }return result;
    }
}
