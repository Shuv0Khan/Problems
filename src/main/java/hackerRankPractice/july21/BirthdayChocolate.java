package hackerRankPractice.july21;/*https://www.hackerrank.com/challenges/the-birthday-bar/problem*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        if(s.size() < m){
            return 0;
        }
        int sum = 0;
        int segments = 0;
        for(int i=0;i<m;i++){
            sum+=s.get(i);
        }
        if(sum == d){
            segments++;
        }
        for(int i=1,j=m; j<s.size();i++,j++){
            sum-=s.get(i-1);
            sum+=s.get(j);
            if(sum == d){
                segments++;
            }
        }
        return segments;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
