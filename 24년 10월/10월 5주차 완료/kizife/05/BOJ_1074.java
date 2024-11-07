import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int result = cal(n, r, c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    private static int cal(int n, int r, int c) {
        int size = (int) Math.pow(2, n); //z모양 전체 길이
        int result = 0; //결과를 저장할 변수

        //z모양이 1보다 크다면 반복.
        while (size > 1) {
            size /= 2; //크기를 반으로 줄임 (몇사분면인지 확인하려고)

            if (r < size && c < size) { //1사분면
                result += 0;
            } else if (r < size) { //2사분면
                result += size * size; //1사분면 크기만큼 더해줌
                c -= size; //열을 반으로 줄임
            } else if (c < size) { //3사분면
                result += size * size * 2; //1+2사분면 크기만큼 더해줌
                r -= size; // 행을 반으로 줄임
            } else { //4사분면
                result += size * size * 3; //1+2+3사분면 크기만큼 더해줌
                r -= size; //행,
                c -= size; //열을 반으로 줄임
            }
        }
        //여기까지...범위가 많이 좁혀졌을 거임!! 
        if (r == 0 && c == 0)
            return result;
        if (r == 0 && c == 1)
            return result + 1;
        if (r == 1 && c == 0)
            return result + 2;
        if (r == 1 && c == 1)
            return result + 3;

        return result;
    }
}
