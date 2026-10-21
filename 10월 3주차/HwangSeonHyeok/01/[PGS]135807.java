class Solution {
    int gcd(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b =tmp;
        }
        return a;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i = 1; i<arrayA.length; i++){
            gcdA = gcd(gcdA,arrayA[i]);
        }
        for(int i = 1; i<arrayB.length; i++){
            gcdB = gcd(gcdB,arrayB[i]);
        }
        boolean canDivide = false;
        for(int i = 0; i<arrayB.length; i++){
            if(arrayB[i]%gcdA==0){
                canDivide = true;
                break;
            }
        }
        if(!canDivide){
            answer = gcdA;
        }
        canDivide = false;
        for(int i = 0; i<arrayA.length; i++){
            if(arrayA[i]%gcdB==0){
                canDivide = true;
                break;
            }
        }
        if(!canDivide){
            answer = Math.max(answer,gcdB);
        }
        
        return answer;
    }
}