import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int L,C;
    static char[] alph;
    static StringBuffer sb = new StringBuffer();
    static Set<String> set = new HashSet<>();

    static boolean isAble(String str){
        int cnt = 0;

        for(int i = 0; i<str.length();i++){
            if(str.charAt(i)=='a' ||
                    str.charAt(i)=='e' ||
                    str.charAt(i)=='i' ||
                    str.charAt(i)=='o' ||
                    str.charAt(i)=='u'
            ){
                cnt++;
            }
        }

        if(cnt==0||str.length()-cnt<2) {
            return false;
        }
        return true;
    }

    static void solve(int idx, String temp){
        if(temp.length()==L){
            if(isAble(temp)) {
                if (set.contains(temp)) {
                    return;
                }
                set.add(temp);
                sb.append(temp).append("\n");
            }
            return;
        }
        if(L-temp.length()>C-idx){
            return;
        }
        for(int i = idx; i<C;i++){
            solve(i+1,temp+alph[i]);
            solve(i+1,temp);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        alph = new char[C];
        split = in.readLine().split(" ");
        for(int i = 0; i<C;i++){
            alph[i] = split[i].charAt(0);
        }
        Arrays.sort(alph);
        solve(0,"");
        System.out.println(sb);
    }
}