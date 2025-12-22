  # [백준 - 실버 3] 20310. 타노스
  
  ## ⏰**time**
  20분
  
  ## :pushpin: **Algorithm**
  그리디
  
  ## ⏲️**Time Complexity**
  $O(N)$ 
  
  ## :round_pushpin: **Logic**
  1. 앞에서부터 1을 제거
  2. 뒤에서부터 0을 제거
  ```
    tmp = zeros / 2;
        s = sb.toString();
        sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sb.append(1);
            } else if (tmp > 0) {
                tmp--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/20310
