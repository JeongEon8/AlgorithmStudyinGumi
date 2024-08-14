import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int w = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int p = Integer.parseInt(st2.nextToken());
        int q = Integer.parseInt(st2.nextToken());

        int t = Integer.parseInt(bf.readLine());

        p = p + t;
        q = q + t;

       int countX = p/w; //몇 번 왕복하는 중인지
       int countY = q/h;
       
       if (countX%2 == 0) {
           p = p%w;
       } else {
           p = w - (p%w);
       }
       
       if (countY%2 ==0) {
           q = q%h;
       } else {
           q = h - (q%h);
       }
       
       StringBuilder sb = new StringBuilder();
       sb.append(p).append(" ").append(q);
       System.out.println(sb);
       
    }

}
