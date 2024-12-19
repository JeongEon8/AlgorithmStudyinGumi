import java.util.Scanner;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String bomb = sc.nextLine();

        String answer = explode(input, bomb);

        if (answer.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }
    }

    private static String explode(String input, String bomb) {
        Stack<Character> word = new Stack<>();
        int bombLength = bomb.length();

        for (int i = 0; i < input.length(); i++) {
            word.push(input.charAt(i)); //한글자씩 추가해줌

            if (word.size() >= bombLength) {
                boolean match = true;

                //스택에 저장된 단어 끝부분 / 폭탄 비교
                for (int j = 0; j < bombLength; j++) {
                    if (word.get(word.size() - bombLength + j) != bomb.charAt(j)) {
                        match = false; //일치하지 아니하면 폭탄 없으므로 False처리
                        break;
                    }
                }

                //폭탄 있으면 해당 부분 없앰
                if (match) {
                    for (int j = 0; j < bombLength; j++) {
                        word.pop();
                    }
                }
            }
        }

        //결과 문자열 만들기
        StringBuilder answer = new StringBuilder();
        for (char c : word) {
            answer.append(c);
        }

        return answer.toString();
    }
}
