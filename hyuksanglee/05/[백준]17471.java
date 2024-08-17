package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Beakjoon17471 {

	static int N; // 선거구 개수
	static int min; // 최솟값
	static boolean[] isSelected; // 방문 여부
	static ArrayList<Integer> aSite; 	// a구역
	static ArrayList<Integer> bSite;	// b구역
	static int[][] arr;	// 선거구 구역 정보 담는 배열
	static int[] parents;	// 연결된 몇가지 인지 확인하는 배열
	static int[] people;	// 인원담는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		people = new int[N + 1]; // 선거구에 인원을 담는 배열
		arr = new int[N + 1][N + 1]; // 선거구끼리 연결 표시하는 배열
		isSelected = new boolean[N + 1];
		parents = new int[N + 1];
		min = Integer.MAX_VALUE;

		String[] input = in.readLine().split(" ");

		// 각 선거구에 인원 배열에 담기
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(input[i - 1]); // 인덱스와 선거구지역에 일치하게 설정
		}

		// 해당 선거구에 인접 여부
		for (int i = 1; i <= N; i++) {
			input = in.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			for (int j = 1; j <= n; j++) {
				arr[i][Integer.parseInt(input[j])] = arr[Integer.parseInt(input[j])][i] = 1;
			}

		}

		// 부분집합을 이용하여 선거구 나누기
		subset(1);
		
		
		if(min == Integer.MAX_VALUE) { // 두 선거구로 나눌수 없을경우
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		

//		for(int i = 0; i<=6; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

	}

	// 부분집합을 이용하여 선거구 나누기
	public static void subset(int count) {
		if (count == N + 1) {
			aSite = new ArrayList<>();
			bSite = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) { // A구역
					aSite.add(i);
				} else { // B구역
					bSite.add(i);
				}
			}

			
			makeSet();	// 트리로 묶기전에 초기화
			
			// 부분집합으로 나눈 a구역, b구역을 연결상태 확인후 연결해주기
			connect(aSite);
			connect(bSite);
			
			// 모든 구역에 대해 find 수행하여 path compression 한다. (최상단 부모 확인을 위해)
			for (int i = 0; i <= N; i++) {
				findSet(i);
			}
			
			// 연결 두개인지 확인하기 위해 정렬
			Arrays.sort(parents);
			
			// 선거구가 두개인지 확인
			int check = 1;
			for(int i = 1;i < N; i++) {
				if(parents[i] !=parents[i+1]) {
					check++;
				}
			}
			
			// 인원별 두 선거구 차이를 구해서 최솟값 비교하여 갱신해준다.
			if(check ==2) {
				int a = 0;
				int b =0;
				for(int n : aSite) {
					a+=people[n];				
					}
				for(int n : bSite) {
					b+=people[n];				
					}
				
				if(min>Math.abs(a-b)){
					min = Math.abs(a-b);
				}
			}
			
			return;
		}

		isSelected[count] = true;
		subset(count + 1);
		isSelected[count] = false;
		subset(count + 1);
	}

	
	// 구역안에 있는 숫자들이 연결 되어있는지 확인후 연결 해주기
	public static void connect(ArrayList<Integer> site) {

		for (int i = 0; i < site.size() - 1; i++) {
			for (int j = i + 1; j < site.size(); j++) {
				if (arr[site.get(i)][site.get(j)] == 1) { // 연결되어있는지 확인
					union(site.get(i), site.get(j)); // 연결해주기
				}
			}
		}
	}

	// 트리 초기화
	private static void makeSet() {
		parents = new int[N + 1]; // 선거구 (1번부터 사용)
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}

	// 트리에 최상위 찾기
	private static int findSet(int a) { // a의 대표자 찾기

		if (parents[a] == a) {
			return a;
		}

		return parents[a] = findSet(parents[a]); // 우리의 대표자를 나의 부모로 .. : path compression
	}

	// 연결해주기
	private static boolean union(int a, int b) { // 리턴 값 : true ==> union 성공
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}

}
