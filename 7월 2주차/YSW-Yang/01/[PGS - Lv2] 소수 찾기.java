import java.util.*;

class Solution {
    Set<Integer> numberSet;
    
    public int solution(String numbers) {
        int answer = 0;
        numberSet = new HashSet<>();
        combine("", numbers);
        
        for(int num : numberSet){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void combine(String comb, String numbers){
        if(comb != ""){
            numberSet.add(Integer.parseInt(comb));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            combine(comb + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
    
    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}
