//Посчитать количество чисел от A до B (целые) таких, что цифры числа, рассмотренные по порядку слева направо,
// образуют арифметическую или геометрическую прогрессию. Будем считать, что все однозначные и двухзначные числа
// образуют арифметическую прогрессию. Для определения, подходит ли число под требования задачи, реализовать функцию.
// Также реализовать функцию для подсчета кол-ва таких чисел от 1 до n. Запрещено использовать строки и массивы.
// ПРИМЕР ДЛЯ ТЕСТА: 123 - 135 (123 - АП, 124 - ГП, 135 - АП)
package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static boolean check(int x){
        int arithmetic = x % 10  - x / 10 % 10;
        double geometric = 1.0 * (x % 10) / (x / 10 % 10);
        int count= 0;
        int flag = 0;

        if(x >= 0 && x < 10){
          return true;
        }

        while(x > 9){
            if ((x % 10  - x / 10 % 10 == arithmetic) || ((x % 10) / (x / 10 % 10) == geometric)){
                count++;
            }

            flag++;
            x = x / 10;
        }

        return (flag == count);
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = 0;

        for (int i = a; i <= b; i++){
            if (check(i)){
                sum++;
            }
        }

        System.out.println(sum + " чисел подходящих под условие задачи");
    }
}

