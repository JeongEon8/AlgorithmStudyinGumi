class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        
        while (true) {
            n++;
            if (Integer.bitCount(n) == count) {
                return n;
            }
        }
    }
}
