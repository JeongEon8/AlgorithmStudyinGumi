import java.util.*;

public class BOJ_1501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        //사전단어
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String reWord = separate(word);
            dictionary.put(reWord, dictionary.getOrDefault(reWord, 0) + 1);
        }

        int m = sc.nextInt();
        sc.nextLine(); 

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String sentence = sc.nextLine();
            String[] words = sentence.split(" "); //단어별로 분리
            int ways = 1; // 경우의 수 계산 (곱셈)

            for (String word : words) {
                String reWord = separate(word);
                if (dictionary.containsKey(reWord)) {
                    ways *= dictionary.get(reWord); //해석 가능한 단어의 수 곱하기
                } else {
                    ways = 0; //해석 불가능할 경우
                    break;
                }
            }

            answer.append(ways).append("\n");
        }

        System.out.print(answer);
    }

    //단어를 분리하기 
    private static String separate(String word) {
        if (word.length() <= 2) {
            return word; 
        }
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        char[] middle = word.substring(1, word.length() - 1).toCharArray();
        Arrays.sort(middle);
        return first + new String(middle) + last;
    }
}
