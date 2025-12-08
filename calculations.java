import java.util.ArrayList;

public class calculations {

    public static ArrayList<studentScores> calculateGrade(ArrayList<student> list) {
        ArrayList<studentScores> studentScore = new ArrayList<>();
        double averageScore = 0;
        String studentName = "";
        String lastStudent = "";
        double totalScore = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            studentName = list.get(i).getName();
            if (lastStudent != "" && !lastStudent.equals(studentName)) {
                averageScore = totalScore / count;
                studentScore.add(new studentScores(lastStudent, averageScore));
                totalScore = 0;
                averageScore = 0;
                count = 0;
            }

            if ((lastStudent.equals(studentName) && lastStudent != "") || (!lastStudent.equals(studentName))) {
                totalScore += list.get(i).getScore();
                count++;
            }
            lastStudent = studentName;
        }
        averageScore = totalScore / count;
        studentScore.add(new studentScores(lastStudent, averageScore));
        return studentScore;
    }
}
