class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        int[] arr = new int[n * 2];
        long total = 0;
        long current = 0;
        
        for(int i = 0; i < n; i++){
            total += queue1[i];
            arr[i] = queue1[i];
        }
        current = total;
        
        for(int i = 0; i < n; i++){
            total += queue2[i];
            arr[n + i] = queue2[i];
        }
        
        if(total % 2 != 0){
            return -1;
        }
        
        long target = total / 2;
        int left = 0;
        int right = n - 1;
        while(right < n * 2){
            if(current == target){
                return answer;
            }
            
            if(current > target){
                current -= arr[left++];
            }else{
                right++;
                if(right >= n * 2){
                   break; 
                }
                current += arr[right];
            }
            answer++;
        }
            
        return -1;
    }
}
