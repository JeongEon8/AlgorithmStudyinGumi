import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] customers = new int[n];
        split = in.readLine().split(" ");
        for(int i = 0; i<n;i++){
            customers[i] = Integer.parseInt(split[i]);
        }
        int closeTime = customers[n-1]+1;
        int lastCoffeeTime = 0;
        boolean[] isAct = new boolean[closeTime];
        customerLoop:for(int i = 0; i<n; i++){
            if(customers[i]<i*3+2){
                System.out.println("fail");
                return;
            }
            int startTime = Math.max(customers[i]-m,lastCoffeeTime);
            isAct[customers[i]] = true;
            for(int j = startTime; j<customers[i]; j++){
                if(!isAct[j]){
                    isAct[j] = true;
                    lastCoffeeTime = j;
                    continue customerLoop;
                }
            }
            System.out.println("fail");
            return;
        }
        System.out.println("success");
    }
}