  # [백준 - 실버 3] 10655. 마라톤 1
  
  ## ⏰**time**
  20분
  
  ## :pushpin: **Algorithm**
  브루트포스
  
  ## ⏲️**Time Complexity**
  $O(N)$
  
  ## :round_pushpin: **Logic**
  1. 먼저 건너뛰지 않고 가는 거리를 구한다
  2. 1을 건너뛰는 경우 0->1 1->2로 인해 소모되는 거리를 빼주고
  3. 0->2의 거리를 더 해주면 1을 건너뛰는 거리의 총합이 된다.
  4. 다시 복구해서 건너뛰지 않고 가는 거리를 복구하고 모든 포인트에 대해 반복
  ```
    for(int i=1; i<n-1; i++) {
            sum-=Math.abs(xs[i]-xs[i-1])+Math.abs(ys[i]-ys[i-1]);
            sum-=Math.abs(xs[i]-xs[i+1])+Math.abs(ys[i]-ys[i+1]);
            sum+=Math.abs(xs[i-1]-xs[i+1])+Math.abs(ys[i-1]-ys[i+1]);
            if(answer>sum)answer=sum;
            sum-=Math.abs(xs[i-1]-xs[i+1])+Math.abs(ys[i-1]-ys[i+1]);
            sum+=Math.abs(xs[i]-xs[i-1])+Math.abs(ys[i]-ys[i-1]);
            sum+=Math.abs(xs[i]-xs[i+1])+Math.abs(ys[i]-ys[i+1]);
		}
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/10655
