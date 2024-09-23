import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];

            if (order.equals("add")) {
                int num = Integer.parseInt(input[1]);
                list.add(num);
            } else if (order.equals("remove")) {
                int num = Integer.parseInt(input[1]);
                if (list.contains(num))
                    list.remove(Integer.valueOf(num));
            } else if (order.equals("check")) {
                int num = Integer.parseInt(input[1]);
                if (list.contains(num))
                    bw.write("1\n");
                else
                    bw.write("0\n");
            } else if (order.equals("toggle")) {
                int num = Integer.parseInt(input[1]);
                if (list.contains(num))
                    list.remove(Integer.valueOf(num));
                else
                    list.add(num);
            } else if (order.equals("all")) {
                list.clear();
                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }
                Collections.sort(list);
            } else if (order.equals("empty")) {
                list.clear();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
