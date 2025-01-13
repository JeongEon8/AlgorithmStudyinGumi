import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Word> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();
            queue.add(new Word(tmp));
        }

        List<String> words = new ArrayList<>();
        while(queue.size() != 0) {
            Word word = queue.poll();
            if(words.contains(word.word) == false) {
                words.add(word.word);
                System.out.println(word.word);
            }
        }
    }

    static class Word implements Comparable<Word>{
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if(word.length() < o.word.length()) return -1;
            else if(word.length() > o.word.length()) return 1;
            else{
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) < o.word.charAt(i)) {
                        return -1;
                    }
                    else if(word.charAt(i) > o.word.charAt(i)) return 1;
                }
                return 0;
            }
        }
    }
}
