  # [백준 - 실버 5] 15235. Olympiad Pizza
  
  ## ⏰**time**
  10분
  
  ## :pushpin: **Algorithm**
  큐
  
  ## ⏲️**Time Complexity**
  $O(N)$
  
  ## :round_pushpin: **Logic**
  1. 큐 1개로 실제 사람을 구현하고
  2. 다른 큐 1개로 순서를 보관
  ```
     Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int[] answers = new int[t];
        for (int i = 0; i < t; i++) {
            q.add(Integer.parseInt(st.nextToken()));
            q2.add(i);
        }

        int count = 1;
        while (!q2.isEmpty()) {
            int now = q.poll();
            int order = q2.poll();
            if (--now > 0) {
                q.add(now);
                q2.add(order);
            } else {
                answers[order] = count;
            }
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for (int now : answers) {
            sb.append(now);
            sb.append(' ');
        }
        System.out.println(sb);
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/15235
