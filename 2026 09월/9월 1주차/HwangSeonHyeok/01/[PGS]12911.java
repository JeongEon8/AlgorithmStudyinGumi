class Solution {
    public int solution(int n) {
        int nBit = Integer.bitCount(n);
        int current = n+1;
        while(true){
            if(nBit==Integer.bitCount(current)){
                return current;
            }
            current++;
        }
    }
}