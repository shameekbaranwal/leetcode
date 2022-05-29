class Solution {
    int[] fibonacci;
    
    public int fibo(int n) {
        if (n <= 1)
            return n;
        if (fibonacci[n] != 0)
            return fibonacci[n];
        
        fibonacci[n] = fibo(n-1) + fibo(n-2);
        return fibonacci[n];
    }
    
    public int fib(int n) {
        fibonacci = new int[n+1];
        return fibo(n);
    }
}