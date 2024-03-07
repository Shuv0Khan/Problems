package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 */
public class BankLaser {
    public int numberOfBeams(String[] bank) {
        int noOfBeams = 0;
        int noOfLasersOnPrevRow = 0;
        for (int i = 0; i < bank.length; i++) {
            int countLasers = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    countLasers++;
                }
            }
            if (countLasers > 0) {
                noOfBeams += (noOfLasersOnPrevRow * countLasers);
                noOfLasersOnPrevRow = countLasers;
            }
        }

        return noOfBeams;
    }
}
