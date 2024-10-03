import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
  static ArrayList<Integer>[] arr;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    arr = new ArrayList[4];
    StringTokenizer st = null;
    for (int i = 0; i < 4; i++) {
      st = new StringTokenizer(bf.readLine());
      String str = st.nextToken();
      arr[i] = new ArrayList<>();
      for (int j = 0; j < 8; j++) {
        arr[i].add(str.charAt(j)-'0');
      }
    }
    st = new StringTokenizer(bf.readLine());
    int K = Integer.parseInt(st.nextToken());

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(bf.readLine());
      int order = Integer.parseInt(st.nextToken())-1;
      int dir = Integer.parseInt(st.nextToken());
      updateArr(order, dir);
      if(order == 0) compare(1, 0, dir);
      else if(order == 3) compare(2, 3, dir);
      else {
        compare(order-1, order, dir);
        compare(order+1, order, dir);
      }
    }

    int score = 0;
    for (int i = 0; i < 4; i++) {
      if(arr[i].get(0) == 1) {
        score += Math.pow(2, i);
      }
    }
    System.out.println(score);
  }

  static void compare(int nextTo, int cur, int dir){ // 비교하기, return 값이 true일 경우 같음, false일 경우 다름 -> 다를 경우 배열 update 해야함
    // nextTo가 비교할 톱니의 인덱스, cur이 현재 톱니의 인덱스, dir이 현재 톱니가 움직이고자 하는 방향
    if(nextTo > cur){ // 오른쪽 톱니와의 비교
      if(dir == -1){
        if(arr[nextTo].get(6).equals(arr[cur].get(1)) == false){
          updateArr(nextTo, dir*-1);
          if(nextTo < 3) compare(nextTo+1, nextTo, dir*-1);
        }
      }else if(dir == 1) {
        if(arr[nextTo].get(6).equals(arr[cur].get(3)) == false){
          updateArr(nextTo, dir*-1);
          if(nextTo < 3) compare(nextTo+1, nextTo, dir*-1);
        }
      }
    }else if(nextTo < cur){
      if(dir == -1){
        if(arr[nextTo].get(2).equals(arr[cur].get(5)) == false){
          updateArr(nextTo, dir*-1);
          if(nextTo > 0) compare(nextTo-1, nextTo, dir*-1);
        }
      }else if(dir == 1){
        if(arr[nextTo].get(2).equals(arr[cur].get(7)) == false){
          updateArr(nextTo, dir*-1);
          if(nextTo > 0) compare(nextTo-1, nextTo, dir*-1);
        }
      }
    }
  }

  static void updateArr(int order, int dir){ // 여기서는 배열 값 이동만
    if(dir == 1){
      int tmp = arr[order].get(7);
      arr[order].remove(7);
      arr[order].add(0,tmp);
    }else if(dir == -1){
      int tmp = arr[order].get(0);
      arr[order].remove(0);
      arr[order].add(tmp);      
    }
  }
}
