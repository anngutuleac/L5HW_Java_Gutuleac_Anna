public class Avg {
    public static void main(String args[]) {
        double nums[] = {1.8, 2.5, 3.1, 4.1, 5.2, 6.6, 7.9, 8.5, 9.7, 10.2};
        double sum = 0;
        for(int i = 0; i < nums.length; i++) sum +=nums[i];
        System.out.println("Average: "+sum/nums.length);
    }
}
