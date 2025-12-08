
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<Integer> scores = new ArrayList<>();
    public static ArrayList<student> list = new ArrayList<>();

    public static void main(String[] args){
        String b = "";
        //Getting the input file
        System.out.println("Submit your file's path");
        Scanner s = new Scanner(System.in);
        b = s.nextLine();
        //Reads input file and places all students in a student class array
        for (int i = 0; i < getStudentList(b).size(); i++) {
            list.add(getStudentList(b).get(i));
        }
        System.out.println(list);
        //reading through the student class array and calculates the students average score; stores in studentScores class array
        ArrayList <studentScores> studentScore = new ArrayList<>();
        studentScore=calculations.calculateGrade(list);

        System.out.println("\n----Final Scores----");
        //Reads through studentScores class and prints out the name, grade, and average score
        assignLetterGrade(studentScore);
    }

    //Reads the input file and returns the list of students.
    public static List<student> getStudentList(String filename) {
        Pattern pattern = Pattern.compile("\\d+");
        ArrayList<String> names = new ArrayList<>();
        List<student> students = new ArrayList<>();
        try {
            File inputFile = new File(filename);
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineData = line.split(" ");

                String name = lineData[0].trim();
                int score = Integer.parseInt(lineData[1].trim());
                students.add(new student(name, score));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return students;
    }
        //Reads the students average and assigns a letter grade.
    public static void assignLetterGrade (ArrayList<studentScores> scores) {

        String finalScore ="";
            String letterGrade[] = {"A", "B", "C", "D", "F"};
            Iterator<studentScores> iterator = scores.iterator();
            while (iterator.hasNext()) {
                studentScores finalStudent = iterator.next();
                if (finalStudent.getAverageScore() >= 90) {
                    finalScore = letterGrade[0];
                } else if ((finalStudent.getAverageScore() >= 80) && (finalStudent.getAverageScore() <= 89)) {
                    finalScore = letterGrade[1];
                } else if ((finalStudent.getAverageScore() >= 70) && (finalStudent.getAverageScore() <= 79)) {
                    finalScore = letterGrade[2];
                } else if ((finalStudent.getAverageScore() >= 60) && (finalStudent.getAverageScore() <= 69)) {
                    finalScore = letterGrade[3];
                } else {
                    finalScore = letterGrade[4];
                }
                System.out.println( finalStudent.getStudentName()+ " Final grade is " + finalScore + " Average is "+ finalStudent.getAverageScore());
            }
    }
}
