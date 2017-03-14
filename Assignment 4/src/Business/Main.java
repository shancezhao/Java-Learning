/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import static java.lang.System.exit;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        System.out.println("*********Welcome to the EDUCATION LEVEL SYSTEM********* ");
        System.out.println("------------Please enter the choice below for Reports------------ ");
        System.out.println("1.UNIVERSITY LEVEL Employment Rate REPORTS");
        System.out.println("2.DEPARTMENT LEVEL REPORTS");
        System.out.println("3.COLLEGE LEVEL REPORTS ABOUT COURSE");
        System.out.println("4.DEPARTMENT INFORMATION");
        System.out.println("5.INFORMATION ABOUT UNIVERSITY");
        System.out.println("0.EXIT");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        while(true){
            System.out.println("------------Please enter a Choice Number------------ ");
            int choice = reader.nextInt();
            switch (choice) {
                case 1:
                    //Retrieving the values from the Initialization file
                    System.out.println();
                    System.out.println("***************UNIVERSITY EMPLOYMENT RATE REPORTS STARTS******************");
                    Config.Config(1);
                    System.out.println("***************UNIVERSITY EMPLOYMENT RATE REPORTS ENDS******************");
                    break;
                case 2:
                    System.out.println("***************DEPARTMENT EMPLOYMENT RATE STARTS******************");
                    System.out.print("\n1.ENGINEERING");
                    System.out.print("\n2.BUSINESS");
                    System.out.print("\n3.LAW\n");
                    System.out.println("***************CHOICE ONE DEPARTMENT******************");
                    Scanner reader2 = new Scanner(System.in);
                            int choice2 = reader2.nextInt();
                    System.out.println("***************EMPLOYMENT RATE REPORTS ******************");

                    if(choice2 == 1){
                               Config.Config(11); 
                            }if(choice2 == 2){
                               Config.Config(12); 
                            }if(choice2 == 3){
                               Config.Config(13); 
                            }
                            else{
                                break;
                            } 
                            break;
            
                case 3:
                        Config.Config(2);
                        System.out.println("------------Do you want to see all students?(1/0)------------ ");
                        Scanner reader1 = new Scanner(System.in);
                        int choice1 = reader1.nextInt();
                            
                        if(choice1 == 1){
                           Config.Config(9);
                           System.out.println("1.UNIVERSITY LEVEL Employment Rate REPORTS");
                           System.out.println("2.DEPARTMENT LEVEL REPORTS");
                           System.out.println("3.COLLEGE LEVEL REPORTS ABOUT COURSE");
                           System.out.println("4.DEPARTMENT INFORMATION");
                           System.out.println("5.INFORMATION ABOUT UNIVERSITY");
                           System.out.println("0.EXIT");
                        }if(choice1 == 0){
                            System.out.println("***************break******************");
                            System.out.println("1.UNIVERSITY LEVEL Employment Rate REPORTS");
                            System.out.println("2.DEPARTMENT LEVEL REPORTS");
                            System.out.println("3.COLLEGE LEVEL REPORTS ABOUT COURSE");
                            System.out.println("4.DEPARTMENT INFORMATION");
                            System.out.println("5.INFORMATION ABOUT UNIVERSITY");
                            System.out.println("0.EXIT");
                        }
                        else{
                              break;
                            }
                     break;   
                case 4:
                    Config.Config(3);
                    break;
                case 5:
                    Config.Config(4);
                    break;
                case 0:
                    exit(0);
            }
        }
    }
}
