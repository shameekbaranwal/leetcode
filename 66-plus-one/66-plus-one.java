class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0)
            return digits;
        int[] newDigits = new int[digits.length + 1];
        for(int i = 0; i < digits.length; i++)
            newDigits[i + 1] = digits[i];
        newDigits[0] = 1;
        return newDigits;
    }
}