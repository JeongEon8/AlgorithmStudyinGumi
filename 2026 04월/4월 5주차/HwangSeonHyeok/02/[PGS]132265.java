class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] right = new int[10001];
        boolean[] left = new boolean[10001];
        int rightCnt = 0;
        int leftCnt = 0;
        for(int t:topping){
            if(right[t]==0){
                rightCnt++;
            }
            right[t]++;
        }
        for(int t:topping){
            if(!left[t]){
                left[t] = true;
                leftCnt++;
            }
            right[t]--;
            if(right[t]==0){
                rightCnt--;
            }
            if(rightCnt==leftCnt){
                answer++;
            }
            if(leftCnt>rightCnt)break;
        }
        return answer;
    }
}