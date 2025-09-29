import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Room> list = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int stTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            list.add(new Room(stTime, endTime));
        }

        Collections.sort(list);
        int lastReserveEt = -1;

        for (int i = 0; i < N; i++) {
            Room room = list.get(i);
            if(room.st >= lastReserveEt) {
                answer++;
                lastReserveEt = room.et;
            }
        }

        System.out.println(answer);

    }

    static class Room implements Comparable<Room> {

        int st;
        int et;

        public Room(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Room room) {
            if(this.et < room.et) return -1;
            else if(this.et == room.et && this.st < room.st) return -1;
            else return 1;
        }
    }
}
