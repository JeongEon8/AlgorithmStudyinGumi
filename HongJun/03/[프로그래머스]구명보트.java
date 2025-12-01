import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);

        int st = 0;
        int en = people.length - 1;
        
        while (st <= en) {
            if (people[st] + people[en] <= limit) {
                st++;
            }
            en--;
            answer++;

        }
        
        return answer;
    }
}