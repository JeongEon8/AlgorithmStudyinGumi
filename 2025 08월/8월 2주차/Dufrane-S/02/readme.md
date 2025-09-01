  # [백준 - 실버 4] 20044. Project Teams
  
  ## ⏰**time**
  10분
  
  ## :pushpin: **Algorithm**
  그리디
  
  ## ⏲️**Time Complexity**
  $O(N)$ 
  
  ## :round_pushpin: **Logic**
  1. 실력순으로 정렬한 뒤
  2. 낮은 순 : 높은 순으로 짝지어 주면 된다
  ```
    Arrays.sort(list);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = list[i] + list[n * 2 - i - 1];
            if (answer > sum) answer = sum;
        }
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/
