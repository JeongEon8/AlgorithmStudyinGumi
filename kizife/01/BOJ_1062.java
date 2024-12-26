import java.util.*;

public class BOJ_1062 {
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] words = new String[n]; //단어 저장
        ArrayList<Character> list = new ArrayList<>(); //문자 저장

        //기본적으로 배우는 문자들 먼저 추가
        HashSet<Character> learned = new HashSet<>(Arrays.asList('a', 'n', 't', 'c', 'i'));

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
            for (char ch : words[i].toCharArray()) {
                if (!learned.contains(ch)) { //기본문자 제외
                    if (!list.contains(ch)) { //중복되지 아니하면
                        list.add(ch); //나머지 문자를 저장
                    }
                }
            }
        }

        //k<5면 아무것도 읽을 수 ㄴㄴ
        if (k < 5) {
            System.out.println(0);
            return;
        }

        //배워야 하는 문자 수(list.size()) <= 배울수있는 문자수(k-5)면 다 읽을 수 있음
        if (list.size() <= k - 5) {
            System.out.println(n);
            return;
        }

        // 조합 생성 및 최대 읽을 수 있는 단어 계산
        combine(list, learned, words, 0, 0, k - 5);
        System.out.println(max);
    }

    static void combine(ArrayList<Character> list, HashSet<Character> learned, String[] words, int index, int depth, int maxDepth) {
        //depth는 새로 배운 문자 수, maxDepth는 배울 수 있는 최대 문자 수

        //두 수가 같아지면 읽을 수 있는 단어 개수 구함 
        if (depth == maxDepth) {
            max = Math.max(max, countWords(words, learned));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            learned.add(list.get(i)); //순서대로 하나씩 배우기
            combine(list, learned, words, i + 1, depth + 1, maxDepth);
            learned.remove(list.get(i));
        }
    }

    static int countWords(String[] words, HashSet<Character> learned) {
        int count = 0;
        for (String word : words) {
            boolean readable = true;
            for (char ch : word.toCharArray()) {
                if (!learned.contains(ch)) { //배우지 않은 문자면
                    readable = false; //버린다...
                    break;
                }
            }
            if (readable) count++;
        }
        return count;
    }
}
