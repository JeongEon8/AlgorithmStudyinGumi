import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        
        
        int[][] arr = new int[100][100];
        int count = 0; //방문하면 1로 처리
        

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2  = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    if(x1<= j && j <x2 && y1<=k && k<y2) {
                        arr[j][k] = 1;
                    }
                } 
            }
        }    
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] ==1) {
                    count++;
                }
            }
        }
        
        System.out.println(count);

    }

}
