import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Item implements Comparable<Item> {
        int a, b, diff;

        public Item(int a, int b) {
            super();
            this.a = a;
            this.b = b;
            this.diff = a - b;
        }

        @Override
        public int compareTo(Item o) {
            return (int) (this.diff - o.diff);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int a = Integer.parseInt(split[1]);
        int b = Integer.parseInt(split[2]);
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            split = in.readLine().split(" ");
            items[i] = new Item(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        Arrays.sort(items);
        long ans = 0;
        for (int i = 0; i < a; i++) {
            ans += items[i].a;
        }
        for (int i = a; i < n; i++) {
            ans += items[i].b;
        }
        System.out.println(ans);
    }

}