//Object that stores all the student names and averages after the calculations are done
public class studentScores {
    private String studentName;
    private double averageScore;
    public studentScores(String studentName, double averageScore) {
        this.studentName = studentName;
        this.averageScore = averageScore;

    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public double getAverageScore() {
        return averageScore;
    }
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
