import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); 
        int m = Integer.parseInt(firstLine[1]); 
        int q = Integer.parseInt(firstLine[2]); 

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int num = Integer.parseInt(query[0]);

            if (num == 1) {
                int a = Integer.parseInt(query[1]) ; 
                int b = Integer.parseInt(query[2]) ; 
                
                // 행 교환
                if (a >= 0 && a < n && b >= 0 && b < n) {
                    int[] temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                }
            } else if (num == 0) {
                int a = Integer.parseInt(query[1]); 
                int b = Integer.parseInt(query[2]);
                int k = Integer.parseInt(query[3]);

                if (a >= 0 && a < n && b >= 0 && b < m) {
                    arr[a][b] = k;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush(); 
        bw.close(); 
        br.close();
    }
}
