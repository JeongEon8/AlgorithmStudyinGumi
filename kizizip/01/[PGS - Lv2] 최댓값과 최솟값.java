class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        
        int[] nums2 = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            nums2[i] = Integer.parseInt(nums[i]);
        }
        
        int max = nums2[0];
        int min = nums2[0];
        for (int i =1; i < nums2.length; i++) {
            if (nums2[i] < min) {
                min = nums2[i];
            } else if (nums2[i] > max) {
                max = nums2[i];
            }
        }
        
        String answer = min + " " + max;
        return answer;
    }
}
