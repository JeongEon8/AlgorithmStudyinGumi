  # [백준 - 골드 5] 20437. 문자열 게임 2
  
  ## ⏰**time**
  40분
  
  ## :pushpin: **Algorithm**
  슬라이딩 윈도우
  
  ## ⏲️**Time Complexity**
  $O(N)$
  
  ## :round_pushpin: **Logic**
  1. 알파벳 인덱스와 갯수를 구해준 뒤
  2. 인덱스를 바탕으로 길이를 계산
  ```Java
            for (int i = 0; i < 26; i++) {
            if (counts.get(i).size() < n) continue;
            for (int j = 0; j < counts.get(i).size() - n + 1; j++) {
                int startIdx = counts.get(i).get(j);
                int lastIdx = counts.get(i).get(j + n - 1);
                int gap = lastIdx - startIdx + 1;
                if (s > gap) s = gap;
                if (l < gap) l = gap;
            }
        }
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/20437
