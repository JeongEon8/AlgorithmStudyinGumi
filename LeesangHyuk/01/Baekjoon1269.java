import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baekjoon1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: A와 B의 크기
        String[] input = in.readLine().split(" ");
        int An = Integer.parseInt(input[0]); // A의 크기
        int Bn = Integer.parseInt(input[1]); // B의 크기

        // A 집합 입력
        Set<Integer> A = new HashSet<>();
        input = in.readLine().split(" ");
        for (int i = 0; i < An; i++) {
            A.add(Integer.parseInt(input[i]));
        }

        // B 집합 입력
        Set<Integer> B = new HashSet<>();
        input = in.readLine().split(" ");
        for (int i = 0; i < Bn; i++) {
            B.add(Integer.parseInt(input[i]));
        }

        // 대칭 차집합 계산
        int symmetricDifference = 0;

        // A에만 있는 원소
        for (int num : A) {
            if (!B.contains(num)) {
                symmetricDifference++;
            }
        }

        // B에만 있는 원소
        for (int num : B) {
            if (!A.contains(num)) {
                symmetricDifference++;
            }
        }

        // 결과 출력
        System.out.println(symmetricDifference);
    }
}
