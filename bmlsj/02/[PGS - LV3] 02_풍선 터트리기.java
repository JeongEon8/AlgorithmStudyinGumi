class Solution {
    public int solution(int[] a) {
        int n = a.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        // 왼쪽에서의 누적 최솟값 구하기
        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < min) min = a[i];
            leftMin[i] = min;
        }
        
        // 오른쪽에서의 누적 최솟값 구하기
        min = a[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < min) min = a[i];
            rightMin[i] = min;
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }
        
        return answer;
    }
}