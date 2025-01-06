package beakjoon;

import java.io.*;

public class Sw4008 {

	/*
	 * 1. 연산자 배열에 완전 탐색을 한다. 1. 배열에서 연산자 하나씩 들고 와서 계산을 한다 2. 수식에 개수 만큼 계산을 하고 전에
	 * 계산했던 max와 min을 비교해서 값을 해당 값이랑 변경해준다 2. 완전 탐색으로 구한 max와 min의 차이를 구한다.
	 */

	static int[] operator; // 연산자 배열
	static int[] num; // 숫자 배열

	static int N, max, min, total; // 변수

	public static void quest(int count) {
		if (count == N - 1) { // 연산자 수만큼 계산 다 했을때
			if(max<total) {
				max=total;
			}
			if(min> total) {
				min = total;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int tmp = total;
			if (operator[i] != 0) {
				if (i == 0) { // 더하기
					operator[i] -= 1;
					total += num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
				}else if(i == 1) { // 빼기
					operator[i] -= 1;
					total -= num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
				}else if(i == 2) { // 곱하기
					operator[i] -= 1;
					total *= num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
					
				}else if(i == 3) { // 나누기
					operator[i] -= 1;
					total /= num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
				}

			}
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine()); // 테스트 케이스의 개수 받기

		for (int t = 1; t <= T; t++) { // 테스트 케이스 만큼 돌기

			N = Integer.parseInt(in.readLine()); // 정수의 개수 받기
			operator = new int[4]; // 숫자 배열
			num = new int[N]; // 정수를 담는 배열 초기화

			// 연산자의 개수 받아서 배열에 담기
			String[] input = in.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(input[i]);
			}

			// 숫자를 입력받아 배열에 담기
			input = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(input[i]);
			}

			min = Integer.MAX_VALUE; // 최솟값을 담는 변수
			max = Integer.MIN_VALUE; // 최댓값을 담는 변수
			total = num[0];
			quest(0);

			System.out.println("#" + t + " " + (max - min));

		}

	}
}
