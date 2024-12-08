import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{
    static int K;
    static char[] sel;
    static Set<Character>[] arr;
    static int maxVal = 0;
    static ArrayList<Character> alphabetList;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Set[N];
        Set<Character> alphabetSet = new HashSet<Character>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            arr[i] = new HashSet<Character>();
            for (int j = 0; j < str.length(); j++) {
                char character = str.charAt(j);
                if(character != 'a' && character != 'c' && character != 'i' && character != 'n' && character != 't') {
                    arr[i].add(character);
                    alphabetSet.add(character);
                }
            }
        }
        alphabetList = new ArrayList<>(alphabetSet);
        if(K < 5) {
            System.out.println(0);
        }else if(alphabetList.size() <= K-5) {
            System.out.println(N);
        }else{
            sel = new char[K-5];
            comb(0,0);
            System.out.println(maxVal);
        }

    }
    
    static void comb(int idx, int r){
        if(r == K-5){
            // 단어들 탐색하기
            search();
            return;
        }
        
        for (int i = idx; i < alphabetList.size(); i++) {
            sel[r] = alphabetList.get(i);
            comb(i+1, r+1);
        }
    }

    static void search(){
        int canLearn = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < sel.length; i++) {
            list.add(sel[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Character> tmp = new ArrayList<>(arr[i]);
            tmp.removeAll(list);
            if(tmp.size() == 0) {
                canLearn += 1;
            }
        }
        maxVal = Math.max(maxVal, canLearn);
    }
}
