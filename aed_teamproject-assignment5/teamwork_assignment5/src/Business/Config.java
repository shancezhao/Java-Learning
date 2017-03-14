/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Random;

/**
 *
 * @author Shance
 */
public class Config {

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static void Config(int func) throws Exception {
        int i = 0;
        Random random = new Random();

        CityDirectory cityDirectory = new CityDirectory();
        City city = new City();
        CommunityDirectory communityDirectory = new CommunityDirectory();

        HouseDirectory houseDirectory = new HouseDirectory();
        FamilyDirectory familyDirectory = new FamilyDirectory();
        PersonDirectory personDirectory = new PersonDirectory();
        VitalSign[] vitalSign = new VitalSign[2000];
        VitalSignHistory vitalSignHistory = new VitalSignHistory();
        String[] nameArray = {
            "Green", "White", "Black", "Smith", "Johnson", "Williams", "Jones", "Brown", "Miller", "Moore", "Wilson", "Taylor", "Jackson",
            "Anderson", "Thomas", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rogiguez", "Lewis", "Lee", "Walker",
            "Lee", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Scott", "Adams", "Baker", "Perez", "Roberts", "Turner",
            "Phillips", "Campbell", "Paker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell",
            "Murphy", "Bailey", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Grey", "Ramorez", "James", "Watson",
            "Brooks", "Lelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell",
            "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler", "Simmons", "Foster", "Gonazles", "Bryant", "Alexander", "Russell",
            "Griffin", "Diaz", "Hyes", "Myers", "Ford", "Wallace", "Sullivan", "Cole", "West", "Jorden", "Owens", "Ellis", "Gibson"};

        //set 100 families 
        int fi = 0;
        Family[] ff = new Family[200];
        ff[fi] = new Family();
        for (i = 0; i < 200; i++) {
            long r_fNum = (long) (Math.random() * 200) + 1;
            Family[] f = new Family[200];
            f[i] = new Family();
            f[i].setFamilyNumber(r_fNum);
            ff[i] = f[i];
            familyDirectory.addFamily(ff[i]);

        }

        //set 1000 persons
        int pi = 0;
        Person[] pp = new Person[2000];
        pp[pi] = new Person();
        for (i = 0; i < 2000; i++) {
            int r_age = random.nextInt(100);
            int length = (int) (4 * Math.random() + 3);
            long r_id = random.nextInt(100000);
            int r_Lastname = (int) (Math.random() * 105);
            String r_firstName = generateString(random, "QWERTYUIOPASDFGHJKLZXCVBNMabcdefghijklmnopqrstuvwxyz", length);
            String r_lastName = nameArray[r_Lastname];
            String r_gender = generateString(random, "FM", 1);

            Person[] p = new Person[2000];
            p[i] = new Person();

            //set VitalSign in person
            int v_heartbeat = (int) (60 * Math.random() + 40);
            int v_pressure = (int) (86 * Math.random() + 80);
            int v_smoke = (int) (Math.random() * 2);
            int v_diabetes = (int) (Math.random() * 2);
            int v_weight = (int) (100 * Math.random() + 1);
            int v_height = (int) (80 * Math.random() + 40);
            int v_HDL = 30 + (int) (Math.random() * 31);
            int v_TotalCho = 150 + (int) (Math.random() * 101);
            int v_LDL = 50 + (int) (Math.random() * 141);//low density cholesterol range
            int v_diastolic = 50 + (int) (Math.random() * 51);//diastolic pressure range

            vitalSign[i] = new VitalSign(v_diabetes, v_pressure, v_smoke, v_height, v_weight, v_TotalCho, v_HDL, v_heartbeat, v_diastolic, v_LDL);
            vitalSign[i].setHeartbeat(v_heartbeat);
            vitalSign[i].setPressure(v_pressure);
            vitalSign[i].setSmoke(v_smoke);
            vitalSign[i].setWeight(v_weight);
            vitalSign[i].setHeight(v_height);
            vitalSign[i].setHDLCho(v_HDL);
            vitalSign[i].setTotalCho(v_TotalCho);
            vitalSign[i].setDiastolicPressure(v_pressure);
            vitalSign[i].setLDLcho(v_LDL);
            vitalSignHistory.addVitalSign(vitalSign[i]);

            p[i].setPersonId(r_id);
            p[i].setFirstName(r_firstName);
            p[i].setLastName(r_lastName);
            p[i].setAge(r_age);
            p[i].setGender(r_gender);
            p[i].setVitalSign(vitalSign[i]);
            //make family role related to age
            if (r_age < 20) {
                p[i].setFamilyRole("individual");
            }
            if (r_age > 27 && r_age < 45) {
                p[i].setFamilyRole("parent");
            }
            if (r_age > 50) {
                p[i].setFamilyRole("grandparent");
            } else {
                p[i].setFamilyRole("no family");
            }
            pp[i] = p[i];
            personDirectory.addPerson(pp[i]);

        }

        int fcount1 = 0;
        int fcount2 = 0;
        int fcount3 = 0;
        int fcount4 = 0;
        int fcount5 = 0;
        int p_count = 0;
        for (Family f : familyDirectory.getFamilyDirectory()) {

            int ppf = p_count;
            int allNumber = p_count + 10;
            for (ppf = p_count; ppf < allNumber; ppf++) {
                p_count++;
                if (pp[ppf].getAge() < 15) {
                    if (fcount1 < 1) {
                        f.getPersons().add(pp[ppf]);
                        fcount1++;
                    }
                }
                if ((pp[ppf].getAge() > 27) && (pp[ppf].getAge() < 45) && ("F".equals(pp[ppf].getGender()))) {
                    if (fcount2 < 1) {
                        f.getPersons().add(pp[ppf]);
                        fcount2++;
                    }
                }
                if ((pp[ppf].getAge() > 27) && (pp[ppf].getAge() < 45) && ("M".equals(pp[ppf].getGender()))) {
                    if (fcount3 < 1) {
                        f.getPersons().add(pp[ppf]);
                        fcount3++;
                    }
                }
                if ((pp[ppf].getAge() > 50) && (pp[ppf].getAge() < 90) && ("F".equals(pp[ppf].getGender()))) {
                    if (fcount4 < 1) {
                        f.getPersons().add(pp[ppf]);
                        fcount4++;
                    }
                }
                if ((pp[ppf].getAge() > 50) && (pp[ppf].getAge() < 90) && ("M".equals(pp[ppf].getGender()))) {
                    if (fcount5 < 1) {
                        f.getPersons().add(pp[ppf]);
                        fcount5++;
                    }
                }
            }
            fcount1 = 0;
            fcount2 = 0;
            fcount3 = 0;
            fcount4 = 0;
            fcount5 = 0;

        }

        //set 100 houses
        House[] hh = new House[100];
        for (i = 0; i < 100; i++) {
            House[] h = new House[100];
            h[i] = new House();
            int r_hNum = (int) (Math.random() * 99 + 1);
            h[i].setHouseNumber(r_hNum);
            hh[i] = h[i];
            houseDirectory.addHouse(hh[i]);
        }
        //set house Members    
        int h_count = 0;
        for (House hhh : houseDirectory.getHouseDirectory()) {
            int y = h_count;
            int allNumber = h_count + 2;
            for (y = h_count; y < allNumber; y++) {
                hhh.getAllFamily().add(ff[y]);
                h_count++;
            }
        }

        //set 10 communities
        Community[] cc = new Community[10];
        for (i = 1; i < 10; i++) {
            Community[] c = new Community[10];
            c[i] = new Community();
            long c_hNum = (long) (Math.random() * 10000 + 1);
            c[i].setCommunityNumber(c_hNum);
            cc[i] = c[i];
            communityDirectory.addCommunity(cc[i]);

        }
        //community set houses
        int c_count = 1;
        for (Community c : communityDirectory.getCommunityDirectory()) {
            int y = c_count;
            int callNumber = c_count + 10;
            for (y = c_count; y < callNumber; y++) {
                c.getAllHouse().add(hh[y]);
                c_count++;
            }
        }

        //set 1 city
        city.setCityName("Boston");
        cityDirectory.addCity(city);
        for (int cityC = 1; cityC < 10; cityC++) {
            city.getCommunity().add(cc[cityC]);
        }
        //calculate
        if (func == 1) {
            RiskCalculator.RiskCalculator();
        }
        //city
        if (func == 2) {
            CityRiskScore cityRiskScore = new CityRiskScore(2, personDirectory, familyDirectory, communityDirectory, houseDirectory, cityDirectory);
        }
        //community
        if (func == 3) {
            CityRiskScore cityRiskScore = new CityRiskScore(3, personDirectory, familyDirectory, communityDirectory, houseDirectory, cityDirectory);
        }
        //house
        if (func == 4) {
            CityRiskScore cityRiskScore = new CityRiskScore(4, personDirectory, familyDirectory, communityDirectory, houseDirectory, cityDirectory);
        }
        //family
        if (func == 5) {
            CityRiskScore cityRiskScore = new CityRiskScore(5, personDirectory, familyDirectory, communityDirectory, houseDirectory, cityDirectory);
        }
        //person
        if (func == 6) {
            CityRiskScore cityRiskScore = new CityRiskScore(1, personDirectory, familyDirectory, communityDirectory, houseDirectory, cityDirectory);
        }

       
    }
}
