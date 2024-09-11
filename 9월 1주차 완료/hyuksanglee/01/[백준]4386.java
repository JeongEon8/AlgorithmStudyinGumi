package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beakjoon4386 {

	static boolean[] isSelected;
	static float[] minD;
	static int N;
	static float[][] distance;
	static float result;
	
	static int INF = Integer.MAX_VALUE; // 최댓값 변수

	// 별의 좌표를 담는 클래스
	public static class Star {
		float x;
		float y;

	}

	// 모든 별을 최소로 연결하기 위해 mst사용
	public static void mst(int n) {
		int index = 0;
		float min = INF;
		
		for (int i = 0; i < N; i++) {
			if (n != i) {
				if(isSelected[i]==false) {
					if( minD[i] > distance[n][i]) {
						minD[i]=distance[n][i];
					}
					if(min>minD[i]) {
						min = minD[i];
						index = i;
					}
				}
				
			}
		}
		if(index !=0) {
			isSelected[index]= true;
			result+=minD[index];
			mst(index);
		}
		
	
	}

	// 별과 별 사이의 거리를 구하는 식
	public static float math(float a, float b) {
		return (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine()); // 별의 개수 n

		ArrayList<Star> stars = new ArrayList<>(); // 별들의 정보를 담는 리스트

		distance = new float[N][N]; // 별들의 연결 거리

		isSelected = new boolean[N]; // 방문 체크하는 배열 초기화

		minD = new float[N]; // 최소거리 저장하는 배열 초기화

		

		for (int i = 0; i < N; i++) {
			minD[i] = INF;
		}

		// 각줄의 별의 정보를 리스트에 담기
		for (int i = 0; i < N; i++) {
			String[] input = in.readLine().split(" ");

			Star star = new Star();

			star.x = Float.parseFloat(input[0]);
			star.y = Float.parseFloat(input[1]);

			stars.add(star);

		}

		// 각별들의 거리를 계산해서 리스트에 담기
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				float dx = Math.abs(stars.get(i).x - stars.get(j).x);
				float dy = Math.abs(stars.get(i).y - stars.get(j).y);
				float dis = math(dx, dy);
				distance[i][j] = dis;
				distance[j][i] = dis;
			}
		}

		float[] constellation = new float[N]; // 별들의 최소 길이
		result=0;
		isSelected[0]=true;
		mst(0);
		double result2 = Math.round(result * 100) / 100.0; 
		System.out.println(result2);

//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(distance[i]));
//		}

	}
}
