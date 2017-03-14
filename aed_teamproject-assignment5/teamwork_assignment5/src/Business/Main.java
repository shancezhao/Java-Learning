/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Scanner;

/**
 *
 * @author Shance
 */
public class Main {

    public static void main(String args[]) throws Exception {
        System.out.println("***************************Welcome to the FRAMIGHAM HEART ORGANIZATION SYSTEM***************************");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        while (true) {
            System.out.println("******************1.TEST YOUR HEALTH STATUS*************************");
            System.out.println("******************2.CITY LEVEL REPORT*************************");
            System.out.println("******************3.COMMUNITY LEVEL REPORT*************************");
            System.out.println("******************4.HOUSE LEVEL REPORT*************************");
            System.out.println("******************5.FAMILY LEVEL REPORT*************************");
            System.out.println("******************6.PERSON LEVEL REPORT*************************");
            System.out.println("******************0.EXIT THE SYSTEM*************************");
            System.out.println("------------Please enter the choice for Reports------------");
            int choice = reader.nextInt();
            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("***************TEST STARTS******************");
                     {
                        Config.Config(1);
                    }
                    System.out.println("***************TEST ENDS******************");
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("***************CITY LEVEL REPORT******************");
                    Config.Config(2);
                    System.out.println("***************REPORT ENDS******************");
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("***************COMMUNITY LEVEL REPORT******************");
                    Config.Config(3);
                    System.out.println("***************REPORT ENDS******************");
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("***************HOUSE LEVEL REPORT******************");
                    Config.Config(4);
                    System.out.println("***************REPORT ENDS******************");
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("***************FAMILY LEVEL REPORT******************");
                    Config.Config(5);
                    System.out.println("***************REPORT ENDS******************");
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("***************PERSON LEVEL REPORT******************");
                    Config.Config(6);
                    System.out.println("***************REPORT ENDS******************");
                    System.out.println();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("***************EXIT******************");
                    System.exit(0);
            }
        }
    }
}
