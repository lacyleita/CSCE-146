//Written by Lacy Leita 
// Last Edited: 11/25/2025
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        QuestionNode root = build();

        System.out.println("****************** Find your Major! ******************");
        System.out.println("Please answer the following questions with 'yes' or 'no'.\n");

        String recMajor = questions(root, scan);
        System.out.println("\nYour recommended major is: " + recMajor + "\n");

        Map<String, CourseList> majorMap = buildMajorCourseMap();

        CourseList courses = majorMap.get(recMajor.toLowerCase().trim());
        if (courses == null) {
            System.out.println("Error: major not recognized.");
            scan.close();
            return;
        }

        System.out.println("Enter the names of completed courses (type 'done' when finished):");
        System.out.println("HINT: Please type it exactly how you would see it; ie. 'CSCE 215'");
        while (true) {
            System.out.print("Completed course: ");
            String input = scan.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            courses.markComplete(input);
        }

        System.out.println("\nRemaining courses you still need to complete:");
        courses.printIncomplete();
        System.out.println("********* Goodbye!***********");
        scan.close();
    }

    //build method, building the BST
    public static QuestionNode build(){
        QuestionNode root = new QuestionNode(1, "Do you enjoy working with computers", false);
        QuestionNode q2 = new QuestionNode(2, "Do you like science", false); 
        QuestionNode q3 = new QuestionNode(3, "Do you enjoy programming? ", false);
        QuestionNode q4 = new QuestionNode(4, "Do you enjoy Math more than History? ", false);
        QuestionNode q5 = new QuestionNode(5, "Do you enjoy Chemistry more than Biology? ", false);
        QuestionNode q6 = new QuestionNode(6, "Do you enjoy working with hardware? ", false);
        QuestionNode q7 = new QuestionNode(8, "Do you enjoy politics? ", false);
        QuestionNode q8 = new QuestionNode(9, "Do you enjoy working with people? ", false);
        QuestionNode q9 = new QuestionNode(10, "Do you want to work in healthcare? ", false);
        QuestionNode q10 = new QuestionNode(11, "Do you enjoy math? ", false);
        QuestionNode q11 = new QuestionNode(12, "Do you enjoy math? ", false);
        QuestionNode q12 = new QuestionNode(14, "Do you enjoy art? ", false);
        QuestionNode q13 = new QuestionNode(15, "Do you enjoy law/politics? ", false);
        QuestionNode q14 = new QuestionNode(18, "Would you work with in an outside environment?", false);
        QuestionNode q15= new QuestionNode(23, "Do you enjoy data?", false);



        QuestionNode cs = new QuestionNode(7, "Computer Science", true);
        QuestionNode ee = new QuestionNode(13, "Electrical Engineering", true);
        QuestionNode math = new QuestionNode(16, "Math", true);
        QuestionNode bus = new QuestionNode(17, "Business", true);
        QuestionNode preM = new QuestionNode(19, "Pre-Medicine", true);
        QuestionNode chem = new QuestionNode(20, "Chemistry", true);
        QuestionNode chemE = new QuestionNode(21, "Chemical Engineering", true);
        QuestionNode it = new QuestionNode(22, "Information Technology", true);
        QuestionNode hist = new QuestionNode(24, "History", true);
        QuestionNode aHist = new QuestionNode(25, "Art History", true);
        QuestionNode polySci = new QuestionNode(26, "Criminal Justice", true);
        QuestionNode preL = new QuestionNode(27, "Political Science", true);
        QuestionNode bio = new QuestionNode(28, "Biology", true);
        QuestionNode civE = new QuestionNode(29, "Civil Engineering", true);
        QuestionNode ce = new QuestionNode(30, "Computer Engineering", true);
        QuestionNode da = new QuestionNode(31, "Data Analytics", true);


        root.yes = q3;
        root.no = q2 ;

        q2.yes =q5 ;
        q2.no = q4;

        q3.yes = cs;
        q3.no = q6;

        q4.yes = q8;
        q4.no = q7;

        q5.yes = q10;
        q5.no = q9;

        q6.yes = ee;
        q6.no = q11;

        q7.yes = q13;
        q7.no = q12;

        q8.yes = bus;
        q8.no = math;

        q9.yes = preM;
        q9.no = q14;

        q10.yes = chemE;
        q10.no = chem;

        q11.yes = q15;
        q11.no = it;

        q12.yes = aHist;
        q12.no = hist;

        q13.yes = preL;
        q13.no = polySci;

        q14.yes = civE;
        q14.no = bio;

        q15.yes = da;
        q15.no = ce ;

        return root;
    }


    //questions method, running through the questions
    public static String questions(QuestionNode root, Scanner sc){
    QuestionNode curr = root;

    while(!curr.isLeaf()){
        String prompt;
        if (curr.questionText != null) {
            prompt = curr.questionText;
        } else if (curr.major != null) {
            prompt = curr.major;
        } else {
            prompt = "Question text missing for node id=" + curr.id;
        }

        System.out.print(prompt + " (yes/no): ");
        String ans = sc.nextLine().trim().toLowerCase();

        if(ans.equals("yes") || ans.equals("y")){
            curr = curr.yes;
        } else if (ans.equals("no") || ans.equals("n")){
            curr = curr.no;
        } else {
            System.out.println("Please answer 'yes' or 'no'.");
        }
    }
    return curr.major;
}


    
    //Hashmap of the courses for each major
    public static Map<String, CourseList> buildMajorCourseMap(){
        Map<String, CourseList> map = new HashMap<>();

        CourseList cs = new CourseList();
        cs.add("CSCE 190");
        cs.add("CSCE 240");
        cs.add("CSCE 145");
        cs.add("CSCE 146");
        cs.add("CSCE 215");
        cs.add("CSCE 211");
        map.put("computer science", cs);

        CourseList it = new CourseList();
        it.add("ITEC 101");
        it.add("ITEC 264");
        it.add("ITEC 245");
        it.add("ITEC 233");
        it.add("ITEC 265");
        it.add("ITEC 370");
        map.put("information technology", it);

        CourseList chem = new CourseList();
        chem.add("CHEM 141");
        chem.add("CHEM 142");
        chem.add("CHEM 333");
        chem.add("CHEM 332");
        chem.add("CHEM 334");
        chem.add("CHEM 550");
        map.put("chemistry", chem);

        CourseList bio = new CourseList();
        bio.add("BIO 101");
        bio.add("BIO 102");
        bio.add("BIO 301");
        bio.add("BIO 302");
        bio.add("CHEM 333");
        bio.add("CSCE 102");
        map.put("biology", bio);

        CourseList ee = new CourseList();
        ee.add("ELCT 102");
        ee.add("ELCT 221");
        ee.add("ELCT 201");
        ee.add("ELCT 101");
        ee.add("PHYS 212");
        ee.add("ELCT 363");
        map.put("electrical engineering", ee);
        
        CourseList math = new CourseList();
        math.add("MATH 241");
        math.add("MATH 300");
        math.add("MATH 511");
        math.add("MATH 550");
        math.add("MATH 544");
        math.add("MATH 142");
        map.put("math", math);

        CourseList bus = new CourseList();
        bus.add("ACCT 226");
        bus.add("MGMT 371");
        bus.add("ECON 221");
        bus.add("FINA 363");
        bus.add("MGMT 250");
        bus.add("BADM 301");
        map.put("business", bus);

        CourseList preM = new CourseList();
        preM.add("CHEM 141");
        preM.add("CHEM 142");
        preM.add("CHEM 333");
        preM.add("BIO 101");
        preM.add("BIO 102");
        preM.add("BIO 301");
        map.put("pre-medicine", preM);

        CourseList chemE = new CourseList();
        chemE.add("EHCU 310");
        chemE.add("CHEM 333");
        chemE.add("EHCU 320");
        chemE.add("EHCU 440");
        chemE.add("EHCU 360");
        chemE.add("EHCU 456");
        map.put("chemical engineering", chemE);
       
        CourseList hist = new CourseList();
        hist.add("ENGL 102");
        hist.add("HIST 300");
        hist.add("HIST 497");
        hist.add("HIST 498");
        hist.add("ENGL 101");
        hist.add("ENGL 499");
        map.put("history", hist);
        
        CourseList arth = new CourseList();
        arth.add("ARTH 200");
        arth.add("ARTH 501");
        arth.add("ARTH 106");
        arth.add("ARTH 107");
        arth.add("ARTH 105");
        arth.add("ENGL 101");
        map.put("art history", arth);

        CourseList cj = new CourseList();
        cj.add("CRJU 311");
        cj.add("CRJU 303");
        cj.add("CRJU 314");
        cj.add("CRJU 351");
        cj.add("CRJU 210");
        cj.add("CRJU 312");
        map.put("criminal justice", cj);

        CourseList poli = new CourseList();
        poli.add("POLI 101");
        poli.add("POLI 303");
        poli.add("POLI 105");
        poli.add("POLI 201");
        poli.add("ENGL 101");
        poli.add("ENGL 102");
        map.put("political science", poli);

        CourseList civE = new CourseList();
        civE.add("ECIV 201");
        civE.add("ECIV 220");
        civE.add("ECIV 111");
        civE.add("ECIV 360");
        civE.add("MATH 242");
        civE.add("ECIV 303");
        map.put("civil engineering", civE);


        CourseList ce = new CourseList();
        ce.add("CSCE 211");
        ce.add("CSCE 212");
        ce.add("PHYS 211");
        ce.add("CSCE 240");
        ce.add("CSCE 274");
        ce.add("CSCE 611");
        map.put("computer engineering", ce);

        CourseList da = new CourseList();
        da.add("STAT 587");
        da.add("CSCE 567");
        da.add("ISIC 215");
        da.add("ENGL 363");
        da.add("STAT 587");
        da.add("STAT 511");
        map.put("data analytics", da);

        return map;
    }}
   


       