import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []prev = new int[1];
        
        prev[0]=Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++){
            int []now = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                now[j]=Integer.parseInt(st.nextToken());
            }
            now[0]+=prev[0];
            now[i]+=prev[i-1];
            for(int j=1;j<i;j++){
                if(prev[j-1]>prev[j]){
                    now[j]+=prev[j-1];
                }else{
                    now[j]+=prev[j];
                }
            }
            prev=now;
        }
        int answer=0;
        for(int i=0;i<N;i++){
            if(prev[i]>answer)answer=prev[i];
        }
        System.out.println(answer);
    }
}
