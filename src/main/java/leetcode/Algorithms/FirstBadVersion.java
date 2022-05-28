package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * You are a product manager and currently leading a team to develop
 * a new product. Unfortunately, the latest version of your product
 * fails the quality check. Since each version is developed based on
 * the previous version, all the versions after a bad version are also bad.
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 2^31 - 1
 */
public class FirstBadVersion {
    static int firstBad = -1;
    public static int firstBadVersion(int n, int bad) {
        firstBad = bad;
        return findFirstBadVersion(n);
    }

    public static boolean isBadVersion(int n) {
        if (n >= firstBad) {
            return true;
        }
        return false;
    }

    public static int findFirstBadVersion(int n) {
        int start = 1, end = n;
        for (; start < end; ) {
            long d = start;
            d += end;
            int mid = (int)(d / 2);
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        return start + 1;
    }

    /**
     * Tricks and improvements
     * @param n
     * @return
     */
    public static int findFirstBadVersion2(int n) {
        int result = n;
        for (int start = 1, end = n; start <= end; ) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
