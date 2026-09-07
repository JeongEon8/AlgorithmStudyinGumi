class Solution {
    
    int[] arr = new int[100001];
    
    public int solution(int n) {
        int answer = 0;
        return pbc(n);
    }
    
    public int pbc(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            arr[n] = 1;
            return 1;
        }
        
        if(arr[n] != 0){
            return arr[n];
        }

        arr[n] = (pbc(n - 1) + pbc(n - 2))%1234567;
        return arr[n];
    }
}
