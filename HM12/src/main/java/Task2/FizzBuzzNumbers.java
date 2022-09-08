package Task2;

import java.util.Scanner;

public class FizzBuzzNumbers {

    private static int number = 0;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in any number from 1 to n, please: ");

        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            number++;
            substitutionOfValues();
        }

        System.out.println(result.substring(0,result.length()-2).toString());
    }

    private static void substitutionOfValues() {
        Thread threadOne = new Thread(() -> {
            if (number % 3 == 0 && number % 5 != 0) {
                result.append("fizz, ");
            }
        });

        threadOne.start();
        threadOne.interrupt();
        
        
        Thread threadTwo = new Thread(() -> {
            if (number % 5 == 0 && number % 3 != 0 ) {
                result.append("buzz, ");
            }
        });
        threadTwo.start();
        try {
            threadTwo.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadTwo.interrupt();

        Thread threadThree = new Thread(() -> {
            if (number % 15 == 0 ) {
                result.append("fizzbuzz, ");
            }
        });
        threadThree.start();
        try {
            threadThree.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadThree.interrupt();

        Thread threadD = new Thread(() -> {
            if (number % 3 != 0 && number % 5 != 0 ) {
                result.append(number + ", ");
            }
        });
        threadD.start();
        try {
            threadD.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadD.interrupt();
    }
}
