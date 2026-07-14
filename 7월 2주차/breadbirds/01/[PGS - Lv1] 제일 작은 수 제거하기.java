class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        
        if(arr.length ==1){
            return new int[]{-1};
        }
        
        for(int i = 0; i < arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!=min){
                answer[idx] = arr[i];
                idx++;
            }
        }
        
        
        return answer;
    }
}
