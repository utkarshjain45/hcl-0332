package com.hcl.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============Library Menu===============");

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1.Add items");
            System.out.println("2.Register Member");
            System.out.println("3.Borrow");
            System.out.println("4.Return");
            System.out.println("5.Waitlist");
            System.out.println("6.List Items");
            System.out.println("7.Search");
            System.out.println("8.Export Report");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            if(choice >= 9 || choice < 0){
                throw new IllegalArgumentException("Option Not Valid.");
            }

            switch (choice){
                case 1:

            }
        }
    }
}
