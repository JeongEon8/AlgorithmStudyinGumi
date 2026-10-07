import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] numbers = String.valueOf(n).split("");
        
        Arrays.sort(numbers, Collections.reverseOrder());
        
        return Long.parseLong(String.join("", numbers));
    }
}
