package programmers;

import java.util.*;

public class Pragrammers_테이블해시함수 {

	public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (a, b) -> {
            if (a[col-1] != b[col-1]) return a[col-1] - b[col-1];
            return b[0] - a[0]; 
        });

        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int[] row = data[i-1];
            int sum = 0;
            for (int v : row) {
                sum += (v % i);
            }
            answer ^= sum;
        }

        return answer;
    }

}
