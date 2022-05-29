import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int i = 0, l = s.length(), num = 0;
        
        while (i < l) {
            int prevNum = num;
            
            char s1 = s.charAt(i);
            
            if (i + 1 != l) {
                String s2 = s.substring(i, i + 2);
                switch(s2) {
                    case "CM":
                        num += 900;
                        break;
                    case "CD":
                        num += 400;
                        break;
                    case "XC":
                        num += 90;
                        break;
                    case "XL":
                        num += 40;
                        break;
                    case "IX":
                        num += 9;
                        break;
                    case "IV":
                        num += 4;
                        break;
                }
                if (prevNum != num) {
                    i+=2;
                    continue;
                }
            }
            
            switch(s1) {
                case 'M':
                    num += 1000;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'I':
                    num += 1;
                    break;
            }
            i++;
        }
        
        return num;
    }
}