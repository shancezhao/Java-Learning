/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import java.util.Date;



/**
 *
 * @author Kaiying Zhang, Shengsi Zhao, Yi Chai
 */
public class Config {
    public static void Config(int func) throws ParseException {
        University u1 = new University("Northeastern University",1898);
        University u2 = new University("Massachusetts Institute of Technology",1861);
        University u3 = new University("University of Southern California",1880);

        College college1 = new College("Engineering");        //  instantiate College
        College college2 = new College("Business");
        College college3 = new College("Law");
        //save in CollegeDirectory
        CollegeDirectory collegeDirectory = new CollegeDirectory();
        collegeDirectory.addCollege(college1);
        collegeDirectory.addCollege(college2);
        collegeDirectory.addCollege(college3);
        
        Department dpt1_EN = new Department("Information System") ;//实例化Department
        Department dpt2_EN = new Department("Computer System") ;
        Department dpt3_EN = new Department("Engineer Management") ;
        Department dpt4_Buss = new Department("Marketing") ;
        Department dpt5_Law = new Department("Law") ;
        //save in DepartmentDirectory
        DepartmentDirectory departmentDirectory = new DepartmentDirectory();
        departmentDirectory.addDepartment(dpt1_EN);
        departmentDirectory.addDepartment(dpt2_EN);
        departmentDirectory.addDepartment(dpt3_EN);
        departmentDirectory.addDepartment(dpt4_Buss);
        departmentDirectory.addDepartment(dpt5_Law);
        
        //一个department 属于1个college
        dpt1_EN.setCollege(college1);
        dpt2_EN.setCollege(college1);
        dpt3_EN.setCollege(college1);
        dpt4_Buss.setCollege(college2);
        dpt5_Law.setCollege(college3);
        
        Classroom cr1= new Classroom("Building One",101);//实例化classroom
        Classroom cr2= new Classroom("Building One",102);
        Classroom cr3= new Classroom("Building Two",203);
        Classroom cr4= new Classroom("Building Two",204);
        Classroom cr5= new Classroom("Building Three",105);
        Classroom cr6= new Classroom("Building Three",106);

        Teacher t1= new Teacher("Zhang","Jun", "01", "Male", "6578891234", "10 Huntington Ave");//实例化老师
        Teacher t2= new Teacher("Monica","Green", "02", "Female", "6578891234", "12 Huntington Ave");
        Teacher t3= new Teacher("John","Leven", "03", "Male", "6578891234", "1 Huntington Ave");
        Teacher t4= new Teacher("Zhang2","Jun2", "04", "Female", "6578891234", "6 Washington Ave");
        Teacher t5= new Teacher("Jessica","Brown", "05", "Male", "6578891234", "67 Huntington Ave");
        Teacher t6= new Teacher("Zack","Steven", "06", "Male", "6578891234", "10 Huntington Ave");
        
        TeacherDirectory teacherDirectory = new TeacherDirectory();
        teacherDirectory.addTeacher(t1);
        teacherDirectory.addTeacher(t2);
        teacherDirectory.addTeacher(t3);
        teacherDirectory.addTeacher(t4);
        teacherDirectory.addTeacher(t5);
        teacherDirectory.addTeacher(t6);
        
        Date d1 = new Date(2016,1,10);
        Semester sm1= new Semester(2016,d1);
        Semester sm2= new Semester(2016,d1);
        Semester sm3= new Semester(2015,d1);
        Semester sm4= new Semester(2015,d1);
        
        Course c1 = new Course("AED", 5100,"Core",4);  // 实例化课程对象
        Course c2 = new Course("AED Lab", 5101,"Core",0);
        Course c3 = new Course("Algorithms",5550, "Elective",2);
        Course c4 = new Course("AI",5432, "Core",5);
        Course c5 = new Course("Engineering Project Management",5220, "Elective",4);
        
        
        Course c6 = new Course("Investment Analysis", 567,"Core",3);
        Course c7 = new Course("Accounting", 678,"Core",3);
       
        Course c8 = new Course("Law History", 788,"Elective",1);
        Course c9 = new Course("Property", 789,"Core",2);
         
            
        Seat s1= new Seat(401);//实例化Seat
        Seat s2= new Seat(402);
        Seat s3= new Seat(403);
        Seat s4= new Seat(404);
        Seat s5= new Seat(405);
        Seat s6= new Seat(406);
        Seat s7= new Seat(407);
        Seat s8= new Seat(408);
        Seat s9= new Seat(409);
        Seat s10= new Seat(410);
        Seat s11= new Seat(411);
        Seat s12= new Seat(412);
        Seat s13= new Seat(413);
        Seat s14= new Seat(414);
        Seat s15= new Seat(415);
        Seat s16= new Seat(416);
        Seat s17= new Seat(417);
        Seat s18= new Seat(418);
        Seat s19= new Seat(419);
        Seat s20= new Seat(420);
        Seat s21= new Seat(421);
        Seat s22= new Seat(422);
        Seat s23= new Seat(423);
        Seat s24= new Seat(424);
        Seat s25= new Seat(425);
        Seat s26= new Seat(426);
        Seat s27= new Seat(427);
        Seat s28= new Seat(428);
        Seat s29= new Seat(429);
        Seat s30= new Seat(420);
        Seat s31= new Seat(431);
        Seat s32= new Seat(432);
        Seat s33= new Seat(433);
        Seat s34= new Seat(434);
        Seat s35= new Seat(435);
        Seat s36= new Seat(436);
        Seat s37= new Seat(437);
        Seat s38= new Seat(438);
        Seat s39= new Seat(439);
        Seat s40= new Seat(440);
        Seat s41= new Seat(441);
        Seat s42= new Seat(442);
        Seat s43= new Seat(443);
        Seat s44= new Seat(444);
        Seat s45= new Seat(445);
        Seat s46= new Seat(446);
        Seat s47= new Seat(447);
        Seat s48= new Seat(448);
        Seat s49= new Seat(449);
        Seat s50= new Seat(450);
        Seat s51= new Seat(451);
        Seat s52= new Seat(452);
        Seat s53= new Seat(453);
        Seat s54= new Seat(454);
        Seat s55= new Seat(455);
        Seat s56= new Seat(456);
        Seat s57= new Seat(457);
        Seat s58= new Seat(458);
        Seat s59= new Seat(459);
        Seat s60= new Seat(460);

        Student a1 = new Student("Kaiying","zhang",10001,1,1,"girl",671233333,"97 st stephen");//建立学生实例
        Student a2 = new Student("Shance","Zhao",10002,0,0,"girl",617233334,"96 st stephen");
        Student a3 = new Student("Yi","Chai",10003,1,1,"boy",617233335,"95 st stephen");
        Student a4 = new Student("kaiying3","zhang3",10004,1,1,"boy",617233336,"94 st stephen");
        Student a5 = new Student("kaiying4","zhang4",10005,0,0,"boy",617233337,"94 st stephen");   
        Student a6 = new Student("aiying","zhang",10006,0,1,"girl",671233333,"197 st stephen");
        Student a7 = new Student("aiying1","zhang1",10007,1,0,"boy",617233334,"196 st stephen");
        //Student a8 = new Student("aiying2","zhang2",0008,1,1,"boy",617233335,"195 st stephen","NEU","COE","IS");
        //Student a9 = new Student("aiying3","zhang3",0009,0,1,"boy",617233336,"194 st stephen","NEU","COE","IS");
        Student a10 = new Student("aiying4","zhang4",10010,1,0,"boy",617233337,"194 st stephen");
        Student a11 = new Student("aiying6","zhang4",10011,1,0,"boy",617233324,"193 st stephen");
        Student a12 = new Student("john","adam",20011,1,0,"boy",617233324,"193 st stephen");
        Student a13 = new Student("Bieber","Justin",001,1,0,"boy",617233324,"193 st stephen");
        Student a14 = new Student("Kaiyin","Zhang",002,1,0,"girl",617233324,"193 st stephen");
        Student a15 = new Student("James","Smith",003,1,0,"boy",617233324,"193 st stephen");
        Student a16 = new Student("Ying","Wang",004,1,0,"girl",617233324,"193 st stephen");
        Student a17 = new Student("Yi","Chai",005,1,0,"boy",617233324,"193 st stephen");
        Student a18 = new Student("Andrew","Ralph",006,1,0,"boy",617233324,"193 st stephen");
        Student a19 = new Student("Mary","Brown",007,1,0,"girl",617233324,"193 st stephen");
        Student a20 = new Student("John","Davis",1008,1,0,"boy",617233324,"193 st stephen");
        Student a21 = new Student("Jennifer","Taylor",1009,1,0,"girl",617233324,"193 st stephen");
        Student a22 = new Student("Bill","Kein",1010,1,0,"boy",617233324,"193 st stephen");
        Student a23 = new Student("Phill","Green",1011,1,0,"girl",617233324,"193 st stephen");
        Student a24 = new Student("Dick","White",1012,1,0,"boy",617233324,"192 st stephen");
        Student a25 = new Student("Tian","He",1013,1,0,"girl",617233324,"193 st stephen");
        Student a26 = new Student("aiying1","zhang1",2014,1,0,"boy",617233324,"193 st stephen");
        Student a27 = new Student("aiying2","zhang2",2015,1,0,"girl",617233324,"193 st stephen");
        Student a28 = new Student("aiying3","zhang3",2016,1,0,"boy",617233324,"193 st stephen");
        Student a29 = new Student("aiying4","zhang4",2017,1,0,"girl",617233324,"193 st stephen");
        Student a30 = new Student("aiying5","zhang5",2018,1,0,"boy",617233324,"193 st stephen");
        Student a31 = new Student("aiying6","zhang6",2019,1,0,"girl",617233324,"193 st stephen");
        Student a32 = new Student("aiying7","zhang4]7",2020,1,0,"boy",617233324,"193 st stephen");
        Student a33 = new Student("aiying8","zhang8",3021,1,0,"girl",617233324,"193 st stephen");
        Student a34 = new Student("aiying9","zhang9",3022,1,0,"boy",617233324,"193 st stephen");
        Student a35 = new Student("aiying10","zhang10",023,1,0,"girl",617233324,"193 st stephen");
        Student a36 = new Student("aiying11","zhang11",024,1,0,"boy",617233324,"193 st stephen");
        Student a37 = new Student("aiying12","zhang12",025,1,0,"girl",617233324,"193 st stephen");
        Student a38 = new Student("aiying13","zhang13",026,1,0,"boy",617233324,"193 st stephen");
        Student a39 = new Student("aiying14","zhang14",027,1,0,"girl",617233324,"193 st stephen");
        Student a40 = new Student("aiying15","zhang15",3028,1,0,"boy",617233324,"193 st stephen");
        Student a41 = new Student("Lisa","Anderson",3029,1,0,"girl",617233324,"193 st stephen");
        Student a42 = new Student("Jimmy","Martin",3030,1,0,"boy",617233324,"193 st stephen");
        Student a43 = new Student("Linda","Jackson",031,1,0,"girl",617233324,"193 st stephen");
        Student a44 = new Student("Nicholas","Wilson",032,1,0,"boy",617233324,"193 st stephen");
        Student a45 = new Student("Barbara","AAAAA",3033,1,1,"girl",617233324,"193 st stephen");
        Student a46 = new Student("aiying16","zhang16",034,1,1,"boy",617233324,"193 st stephen");
        Student a47 = new Student("aiying17","zhang17",035,1,1,"girl",617233324,"193 st stephen");
        Student a48 = new Student("aiying18","zhang18",036,1,1,"boy",617233324,"193 st stephen");
        Student a49 = new Student("aiying19","zhang19",037,1,1,"girl",617233324,"193 st stephen");
        Student a50 = new Student("aiying20","zhang20",3038,1,1,"boy",617233324,"193 st stephen");
        Student a51 = new Student("aiying21","zhang21",3039,1,0,"girl",617233324,"193 st stephen");
        Student a52 = new Student("aiying22","zhang22",4040,1,0,"boy",617233324,"193 st stephen");
        Student a53 = new Student("aiying23","zhang23",4041,1,0,"girl",617233324,"193 st stephen");
        Student a54 = new Student("aiying24","zhang24",4042,1,0,"boy",617233324,"193 st stephen");
        Student a55 = new Student("aiying25","zhang25",4043,1,0,"girl",617233324,"193 st stephen");
        Student a56 = new Student("aiying26","zhang26",4044,1,0,"boy",617233324,"193 st stephen");
        Student a57 = new Student("aiying27","zhang27",4045,1,0,"girl",617233324,"193 st stephen");
        Student a58 = new Student("aiying29","zhang29",4046,1,0,"boy",617233324,"193 st stephen");
        Student a59 = new Student("aiying30","zhang30",4047,1,0,"girl",617233324,"193 st stephen");
        Student a60 = new Student("Nancy","Scott",4048,1,1,"boy",617233324,"190 st stephen");
        Student a61 = new Student("Albert","Young",4049,1,1,"girl",617233324,"193 st stephen");
        Student a62 = new Student("Donna","Hall",5050,1,1,"boy",617233324,"193 st stephen");
        Student a63 = new Student("Jacob","King",5051,1,1,"girl",617233324,"193 st stephen");
        Student a64 = new Student("Laura","Wrigth",5052,1,1,"boy",617233324,"193 st stephen");
        Student a65 = new Student("Corey","Adam",5053,1,1,"girl",617233324,"193 st stephen");
        Student a66 = new Student("Susan","Miller",5054,1,1,"boy",617233324,"193 st stephen");
        Student a67 = new Student("Michael","Wilson",5055,1,1,"girl",617233324,"193 st stephen");
        Student a68 = new Student("Karen","Thompson",5056,1,1,"boy",617233324,"193 st stephen");
        Student a69 = new Student("Elizabeth","Lee",5057,1,1,"girl",617233324,"193 st stephen");
        Student a70 = new Student("aiying31","zhang31",5058,1,1,"boy",617233324,"193 st stephen");
        Student a71 = new Student("aiying32","zhang32",5059,1,0,"girl",617233324,"193 st stephen");
        Student a72 = new Student("aiying33","zhang33",6060,1,0,"boy",617233324,"193 st stephen");
        Student a73 = new Student("aiying34","zhang34",6061,1,0,"girl",617233324,"193 st stephen");
        Student a74 = new Student("aiying35","zhang35",6062,1,0,"boy",617233324,"193 st stephen");
        Student a75 = new Student("aiying36","zhang36",6063,1,0,"girl",617233324,"193 st stephen");
        Student a76 = new Student("aiying37","zhang38",6064,1,0,"boy",617233324,"193 st stephen");
        Student a77 = new Student("aiying39","zhang39",6065,1,0,"girl",617233324,"193 st stephen");
        Student a78 = new Student("aiying40","zhang40",6066,1,0,"boy",617233324,"193 st stephen");
        Student a79 = new Student("aiying41","zhang41",6067,1,0,"girl",617233324,"193 st stephen");
        Student a80 = new Student("aiying42","zhang42",6068,1,0,"boy",617233324,"193 st stephen");
        Student a81 = new Student("aiying43","zhang43",6069,1,0,"girl",617233324,"193 st stephen");
        Student a82 = new Student("aiying44","zhang44",7070,1,0,"boy",617233324,"193 st stephen");
        Student a83 = new Student("aiying45","zhang45",7071,1,0,"girl",617233324,"193 st stephen");
        Student a84 = new Student("aiying46","zhang46",7072,1,0,"boy",617233324,"193 st stephen");
        Student a85 = new Student("aiying47","zhang47",7073,1,0,"girl",617233324,"193 st stephen");
        Student a86 = new Student("aiying48","zhang48",7074,1,0,"boy",617233324,"193 st stephen");
        Student a87 = new Student("aiying49","zhang49",7075,1,0,"girl",617233324,"175 st stephen");
        Student a88 = new Student("aiying50","zhang50",7076,1,0,"boy",617233324,"193 st stephen");
        Student a89 = new Student("aiying51","zhang51",7077,1,0,"girl",617233324,"193 st stephen");
        Student a90 = new Student("aiying52","zhang52",7078,1,0,"boy",617233324,"193 st stephen");
        Student a91 = new Student("aiying53","zhang53",7079,1,0,"girl",617233324,"173 st stephen");
        Student a92 = new Student("aiying54","zhang54",8080,1,0,"boy",617233324,"193 st stephen");
        Student a93 = new Student("aiying55","zhang55",8081,1,1,"girl",617233324,"193 st stephen");
        Student a94 = new Student("aiying56","zhang56",8082,1,1,"boy",617233324,"193 st stephen");
        Student a95 = new Student("aiying57","zhang57",8083,1,1,"girl",617233324,"193 st stephen");
        Student a96 = new Student("aiying58","zhang58",8084,1,1,"boy",617233324,"193 st stephen");
        Student a97 = new Student("aiying59","zhang59",8085,1,1,"girl",617233324,"193 st stephen");
        Student a98 = new Student("aiying60","zhang60",8086,1,1,"boy",617233324,"189 st stephen");
        Student a99 = new Student("aiying61","zhang61",8087,1,1,"girl",617233324,"193 st stephen");

         StudentDirectory studentDirectory = new StudentDirectory();//将学生加入Directory
        studentDirectory.addStudent(a1);
        studentDirectory.addStudent(a2);
        studentDirectory.addStudent(a3);
        studentDirectory.addStudent(a4);
        studentDirectory.addStudent(a5);
        studentDirectory.addStudent(a6);
        studentDirectory.addStudent(a7);
        studentDirectory.addStudent(a10);
        studentDirectory.addStudent(a11);
        studentDirectory.addStudent(a12);
        studentDirectory.addStudent(a13);
        studentDirectory.addStudent(a14);
        studentDirectory.addStudent(a15);
        studentDirectory.addStudent(a16);
        studentDirectory.addStudent(a17);
        studentDirectory.addStudent(a18);
        studentDirectory.addStudent(a19);
        studentDirectory.addStudent(a20);
        studentDirectory.addStudent(a21);
        studentDirectory.addStudent(a22);
        studentDirectory.addStudent(a23);
        studentDirectory.addStudent(a24);
        studentDirectory.addStudent(a25);
        studentDirectory.addStudent(a26);
        studentDirectory.addStudent(a27);
        studentDirectory.addStudent(a28);
        studentDirectory.addStudent(a29);
        studentDirectory.addStudent(a30);
        studentDirectory.addStudent(a31);
        studentDirectory.addStudent(a32);
        studentDirectory.addStudent(a33);
        studentDirectory.addStudent(a34);
        studentDirectory.addStudent(a35);
        studentDirectory.addStudent(a36);
        studentDirectory.addStudent(a37);
        studentDirectory.addStudent(a38);
        studentDirectory.addStudent(a39);
        studentDirectory.addStudent(a40);
        studentDirectory.addStudent(a41);
        studentDirectory.addStudent(a42);
        studentDirectory.addStudent(a43);
        studentDirectory.addStudent(a44);
        studentDirectory.addStudent(a45);
        studentDirectory.addStudent(a46);
        studentDirectory.addStudent(a47);
        studentDirectory.addStudent(a48);
        studentDirectory.addStudent(a49);
        studentDirectory.addStudent(a50);
        studentDirectory.addStudent(a51);
        studentDirectory.addStudent(a52);
        studentDirectory.addStudent(a53);
        studentDirectory.addStudent(a54);
        studentDirectory.addStudent(a55);
        studentDirectory.addStudent(a56);
        studentDirectory.addStudent(a57);
        studentDirectory.addStudent(a58);
        studentDirectory.addStudent(a59);
        studentDirectory.addStudent(a60);
        studentDirectory.addStudent(a61);
        studentDirectory.addStudent(a62);
        studentDirectory.addStudent(a63);
        studentDirectory.addStudent(a64);
        studentDirectory.addStudent(a65);
        studentDirectory.addStudent(a66);
        studentDirectory.addStudent(a67);
        studentDirectory.addStudent(a68);
        studentDirectory.addStudent(a69);
        studentDirectory.addStudent(a70);
        studentDirectory.addStudent(a71);
        studentDirectory.addStudent(a72);
        studentDirectory.addStudent(a73);
        studentDirectory.addStudent(a74);
        studentDirectory.addStudent(a75);
        studentDirectory.addStudent(a76);
        studentDirectory.addStudent(a77);
        studentDirectory.addStudent(a78);
        studentDirectory.addStudent(a79);
        studentDirectory.addStudent(a80);
        studentDirectory.addStudent(a81);
        studentDirectory.addStudent(a82);
        studentDirectory.addStudent(a83);
        studentDirectory.addStudent(a84);
        studentDirectory.addStudent(a85);
        studentDirectory.addStudent(a86);
        studentDirectory.addStudent(a87);
        studentDirectory.addStudent(a88);
        studentDirectory.addStudent(a89);
        studentDirectory.addStudent(a90);
        studentDirectory.addStudent(a91);
        studentDirectory.addStudent(a92);
        studentDirectory.addStudent(a93);
        studentDirectory.addStudent(a94);
        studentDirectory.addStudent(a95);
        studentDirectory.addStudent(a96);
        studentDirectory.addStudent(a97);
        studentDirectory.addStudent(a98);
        studentDirectory.addStudent(a99);

        //university加入college
        u1.getColleges().add(college1);
        u1.getColleges().add(college2);
        u1.getColleges().add(college3);
        u2.getColleges().add(college1);
        u2.getColleges().add(college2);
        u2.getColleges().add(college3);
        u3.getColleges().add(college1);
        u3.getColleges().add(college2);
        u3.getColleges().add(college3);
        
        
        int abb=1;
        
        for(Student ua:studentDirectory.getStudentDirectory())
        {
            abb++;
            if(abb<40){u1.getStudents().add(ua);}
            if((40<=abb)&&(abb<80)){u2.getStudents().add(ua);}
            if(abb>=80){u3.getStudents().add(ua);}
        }
        
       
        
        //add department in college
        college1.getDepartments().add(dpt1_EN);
        college1.getDepartments().add(dpt2_EN);
        college1.getDepartments().add(dpt3_EN);
        college2.getDepartments().add(dpt4_Buss);
        college3.getDepartments().add(dpt5_Law);
        
        //department导入student
        dpt1_EN.getAllStudents().addStudent(a1);//将学生列表添加到department
        dpt1_EN.getAllStudents().addStudent(a2);
        dpt1_EN.getAllStudents().addStudent(a3);
        dpt1_EN.getAllStudents().addStudent(a4);
        dpt1_EN.getAllStudents().addStudent(a5);
        dpt1_EN.getAllStudents().addStudent(a6);
        dpt1_EN.getAllStudents().addStudent(a7);
        dpt1_EN.getAllStudents().addStudent(a10);
        dpt1_EN.getAllStudents().addStudent(a11);
        dpt1_EN.getAllStudents().addStudent(a12);
        dpt1_EN.getAllStudents().addStudent(a13);
        dpt1_EN.getAllStudents().addStudent(a14);
        dpt1_EN.getAllStudents().addStudent(a15);
        dpt1_EN.getAllStudents().addStudent(a16);
        dpt1_EN.getAllStudents().addStudent(a17);
        dpt1_EN.getAllStudents().addStudent(a18);
        dpt1_EN.getAllStudents().addStudent(a19);
        dpt2_EN.getAllStudents().addStudent(a20);
        dpt2_EN.getAllStudents().addStudent(a21);
        dpt2_EN.getAllStudents().addStudent(a22);
        dpt2_EN.getAllStudents().addStudent(a23);
        dpt2_EN.getAllStudents().addStudent(a24);
        dpt2_EN.getAllStudents().addStudent(a25);
        dpt2_EN.getAllStudents().addStudent(a26);
        dpt2_EN.getAllStudents().addStudent(a27);
        dpt2_EN.getAllStudents().addStudent(a28);
        dpt2_EN.getAllStudents().addStudent(a29);
        dpt2_EN.getAllStudents().addStudent(a30);
        dpt2_EN.getAllStudents().addStudent(a31);
        dpt2_EN.getAllStudents().addStudent(a32);
        dpt2_EN.getAllStudents().addStudent(a33);
        dpt2_EN.getAllStudents().addStudent(a34);
        dpt2_EN.getAllStudents().addStudent(a35);
        dpt2_EN.getAllStudents().addStudent(a36);
        dpt2_EN.getAllStudents().addStudent(a37);
        dpt2_EN.getAllStudents().addStudent(a38);
        dpt2_EN.getAllStudents().addStudent(a39);
        dpt2_EN.getAllStudents().addStudent(a40);
        dpt3_EN.getAllStudents().addStudent(a41);
        dpt3_EN.getAllStudents().addStudent(a42);
        dpt3_EN.getAllStudents().addStudent(a43);
        dpt3_EN.getAllStudents().addStudent(a44);
        dpt3_EN.getAllStudents().addStudent(a45);
        dpt3_EN.getAllStudents().addStudent(a46);
        dpt3_EN.getAllStudents().addStudent(a47);
        dpt3_EN.getAllStudents().addStudent(a48);
        dpt3_EN.getAllStudents().addStudent(a49);
        dpt3_EN.getAllStudents().addStudent(a50);
        dpt3_EN.getAllStudents().addStudent(a51);
        dpt3_EN.getAllStudents().addStudent(a52);
        dpt3_EN.getAllStudents().addStudent(a53);
        dpt3_EN.getAllStudents().addStudent(a54);
        dpt3_EN.getAllStudents().addStudent(a55);
        dpt3_EN.getAllStudents().addStudent(a56);
        dpt3_EN.getAllStudents().addStudent(a57);
        dpt3_EN.getAllStudents().addStudent(a58);
        dpt3_EN.getAllStudents().addStudent(a59);
        dpt3_EN.getAllStudents().addStudent(a60);
        dpt3_EN.getAllStudents().addStudent(a61);
        dpt3_EN.getAllStudents().addStudent(a62);
        dpt3_EN.getAllStudents().addStudent(a63);
        dpt3_EN.getAllStudents().addStudent(a64);
        dpt3_EN.getAllStudents().addStudent(a65);
        dpt4_Buss.getAllStudents().addStudent(a66);
        dpt4_Buss.getAllStudents().addStudent(a67);
        dpt4_Buss.getAllStudents().addStudent(a68);
        dpt4_Buss.getAllStudents().addStudent(a69);
        dpt4_Buss.getAllStudents().addStudent(a70);
        dpt4_Buss.getAllStudents().addStudent(a71);
        dpt4_Buss.getAllStudents().addStudent(a72);
        dpt4_Buss.getAllStudents().addStudent(a73);
        dpt4_Buss.getAllStudents().addStudent(a74);
        dpt4_Buss.getAllStudents().addStudent(a75);
        dpt4_Buss.getAllStudents().addStudent(a76);
        dpt4_Buss.getAllStudents().addStudent(a77);
        dpt4_Buss.getAllStudents().addStudent(a78);
        dpt4_Buss.getAllStudents().addStudent(a79);
        dpt4_Buss.getAllStudents().addStudent(a80);
        dpt5_Law.getAllStudents().addStudent(a81);
        dpt5_Law.getAllStudents().addStudent(a82);
        dpt5_Law.getAllStudents().addStudent(a83);
        dpt5_Law.getAllStudents().addStudent(a84);
        dpt5_Law.getAllStudents().addStudent(a85);
        dpt5_Law.getAllStudents().addStudent(a86);
        dpt5_Law.getAllStudents().addStudent(a87);
        dpt5_Law.getAllStudents().addStudent(a88);
        dpt5_Law.getAllStudents().addStudent(a89);
        dpt5_Law.getAllStudents().addStudent(a90);
        dpt5_Law.getAllStudents().addStudent(a91);
        dpt5_Law.getAllStudents().addStudent(a92);
        dpt5_Law.getAllStudents().addStudent(a93);
        dpt5_Law.getAllStudents().addStudent(a94);
        dpt5_Law.getAllStudents().addStudent(a95);
        dpt5_Law.getAllStudents().addStudent(a96);
        dpt5_Law.getAllStudents().addStudent(a97);
        dpt5_Law.getAllStudents().addStudent(a98);
        dpt5_Law.getAllStudents().addStudent(a99);
        
        //one student must only join in one department
        a1.setDepartment(dpt1_EN);
        a2.setDepartment(dpt1_EN);
        a3.setDepartment(dpt1_EN);
        a4.setDepartment(dpt1_EN);
        a5.setDepartment(dpt1_EN);
        a6.setDepartment(dpt1_EN);
        a7.setDepartment(dpt1_EN);
        a10.setDepartment(dpt1_EN);
        a11.setDepartment(dpt1_EN);
        a12.setDepartment(dpt1_EN);
        a13.setDepartment(dpt1_EN);
        a14.setDepartment(dpt1_EN);
        a15.setDepartment(dpt1_EN);
        a16.setDepartment(dpt1_EN);
        a17.setDepartment(dpt1_EN);
        a18.setDepartment(dpt1_EN);
        a19.setDepartment(dpt1_EN);
        a20.setDepartment(dpt1_EN);
        a21.setDepartment(dpt2_EN);
        a22.setDepartment(dpt2_EN);
        a23.setDepartment(dpt2_EN);
        a24.setDepartment(dpt2_EN);
        a25.setDepartment(dpt2_EN);
        a26.setDepartment(dpt2_EN);
        a27.setDepartment(dpt2_EN);
        a28.setDepartment(dpt2_EN);
        a29.setDepartment(dpt2_EN);
        a30.setDepartment(dpt2_EN);
        a31.setDepartment(dpt2_EN);
        a32.setDepartment(dpt2_EN);
        a33.setDepartment(dpt2_EN);
        a34.setDepartment(dpt2_EN);
        a35.setDepartment(dpt2_EN);
        a36.setDepartment(dpt2_EN);
        a37.setDepartment(dpt2_EN);
        a38.setDepartment(dpt2_EN);
        a39.setDepartment(dpt2_EN);
        a40.setDepartment(dpt2_EN);
        a41.setDepartment(dpt3_EN);
        a42.setDepartment(dpt3_EN);
        a43.setDepartment(dpt3_EN);
        a44.setDepartment(dpt3_EN);
        a45.setDepartment(dpt3_EN);
        a46.setDepartment(dpt3_EN);
        a47.setDepartment(dpt3_EN);
        a48.setDepartment(dpt3_EN);
        a49.setDepartment(dpt3_EN);
        a50.setDepartment(dpt3_EN);
        a51.setDepartment(dpt3_EN);
        a52.setDepartment(dpt3_EN);
        a53.setDepartment(dpt3_EN);
        a54.setDepartment(dpt3_EN);
        a55.setDepartment(dpt3_EN);
        a56.setDepartment(dpt3_EN);
        a57.setDepartment(dpt3_EN);
        a58.setDepartment(dpt3_EN);
        a59.setDepartment(dpt3_EN);
        a60.setDepartment(dpt3_EN);
        a61.setDepartment(dpt4_Buss);
        a62.setDepartment(dpt4_Buss);
        a63.setDepartment(dpt4_Buss);
        a64.setDepartment(dpt4_Buss);
        a65.setDepartment(dpt4_Buss);
        a66.setDepartment(dpt4_Buss);
        a67.setDepartment(dpt4_Buss);
        a68.setDepartment(dpt4_Buss);
        a69.setDepartment(dpt4_Buss);
        a70.setDepartment(dpt4_Buss);
        a71.setDepartment(dpt4_Buss);
        a72.setDepartment(dpt4_Buss);
        a73.setDepartment(dpt4_Buss);
        a74.setDepartment(dpt4_Buss);
        a75.setDepartment(dpt4_Buss);
        a76.setDepartment(dpt4_Buss);
        a77.setDepartment(dpt4_Buss);
        a78.setDepartment(dpt4_Buss);
        a79.setDepartment(dpt4_Buss);
        a80.setDepartment(dpt4_Buss);
        a81.setDepartment(dpt5_Law);
        a82.setDepartment(dpt5_Law);
        a83.setDepartment(dpt5_Law);
        a84.setDepartment(dpt5_Law);
        a85.setDepartment(dpt5_Law);
        a86.setDepartment(dpt5_Law);
        a87.setDepartment(dpt5_Law);
        a88.setDepartment(dpt5_Law);
        a89.setDepartment(dpt5_Law);
        a90.setDepartment(dpt5_Law);
        a91.setDepartment(dpt5_Law);
        a92.setDepartment(dpt5_Law);
        a93.setDepartment(dpt5_Law);
        a94.setDepartment(dpt5_Law);
        a95.setDepartment(dpt5_Law);
        a96.setDepartment(dpt5_Law);
        a97.setDepartment(dpt5_Law);
        a98.setDepartment(dpt5_Law);
        a99.setDepartment(dpt5_Law);
        
    //student set university
        a1.setUniversity(u1);
        a2.setUniversity(u1);
        a3.setUniversity(u1);
        a4.setUniversity(u1);
        a5.setUniversity(u1);
        a6.setUniversity(u1);
        a7.setUniversity(u1);
        a10.setUniversity(u1);
        a11.setUniversity(u1);
        a12.setUniversity(u1);
        a13.setUniversity(u1);
        a14.setUniversity(u1);
        a15.setUniversity(u1);
        a16.setUniversity(u1);
        a17.setUniversity(u1);
        a18.setUniversity(u1);
        a19.setUniversity(u1);
        a20.setUniversity(u1);
        a21.setUniversity(u1);
        a22.setUniversity(u1);
        a23.setUniversity(u1);
        a24.setUniversity(u1);
        a25.setUniversity(u1);
        a26.setUniversity(u1);
        a27.setUniversity(u1);
        a28.setUniversity(u1);
        a29.setUniversity(u1);
        a30.setUniversity(u1);
        a31.setUniversity(u2);
        a32.setUniversity(u2);
        a33.setUniversity(u2);
        a34.setUniversity(u2);
        a35.setUniversity(u2);
        a36.setUniversity(u2);
        a37.setUniversity(u2);
        a38.setUniversity(u2);
        a39.setUniversity(u2);
        a40.setUniversity(u2);
        a41.setUniversity(u2);
        a42.setUniversity(u2);
        a43.setUniversity(u2);
        a44.setUniversity(u2);
        a45.setUniversity(u2);
        a46.setUniversity(u2);
        a47.setUniversity(u2);
        a48.setUniversity(u2);
        a49.setUniversity(u2);
        a50.setUniversity(u2);
        a51.setUniversity(u2);
        a52.setUniversity(u2);
        a53.setUniversity(u2);
        a54.setUniversity(u2);
        a55.setUniversity(u2);
        a56.setUniversity(u2);
        a57.setUniversity(u2);
        a58.setUniversity(u2);
        a59.setUniversity(u2);
        a60.setUniversity(u2);
        a61.setUniversity(u3);
        a62.setUniversity(u3);
        a63.setUniversity(u3);
        a64.setUniversity(u3);
        a65.setUniversity(u3);
        a66.setUniversity(u3);
        a67.setUniversity(u3);
        a68.setUniversity(u3);
        a69.setUniversity(u3);
        a70.setUniversity(u3);
        a71.setUniversity(u3);
        a72.setUniversity(u3);
        a73.setUniversity(u3);
        a74.setUniversity(u3);
        a75.setUniversity(u3);
        a76.setUniversity(u3);
        a77.setUniversity(u3);
        a78.setUniversity(u3);
        a79.setUniversity(u3);
        a80.setUniversity(u3);
        a81.setUniversity(u3);
        a82.setUniversity(u3);
        a83.setUniversity(u3);
        a84.setUniversity(u3);
        a85.setUniversity(u3);
        a86.setUniversity(u3);
        a87.setUniversity(u3);
        a88.setUniversity(u3);
        a89.setUniversity(u3);
        a90.setUniversity(u3);
        a91.setUniversity(u3);
        a92.setUniversity(u3);
        a93.setUniversity(u2);
        a94.setUniversity(u1);
        a95.setUniversity(u2);
        a96.setUniversity(u1);
        a97.setUniversity(u3);
        a98.setUniversity(u1);
        a99.setUniversity(u3);
        
        //student set college
        a1.setCollege(college1);
        a2.setCollege(college1);
        a3.setCollege(college1);
        a4.setCollege(college1);
        a5.setCollege(college1);
        a6.setCollege(college1);
        a7.setCollege(college1);
        a10.setCollege(college1);
        a11.setCollege(college1);
        a12.setCollege(college1);
        a13.setCollege(college1);
        a14.setCollege(college1);
        a15.setCollege(college1);
        a16.setCollege(college1);
        a17.setCollege(college1);
        a18.setCollege(college1);
        a19.setCollege(college1);
        a20.setCollege(college1);
        a21.setCollege(college1);
        a22.setCollege(college1);
        a23.setCollege(college1);
        a24.setCollege(college1);
        a25.setCollege(college1);
        a26.setCollege(college1);
        a27.setCollege(college1);
        a28.setCollege(college1);
        a29.setCollege(college1);
        a30.setCollege(college1);
        a31.setCollege(college1);
        a32.setCollege(college1);
        a33.setCollege(college1);
        a34.setCollege(college1);
        a35.setCollege(college1);
        a36.setCollege(college1);
        a37.setCollege(college1);
        a38.setCollege(college1);
        a39.setCollege(college1);
        a40.setCollege(college1);
        a41.setCollege(college1);
        a42.setCollege(college1);
        a43.setCollege(college1);
        a44.setCollege(college1);
        a45.setCollege(college1);
        a46.setCollege(college1);
        a47.setCollege(college1);
        a48.setCollege(college1);
        a49.setCollege(college1);
        a50.setCollege(college1);
        a51.setCollege(college1);
        a52.setCollege(college1);
        a53.setCollege(college1);
        a54.setCollege(college1);
        a55.setCollege(college1);
        a56.setCollege(college1);
        a57.setCollege(college1);
        a58.setCollege(college1);
        a59.setCollege(college1);
        a60.setCollege(college1);
        a61.setCollege(college2);
        a62.setCollege(college2);
        a63.setCollege(college2);
        a64.setCollege(college2);
        a65.setCollege(college2);
        a66.setCollege(college2);
        a67.setCollege(college2);
        a68.setCollege(college2);
        a69.setCollege(college2);
        a70.setCollege(college2);
        a71.setCollege(college2);
        a72.setCollege(college2);
        a73.setCollege(college2);
        a74.setCollege(college2);
        a75.setCollege(college2);
        a76.setCollege(college2);
        a77.setCollege(college2);
        a78.setCollege(college2);
        a79.setCollege(college2);
        a80.setCollege(college2);
        a81.setCollege(college3);
        a82.setCollege(college3);
        a83.setCollege(college3);
        a84.setCollege(college3);
        a85.setCollege(college3);
        a86.setCollege(college3);
        a87.setCollege(college3);
        a88.setCollege(college3);
        a89.setCollege(college3);
        a90.setCollege(college3);
        a91.setCollege(college3);
        a92.setCollege(college3);
        a93.setCollege(college3);
        a94.setCollege(college3);
        a95.setCollege(college3);
        a96.setCollege(college3);
        a97.setCollege(college3);
        a98.setCollege(college3);
        a99.setCollege(college3);
        
        //Department导入Course
        dpt1_EN.getAllcourses().add(c1);
        dpt1_EN.getAllcourses().add(c2);
        dpt2_EN.getAllcourses().add(c3);
        dpt2_EN.getAllcourses().add(c4);
        dpt3_EN.getAllcourses().add(c5);
        dpt4_Buss.getAllcourses().add(c6);
        dpt4_Buss.getAllcourses().add(c7);
        dpt5_Law.getAllcourses().add(c8);
        dpt5_Law.getAllcourses().add(c9);
        //course设置Department
        c1.setDepartment(dpt1_EN);
        c2.setDepartment(dpt1_EN);
        c3.setDepartment(dpt2_EN);
        c4.setDepartment(dpt2_EN);
        c5.setDepartment(dpt3_EN);
        c6.setDepartment(dpt4_Buss);
        c7.setDepartment(dpt4_Buss);
        c8.setDepartment(dpt5_Law);
        c9.setDepartment(dpt5_Law);
        
        //不同Course有不同classroom
        c1.setClassroom(cr1);
        c2.setClassroom(cr2);
        c3.setClassroom(cr3);
        c4.setClassroom(cr4);
        c5.setClassroom(cr5);
        c6.setClassroom(cr6);
        c7.setClassroom(cr1);
        c8.setClassroom(cr6);
        c9.setClassroom(cr6);
        
        //course有teacher
        c1.setTeacher(t1);
        c2.setTeacher(t1);
        c3.setTeacher(t2);
        c4.setTeacher(t3);
        c5.setTeacher(t4);
        c6.setTeacher(t5);
        c7.setTeacher(t6);
        c8.setTeacher(t6);
        c9.setTeacher(t6);
        
       t1.getAllCourse().add(c1);
       t1.getAllCourse().add(c2);
       t2.getAllCourse().add(c3);
       t3.getAllCourse().add(c4);
       t4.getAllCourse().add(c5);
       t5.getAllCourse().add(c6);
       t6.getAllCourse().add(c7);
       t6.getAllCourse().add(c8);
       t6.getAllCourse().add(c9);
        
        cr1.getAllSeat().add(s1);//把座位分配到教室
        cr1.getAllSeat().add(s2);
        cr1.getAllSeat().add(s3);
        cr1.getAllSeat().add(s4);
        cr1.getAllSeat().add(s5);
        cr1.getAllSeat().add(s6);
        cr1.getAllSeat().add(s7);
        cr1.getAllSeat().add(s8);
        cr1.getAllSeat().add(s9);
        cr1.getAllSeat().add(s10);
        cr2.getAllSeat().add(s11);
        cr2.getAllSeat().add(s12);
        cr2.getAllSeat().add(s13);
        cr2.getAllSeat().add(s14);
        cr2.getAllSeat().add(s15);
        cr2.getAllSeat().add(s16);
        cr2.getAllSeat().add(s17);
        cr2.getAllSeat().add(s18);
        cr2.getAllSeat().add(s19);
        cr2.getAllSeat().add(s20);
        cr3.getAllSeat().add(s21);
        cr3.getAllSeat().add(s22);
        cr3.getAllSeat().add(s23);
        cr3.getAllSeat().add(s24);
        cr3.getAllSeat().add(s25);
        cr3.getAllSeat().add(s26);
        cr3.getAllSeat().add(s27);
        cr3.getAllSeat().add(s28);
        cr3.getAllSeat().add(s29);
        cr3.getAllSeat().add(s30);
        cr4.getAllSeat().add(s31);
        cr4.getAllSeat().add(s32);
        cr4.getAllSeat().add(s33);
        cr4.getAllSeat().add(s34);
        cr4.getAllSeat().add(s35);
        cr4.getAllSeat().add(s36);
        cr4.getAllSeat().add(s37);
        cr4.getAllSeat().add(s38);
        cr4.getAllSeat().add(s39);
        cr4.getAllSeat().add(s40);
        cr5.getAllSeat().add(s41);
        cr5.getAllSeat().add(s42);
        cr5.getAllSeat().add(s43);
        cr5.getAllSeat().add(s44);
        cr5.getAllSeat().add(s45);
        cr5.getAllSeat().add(s46);
        cr5.getAllSeat().add(s47);
        cr5.getAllSeat().add(s48);
        cr5.getAllSeat().add(s49);
        cr5.getAllSeat().add(s50);
        cr6.getAllSeat().add(s51);
        cr6.getAllSeat().add(s52);
        cr6.getAllSeat().add(s53);
        cr6.getAllSeat().add(s54);
        cr6.getAllSeat().add(s55);
        cr6.getAllSeat().add(s56);
        cr6.getAllSeat().add(s57);
        cr6.getAllSeat().add(s58);
        cr6.getAllSeat().add(s59);
        cr6.getAllSeat().add(s60);

        
        //将学生列表导入课程 
        c1.getAllStudents().addStudent(a41);
        c1.getAllStudents().addStudent(a42);
        c1.getAllStudents().addStudent(a43);
        c1.getAllStudents().addStudent(a44);
        c1.getAllStudents().addStudent(a45);
        c1.getAllStudents().addStudent(a46);
        c1.getAllStudents().addStudent(a47);
        c1.getAllStudents().addStudent(a48);
        c1.getAllStudents().addStudent(a49);
        c1.getAllStudents().addStudent(a50);
        c1.getAllStudents().addStudent(a51);
        c1.getAllStudents().addStudent(a52);
        c1.getAllStudents().addStudent(a53);
        c1.getAllStudents().addStudent(a54);
        c1.getAllStudents().addStudent(a55);
        c1.getAllStudents().addStudent(a56);
        c1.getAllStudents().addStudent(a57);
        c1.getAllStudents().addStudent(a58);
        c1.getAllStudents().addStudent(a59);
        c1.getAllStudents().addStudent(a60);
        c2.getAllStudents().addStudent(a1);
        c2.getAllStudents().addStudent(a2);
        c2.getAllStudents().addStudent(a3);
        c2.getAllStudents().addStudent(a4);
        c2.getAllStudents().addStudent(a5);
        c2.getAllStudents().addStudent(a6);
        c2.getAllStudents().addStudent(a7);
        c2.getAllStudents().addStudent(a10);
        c2.getAllStudents().addStudent(a11);
        c2.getAllStudents().addStudent(a12);
        c2.getAllStudents().addStudent(a13);
        c2.getAllStudents().addStudent(a14);
        c2.getAllStudents().addStudent(a15);
        c2.getAllStudents().addStudent(a16);
        c2.getAllStudents().addStudent(a17);
        c2.getAllStudents().addStudent(a18);
        c2.getAllStudents().addStudent(a19);
        c2.getAllStudents().addStudent(a20);
        c3.getAllStudents().addStudent(a1);
        c3.getAllStudents().addStudent(a2);
        c3.getAllStudents().addStudent(a3);
        c3.getAllStudents().addStudent(a4);
        c3.getAllStudents().addStudent(a5);
        c3.getAllStudents().addStudent(a6);
        c3.getAllStudents().addStudent(a7);
        c3.getAllStudents().addStudent(a10);
        c3.getAllStudents().addStudent(a11);
        c3.getAllStudents().addStudent(a12);
        c3.getAllStudents().addStudent(a13);
        c3.getAllStudents().addStudent(a14);
        c3.getAllStudents().addStudent(a15);
        c3.getAllStudents().addStudent(a16);
        c3.getAllStudents().addStudent(a17);
        c3.getAllStudents().addStudent(a18);
        c3.getAllStudents().addStudent(a19);
        c3.getAllStudents().addStudent(a20);
        c3.getAllStudents().addStudent(a21);
        c3.getAllStudents().addStudent(a22);
        c3.getAllStudents().addStudent(a23);
        c3.getAllStudents().addStudent(a24);
        c3.getAllStudents().addStudent(a25);
        c3.getAllStudents().addStudent(a26);
        c3.getAllStudents().addStudent(a27);
        c3.getAllStudents().addStudent(a28);
        c3.getAllStudents().addStudent(a29);
        c3.getAllStudents().addStudent(a30);
        c3.getAllStudents().addStudent(a31);
        c3.getAllStudents().addStudent(a32);
        c3.getAllStudents().addStudent(a33);
        c3.getAllStudents().addStudent(a34);
        c3.getAllStudents().addStudent(a35);
        c3.getAllStudents().addStudent(a36);
        c3.getAllStudents().addStudent(a37);
        c3.getAllStudents().addStudent(a38);
        c3.getAllStudents().addStudent(a39);
        c3.getAllStudents().addStudent(a40);
        c4.getAllStudents().addStudent(a21);
        c4.getAllStudents().addStudent(a22);
        c4.getAllStudents().addStudent(a23);
        c4.getAllStudents().addStudent(a24);
        c4.getAllStudents().addStudent(a25);
        c4.getAllStudents().addStudent(a26);
        c4.getAllStudents().addStudent(a27);
        c4.getAllStudents().addStudent(a28);
        c4.getAllStudents().addStudent(a29);
        c4.getAllStudents().addStudent(a30);
        c4.getAllStudents().addStudent(a31);
        c4.getAllStudents().addStudent(a32);
        c4.getAllStudents().addStudent(a33);
        c4.getAllStudents().addStudent(a34);
        c4.getAllStudents().addStudent(a35);
        c4.getAllStudents().addStudent(a36);
        c4.getAllStudents().addStudent(a37);
        c4.getAllStudents().addStudent(a38);
        c4.getAllStudents().addStudent(a39);
        c4.getAllStudents().addStudent(a40);
        c5.getAllStudents().addStudent(a41);
        c5.getAllStudents().addStudent(a42);
        c5.getAllStudents().addStudent(a43);
        c5.getAllStudents().addStudent(a44);
        c5.getAllStudents().addStudent(a45);
        c5.getAllStudents().addStudent(a46);
        c5.getAllStudents().addStudent(a47);
        c5.getAllStudents().addStudent(a48);
        c5.getAllStudents().addStudent(a49);
        c5.getAllStudents().addStudent(a40);
        c5.getAllStudents().addStudent(a51);
        c5.getAllStudents().addStudent(a52);
        c5.getAllStudents().addStudent(a53);
        c5.getAllStudents().addStudent(a54);
        c5.getAllStudents().addStudent(a55);
        c5.getAllStudents().addStudent(a56);
        c5.getAllStudents().addStudent(a57);
        c5.getAllStudents().addStudent(a58);
        c5.getAllStudents().addStudent(a59);
        c5.getAllStudents().addStudent(a60);
        c6.getAllStudents().addStudent(a61);
        c6.getAllStudents().addStudent(a62);
        c6.getAllStudents().addStudent(a63);
        c6.getAllStudents().addStudent(a64);
        c6.getAllStudents().addStudent(a65);
        c6.getAllStudents().addStudent(a66);
        c6.getAllStudents().addStudent(a67);
        c6.getAllStudents().addStudent(a68);
        c6.getAllStudents().addStudent(a69);
        c6.getAllStudents().addStudent(a70);
        c6.getAllStudents().addStudent(a71);
        c6.getAllStudents().addStudent(a72);
        c6.getAllStudents().addStudent(a73);
        c6.getAllStudents().addStudent(a74);
        c6.getAllStudents().addStudent(a75);
        c6.getAllStudents().addStudent(a76);
        c6.getAllStudents().addStudent(a77);
        c6.getAllStudents().addStudent(a78);
        c6.getAllStudents().addStudent(a79);
        c6.getAllStudents().addStudent(a80);
        c7.getAllStudents().addStudent(a61);
        c7.getAllStudents().addStudent(a62);
        c7.getAllStudents().addStudent(a63);
        c7.getAllStudents().addStudent(a64);
        c7.getAllStudents().addStudent(a65);
        c7.getAllStudents().addStudent(a66);
        c7.getAllStudents().addStudent(a67);
        c7.getAllStudents().addStudent(a68);
        c7.getAllStudents().addStudent(a69);
        c7.getAllStudents().addStudent(a70);
        c7.getAllStudents().addStudent(a71);
        c7.getAllStudents().addStudent(a72);
        c7.getAllStudents().addStudent(a73);
        c7.getAllStudents().addStudent(a74);
        c7.getAllStudents().addStudent(a75);
        c7.getAllStudents().addStudent(a76);
        c7.getAllStudents().addStudent(a77);
        c7.getAllStudents().addStudent(a78);
        c7.getAllStudents().addStudent(a79);
        c7.getAllStudents().addStudent(a80);
        c8.getAllStudents().addStudent(a81);
        c8.getAllStudents().addStudent(a82);
        c8.getAllStudents().addStudent(a83);
        c8.getAllStudents().addStudent(a84);
        c8.getAllStudents().addStudent(a85);
        c8.getAllStudents().addStudent(a86);
        c8.getAllStudents().addStudent(a87);
        c8.getAllStudents().addStudent(a88);
        c8.getAllStudents().addStudent(a89);
        c8.getAllStudents().addStudent(a90);
        c8.getAllStudents().addStudent(a91);
        c8.getAllStudents().addStudent(a92);
        c8.getAllStudents().addStudent(a93);
        c8.getAllStudents().addStudent(a94);
        c8.getAllStudents().addStudent(a95);
        c8.getAllStudents().addStudent(a96);
        c8.getAllStudents().addStudent(a97);
        c8.getAllStudents().addStudent(a98);
        c8.getAllStudents().addStudent(a99);
        c9.getAllStudents().addStudent(a81);
        c9.getAllStudents().addStudent(a82);
        c9.getAllStudents().addStudent(a83);
        c9.getAllStudents().addStudent(a84);
        c9.getAllStudents().addStudent(a85);
        c9.getAllStudents().addStudent(a86);
        c9.getAllStudents().addStudent(a87);
        c9.getAllStudents().addStudent(a88);
        c9.getAllStudents().addStudent(a89);
        c9.getAllStudents().addStudent(a90);
        c9.getAllStudents().addStudent(a91);
        c9.getAllStudents().addStudent(a92);
        c9.getAllStudents().addStudent(a93);
        c9.getAllStudents().addStudent(a94);
        c9.getAllStudents().addStudent(a95);
        c9.getAllStudents().addStudent(a96);
        c9.getAllStudents().addStudent(a97);
        c9.getAllStudents().addStudent(a98);
        c9.getAllStudents().addStudent(a99);
        
        
        
        a1.getAllCourses().add(c1); //将课程列表导入每个学生


       /*
        sm1.getAllCourse().add(c1);//将课程列表导入学期
        sm1.getAllCourse().add(c2);
        sm1.getAllCourse().add(c3);
        sm2.getAllCourse().add(c4);
        sm2.getAllCourse().add(c5);
        sm2.getAllCourse().add(c6);
        
        sm3.getAllCourse().add(c1);
        sm3.getAllCourse().add(c2);
        sm3.getAllCourse().add(c3);
        sm4.getAllCourse().add(c4);
        sm4.getAllCourse().add(c5);
        sm4.getAllCourse().add(c6);*/
       
        
        c1.setSemester(sm1);
        c2.setSemester(sm1);  
        c3.setSemester(sm2);
        c4.setSemester(sm2);
        c5.setSemester(sm3);
        c6.setSemester(sm3);
        c7.setSemester(sm4);
        c8.setSemester(sm4);
        c9.setSemester(sm3);
        sm1.getAllCourse().add(c1);
        sm2.getAllCourse().add(c1);
        sm2.getAllCourse().add(c3);
        sm2.getAllCourse().add(c4);
        sm3.getAllCourse().add(c5);
        sm3.getAllCourse().add(c6);
        sm3.getAllCourse().add(c9);
        sm4.getAllCourse().add(c7);
        sm4.getAllCourse().add(c8);
        
        
        /*
        c1.getSemester().add(sm3);
        c2.getSemester().add(sm1);
        c2.getSemester().add(sm3);
        c3.getSemester().add(sm1);
        c3.getSemester().add(sm3);
        c4.getSemester().add(sm2);
        c4.getSemester().add(sm4);
        c5.getSemester().add(sm2);
        c5.getSemester().add(sm4);
        c6.getSemester().add(sm2);
        c6.getSemester().add(sm4);*/
        
 
    
    //Config(args);
    //StudentDirectory studentDirectory = new StudentDirectory();
    
    //university employment rate
    if(func==1){
    
    int ui=0;
    for(Student ua:studentDirectory.getStudentDirectory()){
           if((ua.getStatus()==1)&&(ua.getActive()==1))
            {
                ui++;
            } 
        }
    float getJob=ui;
    float allStudentNum=studentDirectory.getAllStudentNum();
    float DepempRate = getJob/allStudentNum;
    System.out.println(DepempRate);
    
    }
    
    if(func==11){
    
    int ui=0;
    int dpt1=0;
    for(Student ua:studentDirectory.getStudentDirectory()){
       if(ua.getDepartment()==dpt1_EN){
          dpt1++; 
        if((ua.getStatus()==1)&&(ua.getActive()==1))
            {
                ui++;
            } 
        }
    }
    float getJob=ui;
    float allStudentNum=dpt1;
    float DepempRate1 = getJob/allStudentNum;
    System.out.println("The employment rate of COE is"+": "+DepempRate1);
    
    }if(func==12){
    
    int ui=0;
    int dpt1=0;
    for(Student ua:studentDirectory.getStudentDirectory()){
       if(ua.getDepartment()==dpt4_Buss){
          dpt1++; 
        if((ua.getStatus()==1)&&(ua.getActive()==1))
            {
                ui++;
            } 
        }
    }
    float getJob=ui;
    float allStudentNum=dpt1;
    float DepempRate1 = getJob/allStudentNum;
    System.out.println("The employment rate of BUSINESS is"+": "+DepempRate1);
    
    }
    if(func==13){
    
    int ui=0;
    int dpt1=0;
    for(Student ua:studentDirectory.getStudentDirectory()){
       if(ua.getDepartment()==dpt5_Law){
          dpt1++; 
        if((ua.getStatus()==1)&&(ua.getActive()==1))
            {
                ui++;
            } 
        }
    }
    float getJob=ui;
    float allStudentNum=dpt1;
    float DepempRate1 = getJob/allStudentNum;
    System.out.println("The employment rate of LOW is"+": "+DepempRate1);
    }
    //college employment rate
    if(func==2){
        int ci=0;
        for(Student ca:studentDirectory.getStudentDirectory()){
            
        }
    }
    
    //course c1 students
    if(func == 2){
    System.out.println(c1);

    
    System.out.println(c2);

    System.out.println(c3);

    System.out.println(c4);

    System.out.println(c5);
    System.out.println(c6);

    //System.out.println(sd1);
    }
/*    
    System.out.println(c6);
    Iterator<Student> iter2 = c6.getAllStudents().iterator();  
    while (iter2.hasNext()) { // 迭代
    Student s = iter2.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    }
   } 
  */   
    if(func ==3){
        System.out.println(dpt1_EN) ;
        System.out.println("\t|- " + dpt1_EN.getAllStudents().getStudentDirectory()+"\n") ;
        }
    
    if(func ==4){
          System.out.println(u1) ;
          System.out.println(u2) ;
          System.out.println(u3) ;
    
   /*      
        System.out.println(dpt2_EN) ;
        Iterator<Student> iter1= dpt2_EN.getAllStudents().iterator() ;
        while(iter1.hasNext()){
            System.out.println("\t|- " + iter1.next()) ;
        }

     }
  */  
 }
    if(func == 9){
    System.out.println(c1);
  /*  Iterator<Student> iter1 = c1.getAllStudents().iterator();  
    while (iter1.hasNext()) { // 迭代
    Student s = iter1.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    */
    System.out.println(c1.getAllStudents().getStudentDirectory());
    
    System.out.println(c2);
  /*  Iterator<Student> iter1 = c1.getAllStudents().iterator();  
    while (iter1.hasNext()) { // 迭代
    Student s = iter1.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    */
    System.out.println(c2.getAllStudents().getStudentDirectory());
    System.out.println(c3);
  /*  Iterator<Student> iter1 = c1.getAllStudents().iterator();  
    while (iter1.hasNext()) { // 迭代
    Student s = iter1.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    */
    System.out.println(c3.getAllStudents().getStudentDirectory());
    System.out.println(c4);
  /*  Iterator<Student> iter1 = c1.getAllStudents().iterator();  
    while (iter1.hasNext()) { // 迭代
    Student s = iter1.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    */
    System.out.println(c4.getAllStudents().getStudentDirectory());
    System.out.println(c5);
  /*  Iterator<Student> iter1 = c1.getAllStudents().iterator();  
    while (iter1.hasNext()) { // 迭代
    Student s = iter1.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    */
    System.out.println(c5.getAllStudents().getStudentDirectory());
        System.out.println(c6);
  /*  Iterator<Student> iter1 = c1.getAllStudents().iterator();  
    while (iter1.hasNext()) { // 迭代
    Student s = iter1.next();// 取出学生对象  
    System.out.println("\t|- " + s); // 输出学生信息  
    */
    System.out.println(c6.getAllStudents().getStudentDirectory());
    //System.out.println(sd1);
    }
    
    }
}
