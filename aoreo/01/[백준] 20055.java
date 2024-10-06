import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(bf.readLine());

    ArrayList<Lane> arr = new ArrayList<>();

    for (int i = 0; i < 2*N; i++) {
      arr.add(new Lane(Integer.parseInt(st.nextToken()),false));
    }
    int broken = 0;
    int robots = 0;
    while(broken < K){
      broken = 0;
      robots += 1;

      Lane tmp = arr.get(2*N-1);
      arr.remove(2*N-1);
      arr.add(0, tmp); // 회전

      if(arr.get(N-1).hasRobot == true) {
        Lane l = arr.get(N-1);
        l.hasRobot = false;
        arr.set(N-1, l);
      }
      for (int i = N-2; i >= 0; i--) { // 제일 먼저 들어간 로봇부터 움직이기(N-1칸의 로봇은 내려갔을테니 N-2부터 확인)
        if(arr.get(i).hasRobot == true){
          if(arr.get(i+1).durability > 0 && arr.get(i+1).hasRobot == false) {
            Lane l2 = arr.get(i+1);
            Lane l1 = arr.get(i);
            l2.durability -= 1;
            l2.hasRobot = true;
            l1.hasRobot = false;
            arr.set(i+1, l2);
            arr.set(i,l1);
            if((i+1) == (N-1)) {
              Lane l = arr.get(N-1);
              l.hasRobot = false;
              arr.set(N-1, l);
            }
          }
        }
      } // 1~N-1확인

      if(arr.get(0).durability > 0 && arr.get(0).hasRobot == false){
        Lane l = arr.get(0);
        l.durability -= 1;
        l.hasRobot = true;
        arr.set(0, l);
      } // 로봇 올리기

      for (int i = 0; i < 2*N; i++) {
        if(arr.get(i).durability == 0) broken += 1;
      }
    }
    System.out.println(robots);
  }

  static class Lane{
    int durability;
    boolean hasRobot;

    public Lane(int durability, boolean hasRobot){
      this.durability = durability;
      this.hasRobot = hasRobot;
    }

        @Override
        public String toString() {
            return durability+" "+hasRobot+" ";
        }
  }
}

// N-1에 도달하면 로봇이 내려짐
// 0으로 로봇이 올라감
// 로봇이 올라가거나 이동하면 내구도 1 감소 -> 내구도 1 이상인 경우에만 작동가능
