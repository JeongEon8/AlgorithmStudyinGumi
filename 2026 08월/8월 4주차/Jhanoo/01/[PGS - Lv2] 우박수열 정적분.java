import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> arr = new ArrayList<>();
        arr.add(0.0);
        
        int i = 0;
        while (k > 1) {
            int prev = k;
            if (k % 2 == 0) 
                k /= 2;
            else 
                k = k * 3 + 1;
            
            arr.add(arr.get(i++) + (double) (prev + k) / 2);
        }
        
        double[] answer = new double[ranges.length];
        int n = arr.size() - 1;
        
        i = 0;
        for (int[] range : ranges) {
            int a = range[0];
            int b = range[1];
            
            if (a > n + b) {
                answer[i++] = -1.0;
                continue;
            }
            
            answer[i++] = arr.get(n + b) - arr.get(a); 
        }
        
        return answer;
    }
}
