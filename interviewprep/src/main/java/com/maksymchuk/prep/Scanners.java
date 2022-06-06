package com.maksymchuk.prep;

import java.util.Scanner;

public class Scanners {
    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
 
        System.out.println("Enter a string: ");
        String s = in.nextLine();
        System.out.println("You entered string " + s);
 
        System.out.println("Enter an integer: ");
        int a = in.nextInt();
        System.out.println("You entered integer " + a);
 
        System.out.println("Enter an float: ");

        float b = in.nextFloat();
        System.out.println("You entered float " + b);
          // closing scanner
          in.close();
    }
}
