import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int wordsNum = Integer.parseInt(st.nextToken());
        int minLength = Integer.parseInt(st.nextToken());
        String word;
        Map<String, Integer> words = new HashMap<>();
        for (int i = 0; i < wordsNum; i++) {
            word = br.readLine();
            if (word.length() < minLength) continue;
            Integer tmp = words.get(word);
            if (tmp == null) {
                words.put(word, 1);
            } else {
                words.put(word, tmp + 1);
            }
        }
        List<Word> wordList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            wordList.add(new Word(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordList);
        StringBuilder sb = new StringBuilder();
        for (Word now : wordList) {
            sb.append(now.word);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

class Word implements Comparable<Word> {
    int count;
    String word;

    Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int compareTo(Word word) {
        if (this.count > word.count) {
            return -1;
        } else if (this.count < word.count) {
            return 1;
        }

        if (this.word.length() > word.word.length()) {
            return -1;
        } else if (this.word.length() < word.word.length()) {
            return 1;
        }
        return this.word.compareTo(word.word);
    }
}
