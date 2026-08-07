import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        makeNumber(numbers, 0, 0);
        
        for (int number : set) {
            if (isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void makeNumber(String numbers, int current, int visited) {
        for (int i = 0; i < numbers.length(); i++) {
            if ((visited & (1 << i)) != 0) 
                continue;
            
            int next = current * 10 + (numbers.charAt(i) - '0');
            set.add(next);

            makeNumber(numbers, next, visited | (1 << i));
        }
    }
    
    boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
