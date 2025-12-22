import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[tc];

        for(int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        
        for(int i = 0; i < tc; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
