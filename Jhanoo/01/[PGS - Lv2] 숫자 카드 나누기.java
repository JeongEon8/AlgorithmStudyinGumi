import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = getArrayGcd(arrayA);
        int gcdB = getArrayGcd(arrayB);
        
        int candidateA = canDivide(gcdB, arrayA) ? 0 : gcdB;
        int candidateB = canDivide(gcdA, arrayB) ? 0 : gcdA;
        
        return Math.max(candidateA, candidateB);
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        
        return a;
    }
    
    public int getArrayGcd(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        
        return result;
    }
    
    public boolean canDivide(int divisor, int[] arr) {
        for (int num : arr) {
            if (num % divisor == 0) {
                return true;
            }
        }
        
        return false;
    }
}
