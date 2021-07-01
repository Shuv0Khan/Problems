package hackerRankPractice;/*https://www.hackerrank.com/challenges/counting-valleys/problem*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        char[] steps = s.toCharArray();
        int elevation = 0;
        int valleys = 0;

        for(int i=0;i<steps.length;i++){
            char nextStep = steps[i];
            if(elevation == 0 && nextStep == 'D'){
                valleys++;
            }
            if (nextStep == 'U') {
                elevation++;
            }else if(nextStep == 'D'){
                elevation--;
            }
        }
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
