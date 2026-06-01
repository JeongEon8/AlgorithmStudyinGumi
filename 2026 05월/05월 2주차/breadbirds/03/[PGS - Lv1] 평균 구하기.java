class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double x = 0;
        for(int i = 0; i < arr.length; i++){
            x += arr[i];
        }
        answer = x/arr.length;
        return answer;
    }
}
