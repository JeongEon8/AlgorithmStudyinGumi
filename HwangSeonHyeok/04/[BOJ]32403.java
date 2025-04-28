import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int t = Integer.parseInt(split[1]);
        int[] lights = new int[n];
        split = in.readLine().split(" ");
        for(int i = 0; i<n; i++){
            lights[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(lights);
        List<Integer> divisor = new ArrayList();
        for(int i = 1;i<=t/2;i++){
            if(t%i==0) {
                divisor.add(i);
            }
        }
        divisor.add(t);
        int dIdx = 0;
        int lIdx = 0;
        int ans = 0;
        while(lIdx<n){
            if(dIdx>=divisor.size()-1){
                ans += Math.abs(divisor.get(divisor.size()-1)-lights[lIdx]);
            }else{
                int min = Math.min(Math.abs(divisor.get(dIdx)-lights[lIdx]),10000);
                while(dIdx<divisor.size()-1&&min>Math.abs(divisor.get(dIdx+1)-lights[lIdx])){
                    dIdx++;
                    min = Math.abs(divisor.get(dIdx)-lights[lIdx]);
                }
                ans+= Math.min(min,Math.abs(divisor.get(divisor.size()-1)-lights[lIdx]));
            }
            lIdx++;
        }
        System.out.println(ans);

    }
}
