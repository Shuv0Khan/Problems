package hackerRankPractice.july21;/*https://www.hackerrank.com/challenges/drawing-book/problem*/

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        if(p%2 != 0)p-=1;
        int start = (p/2);
        int end = (n-p);
        if(end % 2 != 0) end-=1;
        end = end/2;
        return Math.min(start, end);
    }

    public static void main (String[] args) {
        System.out.println(pageCount(9, 9));
        System.out.println(pageCount(9, 8));
        System.out.println(pageCount(9, 7));
        System.out.println(pageCount(9, 6));
        System.out.println(pageCount(9, 5));
        System.out.println(pageCount(9, 4));
        System.out.println(pageCount(9, 3));
        System.out.println(pageCount(9, 2));
        System.out.println(pageCount(9, 1));



        System.out.println(pageCount(2, 2));
        System.out.println(pageCount(2, 1));
    }

    /*private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}
