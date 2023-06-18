import java.util.Scanner;
public class GradeCalc {
    public static void main(String args[]) {
        int minScore = 0;
        int maxScore = 100;
        GradeRange rangeF = new GradeRange(minScore, 59, "F");
        GradeRange rangeD = new GradeRange(60, 69, "D");
        GradeRange rangeC = new GradeRange(70, 79, "C");
        GradeRange rangeB = new GradeRange(80, 89, "B");
        GradeRange rangeA = new GradeRange(90, maxScore, "A");
        GradeRange rangeArr[] = { rangeA, rangeB, rangeC, rangeD, rangeF };

        System.out.print("Введите количество, набранных очков: ");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if (score > maxScore || score < minScore) {
            System.out.println("Количество очков должно быть в пределах от " +
                    minScore +
                    " до " +
                    maxScore);
        }
        for (GradeRange range: rangeArr) {
            if (range.isScoreInRange(score)) {
                System.out.println("Ваша оценка: " + range.getGrade());
                break;
            }
        }
    }
}

class GradeRange {
    private int low;
    private int high;
    private String grade;

    public GradeRange(int low, int high, String grade){
        this.low = low;
        this.high = high;
        this.grade = grade;
    }

    boolean isScoreInRange(int score) {
        return score >= low && score <= high;
    }
    
    String getGrade() {
        return grade;
    }
}
