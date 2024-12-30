class Solution {
  public int[] solution(int brown, int yellow) {
      int[] answer = new int[2];
      int cnt = 1;
      while (yellow / cnt >= cnt) { 
        if(yellow % cnt == 0) {
            if(((yellow/cnt)+2)*(cnt+2) - yellow == brown){
              answer[0] = (yellow/cnt)+2;
              answer[1] = cnt + 2;
              break;
            }
        }
        cnt += 1;
      }
      return answer;
  }
}
