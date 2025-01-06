package B_18_문자열_교집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = in.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Set<String> firstSet = new HashSet<>();
            int result = 0;

            // 첫 번째 문자열 리스트 삽입
            String[] firstInput = in.readLine().split(" ");
            for (String str : firstInput) {
                firstSet.add(str);
            }

            // 두 번째 문자열 리스트 탐색
            String[] secondInput = in.readLine().split(" ");
            for (String str : secondInput) {
                if (firstSet.contains(str)) {
                    result++;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
