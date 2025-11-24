package programmers;

import java.util.Arrays;

public class Prgrammers_봉인된주문 {

	static class Alpha implements Comparable<Alpha>{
        String alphabet;
        Alpha(String alphabet){
            this.alphabet = alphabet;
        }
        
        @Override
        public int compareTo(Alpha o) {
        if (this.alphabet.length() != o.alphabet.length()) {
            return this.alphabet.length() - o.alphabet.length();   // 나이 오름차순
        }
        return this.alphabet.compareTo(o.alphabet); // 이름 오름차순
    }
    }
    public String solution(long n, String[] bans) {
        int len = bans.length;
        Alpha[] alphas = new Alpha[len];
        for(int i = 0; i<len; i++){
            Alpha alpha = new Alpha(bans[i]);
            alphas[i] = alpha;
        }
        Arrays.sort(alphas);
        
        int total = 0;
        for(int i =0; i<len; i++){
            String s = alphas[i].alphabet;
            long index = getIndexOf(s);
            if(index-total <=n){
                total++;
            }else{
                break;
            }
        }
        
        
        
        String answer = getStringAt(n+total);
        return answer;
    }
    
    static long getIndexOf(String s) {
        long result = 0;
        for (char ch : s.toCharArray()) {
            result = result * 26 + (ch - 'a' + 1);
        }
        return result;
    }
    
    static String getStringAt(long n) {
        StringBuilder sb = new StringBuilder();
        long num = n;

        while (num > 0) {
            num -= 1;  
            long remainder = num % 26;
            sb.append((char)('a' + remainder));
            num /= 26;
        }

        return sb.reverse().toString();
    }

}
