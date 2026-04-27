import java.util.*;

class Solution {
    public String solution(String s) {
        int[] nums = Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        Arrays.sort(nums);
        
        String answer = nums[0] + " " + nums[nums.length - 1];
        return answer;
    }
}