class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = Math.max(check(arrayA, arrayB), check(arrayB, arrayA));
        return answer;
    }
    
    public int check(int[] mine, int[] other){
        int res = mine[0];
        for(int i = 1; i < mine.length; i++){
            res = gcd(res, mine[i]);
        }
        
        for(int i = 0; i < other.length; i++){
            if(other[i] % res == 0){
                return 0;
            }
        }
        
        return res;
    }
    
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}
