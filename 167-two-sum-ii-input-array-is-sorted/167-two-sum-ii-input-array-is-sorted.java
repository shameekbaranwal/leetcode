class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min = 0;
        int max = numbers.length - 1;
        
        while (true) {
            int sum = numbers[min] + numbers[max];
            if (sum == target)
                return new int[] {min + 1, max + 1};
            if (sum < target)
                min++;
            if (sum > target)
                max--;
        }
    }
}