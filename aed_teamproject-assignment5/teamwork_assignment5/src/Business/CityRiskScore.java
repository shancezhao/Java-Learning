/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Shance
 */
public class CityRiskScore {

    private PersonDirectory personDirectory;
    private FamilyDirectory familyDirectory;
    private CommunityDirectory communityDirectory;
    private HouseDirectory houseDirectory;
    private CityDirectory cityDirectory;

    public CityRiskScore(int a, PersonDirectory personDirectory, FamilyDirectory familyDirectory, CommunityDirectory communityDirectory, HouseDirectory houseDirectory, CityDirectory cityDirectory) {
        //输入想计算的人名，进行查找匹配，然后计算出其危险指数
        this.personDirectory = personDirectory;
        this.familyDirectory = familyDirectory;
        this.communityDirectory = communityDirectory;
        this.houseDirectory = houseDirectory;
        //cityDirectory = config.

        int A = 0;

        int B = 0;
        int Risk = 0;
        for (Person person : personDirectory.getPersonDirectory()) {
            String gender = person.getGender();
            int lp = 0;
            int cp = 0;
            A = 0;
            B = 0;
            int age = person.getAge();
            int s = person.getVitalSign().getSmoke();
            int d = person.getVitalSign().getDiabetes();
            int bps = person.getVitalSign().getPressure();
            int bpd = person.getVitalSign().getDiastolicPressure();
            int tc = person.getVitalSign().getTotalCho();
            int ldl = person.getVitalSign().getLDLcho();
            int hdl = person.getVitalSign().getHDLCho();

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
            //person
            A = A + lp;
            B = B + cp;
            Risk = (A + B) / 2;

            //city
            person.setCP(cp);
            person.setLP(lp);
            person.setRISK(Risk);
        }

        double personRisk = 0;
        int pcount = 0;
        for (Person person : personDirectory.getPersonDirectory()) {

            personRisk = person.getRISK() + personRisk;
            pcount++;

        }
        personRisk = personRisk / pcount;
        if (a == 1) {
            for (Person person : personDirectory.getPersonDirectory()) {
                System.out.println("Risk Score for each Person is:\n" + person + "\n");
            }

        }
        //Family
        Family[] newFamily = new Family[200];
        double familyRisk = 0;
        for (Family family : familyDirectory.getFamilyDirectory()) {
            //for(int fa = 1;a<201;a++){

            int count = 0;
            for (Person fperson : family.getPersons()) {

                familyRisk = fperson.getRISK() + familyRisk;
                count++;
            }
            familyRisk = familyRisk / count;
            family.setRiskScore(familyRisk);
            if (a == 5) {
                System.out.println("Risk Score for each Family is:\n" + family + "\n");

            }
        }
        //House
        for (House house : houseDirectory.getHouseDirectory()) {
            double houseRisk = 0;
            for (Family hfamily : house.getAllFamily()) {
                houseRisk = houseRisk + hfamily.getRiskScore();
                house.setRiskScore(houseRisk);
                if (a == 4) {
                    System.out.println("Risk Score for each House is:\n" + house + "\n");
                }
            }
        }

        //Community
        for (Community community : communityDirectory.getCommunityDirectory()) {
            double communityRisk = 0;
            for (House chouse : community.getAllHouse()) {
                communityRisk = communityRisk + chouse.getRiskScore();
                community.setRiskScore(communityRisk);
                
            }
            if (a == 3) {
                    System.out.println("Risk Score for each Community is:\n" + community + "\n");

                }
        }

        //City
        int count = 0;
        for (City city : cityDirectory.getCityDirectory()) {
            double cityRisk = 0;

            for (Community ccom : city.getCommunity()) {
                cityRisk = cityRisk + ccom.getRiskScore();
                count++;
            }
            cityRisk = cityRisk / count;
            if (a == 2) {
                System.out.println("Risk Score for the City is:\n" + city + "\n Risk Score:" + cityRisk);
            }
        }
    }
}
