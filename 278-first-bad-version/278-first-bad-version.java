/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        if (n == 1)
            return 1;
        int mini = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            boolean b = isBadVersion(mid);
            if (b) {
                high = mid - 1;
                mini = Math.min(mini, mid);
            }
            else
                low = mid + 1;
        }
        
        return mini;
    }
}