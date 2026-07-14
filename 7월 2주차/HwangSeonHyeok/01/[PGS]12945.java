class Solution {
    public int solution(int n) {
        int current = 1;
        int p = 0;
        int pp = 0;
        for(int i = 1; i<n; i++){
            pp = p;
            p = current;
            current = (p + pp)%1234567;
        }
        return current;
    }
}