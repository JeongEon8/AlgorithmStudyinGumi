import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int heightA = Integer.parseInt(st.nextToken());
        int widthA = Integer.parseInt(st.nextToken());
        int[][] list = new int[height + heightA][widthA + width];
        for (int i = 0; i < height + heightA; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width + widthA; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i >= heightA && j >= widthA) {
                    list[i][j]=list[i][j] - list[i - heightA][j - widthA];
                }
                sb.append(list[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
