import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(in.readLine());
        for(int tc = 0; tc<t;tc++){
            String[] split = in.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            TreeSet<Integer> a = new TreeSet<>();
            TreeSet<Integer> b = new TreeSet<>();
            split = in.readLine().split(" ");
            for(int i = 0; i<n;i++){
                a.add(Integer.parseInt(split[i]));
            }
            split = in.readLine().split(" ");
            for(int i = 0; i<m;i++){
                b.add(Integer.parseInt(split[i]));
            }
            long ans = 0;
            for(int aNum:a){
                Integer ceil = b.ceiling(aNum);
                if(ceil==null){
                    ceil = (int)2e9;
                }
                Integer floor = b.floor(aNum);
                if(floor==null){
                    floor = (int)-1e9;
                }
                if(aNum-floor<=ceil-aNum){
                    ans+=floor;
                }else{
                    ans+=ceil;
                }
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}