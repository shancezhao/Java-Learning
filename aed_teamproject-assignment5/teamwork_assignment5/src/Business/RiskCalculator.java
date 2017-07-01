/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Shance
 */
public class RiskCalculator {

    public static void RiskCalculator() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" Age (Yr):");
        int age = Integer.valueOf(br.readLine());
        System.out.print(" Smoking?(1 for Yes/0 for No):");
        int s = Integer.valueOf(br.readLine());
        System.out.print(" Diabetes?(1 for Yes/0 for No):");
        int d = Integer.valueOf(br.readLine());
        System.out.print(" Gender?(F for Women/M for Men):");
        String gender = String.valueOf(br.readLine());
        System.out.print(" Systolic(mm/Hg):");
        int bps = Integer.valueOf(br.readLine());
        System.out.print(" Diastolic(mm/Hg):");
        int bpd = Integer.valueOf(br.readLine());
        System.out.print(" Cholesterol(mg/dl):");
        int tc = Integer.valueOf(br.readLine());
        System.out.print(" LDL(mg/dl):");
        int ldl = Integer.valueOf(br.readLine());
        System.out.print(" HDL(mg/dl)");
        int hdl = Integer.valueOf(br.readLine());

        int cp = 0;
        int lp = 0;

        if (gender.equals("M")) {

            if (age >= 30 && age <= 34) {
                lp = lp - 1;
                cp = cp - 1;
            }
            if (age >= 35 && age <= 39) {
                lp = lp + 0;
                cp = cp + 0;
            }
            if (age >= 40 && age <= 44) {
                lp = lp + 1;
                cp = cp + 1;
            }
            if (age >= 45 && age <= 49) {
                lp = lp + 2;
                cp = cp + 2;
            }
            if (age >= 50 && age <= 54) {
                lp = lp + 3;
                cp = cp + 3;
            }
            if (age >= 55 && age <= 59) {
                lp = lp + 4;
                cp = cp + 4;
            }
            if (age >= 60 && age <= 64) {
                lp = lp + 5;
                cp = cp + 5;
            }
            if (age >= 65 && age <= 69) {
                lp = lp + 6;
                cp = cp + 6;
            }
            if (age >= 70 && age <= 74) {
                lp = lp + 7;
                cp = cp + 7;
            }
            if (d == 1) {
                lp = lp + 2;
                cp = cp + 2;
            }
            if (d == 0) {
                lp = lp + 0;
                cp = cp + 0;
            }//糖尿病的影响

            if (s == 1) {
                lp = lp + 2;
                cp = cp + 2;
            }
            if (s == 0) {
                lp = lp + 0;
                cp = cp + 0;
            }//吸烟的影响

            if (tc < 160) {
                cp = cp - 3;
            }
            if (tc >= 160 && tc <= 199) {
                cp = cp - 0;
            }
            if (tc >= 200 && tc <= 239) {
                cp = cp + 1;
            }
            if (tc >= 240 && tc <= 279) {
                cp = cp + 2;
            }
            if (tc >= 280) {
                cp = cp + 3;
            }//总体胆固醇的影响

            if (ldl < 100) {
                lp = lp + 0;
            }
            if (ldl >= 100 && ldl <= 159) {
                lp = lp + 0;
            }
            if (ldl >= 160 && ldl < 190) {
                lp = lp + 1;
            }
            if (ldl >= 190) {
                lp = lp + 2;
            }//ldl的影响

            if (hdl < 35) {
                lp = lp + 2;
                lp = cp + 2;
            }
            if (hdl >= 35 && hdl <= 44) {
                lp = lp + 1;
                lp = cp + 1;
            }
            if (hdl >= 45 && hdl <= 59) {
                lp = lp + 0;
                lp = cp + 0;
            }
            if (hdl >= 60) {
                lp = lp - 1;
                lp = cp - 2;
            }//hdl的影响

            //两种血压的影响
            if (bps <= 129 && bpd <= 84) {
                lp = lp + 0;
                cp = cp + 0;
            }
            if (bps <= 139 && bpd <= 84 && bps >= 130) {
                lp = lp + 1;
                cp = cp + 1;
            }
            if (bps <= 129 && bpd <= 89 && bpd >= 85) {
                lp = lp + 1;
                cp = cp + 1;
            }
            if (bps <= 159 && bpd <= 99 && bps >= 140) {
                lp = lp + 2;
                cp = cp + 2;
            }
            if (bps <= 139 && bpd <= 99 && bpd >= 90) {
                lp = lp + 2;
                cp = cp + 2;
            }

            if (bps >= 160 && bpd <= 99) {
                lp = lp + 3;
                cp = cp + 3;
            }

            if (bpd >= 100) {
                lp = lp + 3;
                cp = cp + 3;
            }
        }
        
        if (gender.equals("F")) {

                    if (age >= 30 && age <= 34) {
                        lp = lp - 9;
                        cp = cp - 9;
                    }
                    if (age >= 35 && age <= 39) {
                        lp = lp - 4;
                        cp = cp - 4;
                    }
                    if (age >= 40 && age <= 44) {
                        lp = lp + 0;
                        cp = cp + 0;
                    }
                    if (age >= 45 && age <= 49) {
                        lp = lp + 3;
                        cp = cp + 3;
                    }
                    if (age >= 50 && age <= 54) {
                        lp = lp + 6;
                        cp = cp + 6;
                    }
                    if (age >= 55 && age <= 59) {
                        lp = lp + 7;
                        cp = cp + 7;
                    }
                    if (age >= 60 && age <= 74) {
                        lp = lp + 8;
                        cp = cp + 8;
                    }

                    if (d == 1) {
                        lp = lp + 4;
                        cp = cp + 4;
                    }
                    if (d == 0) {
                        lp = lp + 0;
                        cp = cp + 0;
                    }//糖尿病的影响

                    if (s == 1) {
                        lp = lp + 2;
                        cp = cp + 2;
                    }
                    if (s == 0) {
                        lp = lp + 0;
                        cp = cp + 0;
                    }//吸烟的影响

                    if (tc < 160) {
                        cp = cp - 2;
                    }
                    if (tc >= 160 && tc <= 199) {
                        cp = cp - 0;
                    }
                    if (tc >= 200 && tc <= 239) {
                        cp = cp + 1;
                    }
                    if (tc >= 240 && tc <= 279) {
                        cp = cp + 1;
                    }
                    if (tc >= 280) {
                        cp = cp + 3;
                    }//总体胆固醇的影响

                    if (ldl < 100) {
                        lp = lp - 2;
                    }
                    if (ldl >= 100 && ldl <= 159) {
                        lp = lp + 0;
                    }

                    if (ldl >= 160) {
                        lp = lp + 2;
                    }//ldl的影响

                    if (hdl < 35) {
                        lp = lp + 5;
                        lp = cp + 5;
                    }
                    if (hdl >= 35 && hdl <= 44) {
                        lp = lp + 2;
                        lp = cp + 2;
                    }
                    if (hdl >= 45 && hdl <= 49) {
                        lp = lp + 1;
                        lp = cp + 1;
                    }
                    if (hdl >= 50 && hdl <= 459) {
                        lp = lp + 0;
                        lp = cp + 0;
                    }
                    if (hdl >= 60) {
                        lp = lp - 2;
                        lp = cp - 3;
                    }//hdl的影响

                    //两种血压的影响
                    if (bps <= 120 && bpd <= 80) {
                        lp = lp - 3;
                        cp = cp - 3;
                    }
                    if (bps <= 139 && bpd <= 89 && bps >= 120) {
                        lp = lp + 0;
                        cp = cp + 0;
                    }
                    if (bps <= 129 && bpd <= 89 && bpd >= 80) {
                        lp = lp + 0;
                        cp = cp + 0;
                    }
                    if (bps <= 159 && bpd <= 99 && bps >= 140) {
                        lp = lp + 2;
                        cp = cp + 2;
                    }
                    if (bps <= 139 && bpd <= 99 && bpd >= 90) {
                        lp = lp + 2;
                        cp = cp + 2;
                    }

                    if (bps >= 160 && bpd <= 99) {
                        lp = lp + 3;
                        cp = cp + 3;
                    }

                    if (bpd >= 100) {
                        lp = lp + 3;
                        cp = cp + 3;
                    }
                }

        System.out.println("------------The result is------------");
        System.out.println("cp point is "+cp);
        System.out.println("lp point is "+lp);
        if((cp<=2&&lp<=2)){
            System.out.println("You are UNLIKELY to have a heart disease!");
        }
        else if((cp>0&&cp<6)&&(lp>0&&lp<6)){
            System.out.println("Your rate to have a heart disease is under 10%!");
        }
        else if((cp>=6&&cp<8)&&(lp>=6&&lp<9)){
            System.out.println("Your rate to have a heart disease is under 20%! You need to pay attention to your health.");
        }
        else if(cp>=8&&lp>=9){
            System.out.println("Your rate to have a heart disease is high! You need to go to hospital regularly to have a check.");
        }
        else{
            System.out.println("You should pay attention to your health!");
        }
    }
}

