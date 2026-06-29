class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        for (int i = 1; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                for (int k = j + 1; k <= n - 2; k++) {
                    for (int l = k + 1; l <= n - 1; l++) {
                        for (int m = l + 1; m <= n; m++) {
                            
                            int[] numbers = {i, j, k, l, m};
                            boolean check = true;
                            
                            for (int index = 0; index < q.length; index++) {
                                int[] current = q[index];
                                int target = ans[index];
                                
                               
                                int count = 0;
                                for (int number : numbers) {
                                    for (int c : current) {
                                        if (number == c) {
                                            count++;
                                            break; 
                                        }
                                    }
                                }
                                
                                if (count != target) {
                                    check = false;
                                    break;
                                }
                            }
                            
                            if (check) {
                                answer++;
                            }
                            
                        }
                    }
                }
            }
        }

        return answer;
    }
}
