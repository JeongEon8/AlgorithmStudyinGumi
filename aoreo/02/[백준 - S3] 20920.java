import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Word> pQueue = new PriorityQueue<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String word = st.nextToken();
            if (word.length() >= M) {
                if (hashMap.get(word) != null) {
                    hashMap.put(word, hashMap.get(word) + 1); 
                }else {
                    hashMap.put(word, 1);
                }
            }
        }

        for (String ele : hashMap.keySet()) {
            pQueue.add(new Word(ele, hashMap.get(ele)));
        }

        while(pQueue.size() > 0) {
            sb.append(pQueue.poll().name+"\n");
        }

        System.out.println(sb);
    }

    static class Word implements Comparable<Word> {

        int cnt;
        String name;

        Word(String name, int cnt) {
            this.cnt = cnt;
            this.name = name;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt > o.cnt) {
                return -1; 
            }else if (this.cnt == o.cnt) {
                if(this.name.length() > o.name.length()) return -1;
                else if(this.name.length() == o.name.length()) {
                    if(this.name.compareTo(o.name) < 0) return -1;
                }
            }
            return 1;
        }
    }
}
