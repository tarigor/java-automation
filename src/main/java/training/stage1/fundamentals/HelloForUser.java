package training.stage1.fundamentals;

import java.io.IOException;
import java.math.BigInteger;
import java.time.Month;
import java.util.Random;
import java.util.Scanner;

public class HelloForUser {
    public static void main(String[] args) throws IOException {
//        firstTask();
//        secondTask();
 //         thirdTask();
//          fourthTask();
            fifthTask();
    }
    public static void firstTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?:");
        String name = in.next();
        System.out.println("Hello " + name.toString() + "!");
    }

    public static void secondTask() {
        Integer numberInputed;
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Input the set of number:");
        String setNumber = inputNumber.next();
        int amountChars = setNumber.length();
        for (int i = setNumber.length()-1;i>=0; i--) {
            System.out.print(setNumber.charAt(i));
        }
    }

    public static void fourthTask() {
        Scanner inputNumber = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        BigInteger sumNumber=BigInteger.valueOf(0);
        BigInteger multNumber= BigInteger.valueOf(1);
        int endFlag=1;
        for (int i = 0; i < endFlag; i++) {
            endFlag = 1 + endFlag;
            System.out.println("Input a number:");
            BigInteger setNumber = BigInteger.valueOf(inputNumber.nextInt());
            sumNumber= sumNumber.add(setNumber);
            multNumber = multNumber.multiply(setNumber);
            //check for output
            System.out.println("Stop calculation yes/no?:");
            String getAnswer = answer.next();
            if (getAnswer.contains("yes")) {
                endFlag = endFlag-3;
                System.out.println("summa: "+sumNumber);
                System.out.println("multi: "+multNumber);
            }
            else{ continue;};
        }
       }
       public static void thirdTask(){
        int amountOfNumb;
        int outFlag;
        Scanner inAmOfNum = new Scanner(System.in);
        System.out.println("Input amount of rand numbers:");
        Integer amOfNum = inAmOfNum.nextInt();
        System.out.println("Collection of random nubers: ");
           for (int i = 0; i < amOfNum; i++) {
//               Random rand = new Random();
               System.out.println(Math.random());
           }
           for (int i = 0; i < amOfNum; i++) {
//               Random rand = new Random();
               System.out.print(" "+Math.random());
           }
       }

    public static void fifthTask () {
        int inpNum;
        int outFlag=0;
        Scanner cmdInNum = new Scanner(System.in);
        while (outFlag==0) {
            System.out.println("Input a number from 1 to 12: ");
            Integer num = cmdInNum.nextInt();
            if (num >= 1 && num <= 12) {
                Month getMonth = Month.of(num);
                System.out.println("The number: " + num + " is a month: " + getMonth);
                break;
            } else {
                System.out.println("Input a correct number");
                outFlag=0;
            }
        }
    }
}
