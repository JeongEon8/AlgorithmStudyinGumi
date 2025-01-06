import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Box implements Comparable<Box> {
        int x, y;

        public Box(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Box o) {
            return (o.x * o.y) - (this.x * this.y);
        }

        public int getSize() {
            return x * y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] split = in.readLine().split(" ");
            int j = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            Box[] boxList = new Box[n];
            for (int i = 0; i < n; i++) {
                split = in.readLine().split(" ");
                int r = Integer.parseInt(split[0]);
                int c = Integer.parseInt(split[1]);
                boxList[i] = new Box(r, c);
            }
            Arrays.sort(boxList);
            int ans = 0;
            for (Box b : boxList) {
                j -= b.getSize();
                ans++;
                if (j <= 0)
                    break;
            }
            System.out.println(ans);

        }

    }

}