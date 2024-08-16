package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int fails = 0;
        int m1, m2, ans;

        for (int i = 0; i < 5; i++) {
            m1 = RandValue(1, 10);
            m2 = RandValue(1, 10);

            System.out.print(m1 + " * " + m2 + " = ");
            ans = cin.nextInt();

            if(ans != m1 * m2)
                fails++;
        }

        if(fails == 0) {
            System.out.println("Great!");
        } else if (fails == 5) {
            System.out.println("Practice! Practice! Practice!");
        } else {
            System.out.println("Practice!");
        }
    }

    public static int RandValue(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}