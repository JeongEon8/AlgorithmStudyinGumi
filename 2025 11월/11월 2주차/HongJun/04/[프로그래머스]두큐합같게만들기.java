import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;

        // 두 큐를 합친 리스트
        List<Integer> dq = new ArrayList<>();

        for (int num : queue1) {
            dq.add(num);
        }
        for (int num : queue2) {
            dq.add(num);
        }

        long sum1 = 0;
        for (int num : queue1) {
            sum1 += num;
        }

        long sum2 = 0;
        for (int num : queue2) {
            sum2 += num;
        }

        // 두 큐의 합의 절반
        long half = (sum1 + sum2) / 2;
        // 합이 홀수인 경우는 불가능
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        long total = sum1;
        int st = 0;
        int en = N;
        int cnt = 0;

         // 투포인터 사용
        while (st < en) {
            // en이 끝까지 갔는데 합이 안맞는 경우는 불가능
            if (en == 2 * N - 1 && total < half) {
                return -1;
            }

            // 합이 절반과 같은 경우
            if (total == half) {
                break;
            }
            else if (total < half) {
                total += dq.get(en); // dq에서 en 인덱스 값 가져오기
                en++;
            }
            // 크면 start 포인터 한 칸 이동
            else {
                total -= dq.get(st); // dq에서 첫 번째 값 빼기
                st++;
            }

            // 이동 횟수 +1
            cnt++;
        }

        return cnt;
    }
}