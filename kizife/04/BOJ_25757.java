import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BOJ_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String game = input[1];
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            set.add(name);
        }
        
        int num = set.size();
        
        if (game.equals("Y")) {
            bw.write(num + "\n");
        } else if (game.equals("F")) {
            bw.write((num / 2) + "\n");
        } else if (game.equals("O")) {
            bw.write((num / 3) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
