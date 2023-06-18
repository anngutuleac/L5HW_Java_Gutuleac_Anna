import java.util.Scanner;
public class AvgGradeCalc {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название дисциплины: ");
        String subjectName = scanner.nextLine();

        System.out.print("Введите количество студентов в группе: ");
        int numberOfStudents = scanner.nextInt();
        Student students[] = new Student[numberOfStudents];

        for(int i = 0; i < numberOfStudents; i++) {
            System.out.print("Введите оценку по дисциплине "
                    + subjectName
                    + " студента под номером "
                    + (i + 1)
                    + ": ");
            int grade = scanner.nextInt();
            students[i] = new Student(subjectName, grade);
        }

        double avgGrade = averageGradeValue(students);
        System.out.println("Средняя оценка в группе по дисциплине " + subjectName + ": " + avgGrade);
    }

    static double averageGradeValue(Student students[]) {
        int i = 0;
        double gradeSum = 0;
        while (i < students.length) {
            Student student = students[i];
            gradeSum += student.getGradeValue();
            i++;
        }
        return gradeSum / students.length;
    }
}

class Student {
    private Subject subject;
    private Grade grade;

    public Student(String name, int grade) {
        this.subject = new Subject(name);
        this.grade = new Grade(grade);
    }

    int getGradeValue() {
        return grade.getValue();
    }
}

class Subject{
    private String name;

    public Subject(String name) throws IllegalArgumentException {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Название предмета не должно быть пустым!");
        }
        this.name = name;
    }
}

class Grade {
    private int value;
    private int min = 1;
    private int max = 10;
    public Grade(int value) throws IllegalArgumentException {
        if (value < min || value > max) {
            throw new IllegalArgumentException("Оценка должна быть в пределах от " + min + " до " + max + "!");
        }
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
