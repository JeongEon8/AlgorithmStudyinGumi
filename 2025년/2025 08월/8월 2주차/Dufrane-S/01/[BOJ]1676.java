import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        int answer = 0;
        while (i >= 5) {
            answer += i / 5;
            i /= 5;
        }
        System.out.println(answer);
    }
}
