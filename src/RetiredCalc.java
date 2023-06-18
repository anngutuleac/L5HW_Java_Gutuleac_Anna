import java.util.Scanner;
public class RetiredCalc {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш пол (M или F): ");
        char gender = scanner.next().charAt(0);
        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        Human human = new Human(gender, age);
        int retiredAgeDiff = human.retiredAgeDiff();

        if (retiredAgeDiff > 0) {
            System.out.println("До выхода на пенсию осталось " + retiredAgeDiff + " лет");
        } else if (retiredAgeDiff < 0) {
            System.out.println("Вы на пенсии уже " + (retiredAgeDiff * (-1)) + " лет, поздравляем!");
        } else {
            System.out.println("Вы на пенсии с этого года, поздравляем!");
        }
    }
}

class Human {
    private int age;
    private int retiredAge;

    public Human(char gender, int age) throws IllegalArgumentException {
        switch (gender) {
            case 'M':
                retiredAge = 70;
                break;
            case 'F':
                retiredAge = 65;
                break;
            default:
                throw new IllegalArgumentException("Пол задан неверно!");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть неотрицательным!");
        }
        this.age = age;
    }

    int retiredAgeDiff() {
        return retiredAge - age;
    }
}
