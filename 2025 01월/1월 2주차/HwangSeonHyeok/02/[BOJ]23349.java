import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    static int n, cnt, ansStart,ansEnd;
    static String ansPlace;
    static TreeMap<String,Integer> map = new TreeMap<>();
    static Set<String> students = new HashSet<>();
    static int[][] times = new int[10][50001];


    static void solve(){
        int max = 0;
        for(String key: map.keySet()){
            int idx = map.get(key);
            int current = 0;
            boolean isMax = false;
            for(int i = 0; i<=50000;i++){
                if(times[idx][i]==0)continue;
                current+=times[idx][i];
                if(current>max){
                    ansPlace = key;
                    ansStart = i;
                    max=current;
                    isMax = true;
                }
                if(isMax&&current<max){
                    ansEnd = i;
                    isMax = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        for(int i = 0; i<n;i++){
            String[] split = in.readLine().split(" ");
            String student = split[0];
            if(!students.contains(student)){
                students.add(student);
                String place = split[1];
                int start = Integer.parseInt(split[2]);
                int end = Integer.parseInt(split[3]);
                if(!map.containsKey(place)){
                    map.put(place,cnt++);
                }
                int index = map.get(place);
                times[index][start]++;
                times[index][end]--;
            }
        }
        solve();
        System.out.println(ansPlace+" "+ansStart+" "+ansEnd);

    }
}