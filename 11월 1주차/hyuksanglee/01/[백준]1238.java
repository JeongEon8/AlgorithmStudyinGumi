package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Baekjoon1238 {	
	
	public static int[][] map;
	public static int[] start;
	public static int[] end;
	public static int N,M,X;
	
	public static class Student{
		int current;
		int total;
	}
	
	
	public static void dijkstra(int n,  int sum) {
		Queue<Student> que = new ArrayDeque();
		Student student = new Student();
		student.current = n;
		student.total = sum;
		que.add(student);
		while(!que.isEmpty()) {
			Student cStudent = que.poll();
			int cn = cStudent.current;
			int ct = cStudent.total;
			
			for(int i =0; i<N; i++) {
				int total = sum+map[cn][i]+ct;
			
				if(map[cn][i]!=0 && start[i]>total) {
					student = new Student();
					student.current = i;
					student.total = total;
					que.add(student);
					start[i]=total;
				}
			}
		}
		
	}
	
	public static void rDijkstra(int n,  int sum) {
		Queue<Student> que = new ArrayDeque();
		Student student = new Student();
		student.current = n;
		student.total = sum;
		que.add(student);
		while(!que.isEmpty()) {
			Student cStudent = que.poll();
			int cn = cStudent.current;
			int ct = cStudent.total;
			
			for(int i =0; i<N; i++) {
				int total = sum+map[i][cn]+ct;
			
				if(map[i][cn]!=0 && end[i]>total) {
					student = new Student();
					student.current = i;
					student.total = total;
					que.add(student);
					end[i]=total;
				}
			}
		}
		
	}

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);	// 학생 수
		M = Integer.parseInt(input[1]);	// 도로의 수
		X = Integer.parseInt(input[2])-1;	// 걸리는 시간 
		
		map = new int[N][N];	// 길에 대한 정보를 담는 배열
		start = new int[N]; // 각 마을에서 x번 마을까지 도착하는 시간
		end = new int[N]; 	// x 마을에서 각 마을에 도착하는 시간
		
		// 최댓값으로 초기화
		for(int n =0; n<N; n++) {
			start[n] = Integer.MAX_VALUE;
			end[n] = Integer.MAX_VALUE;
			
		}
		
		for(int m = 0 ; m<M; m++) {
			input = in.readLine().split(" ");
			int A = Integer.parseInt(input[0])-1;
			int B = Integer.parseInt(input[1])-1;
			int time = Integer.parseInt(input[2]);
			map[A][B] = time;
		}
		
		dijkstra(X,0);
		rDijkstra(X,0);
		int max = 0;
		for(int n = 0; n<N; n++) {
			if(n==X) {
				continue;
			}
			int total = start[n]+end[n];
			if(max<total) {
				max = total;
			}
			
		}
		
//		for(int n = 0; n<N; n++) {
//			System.out.println(Arrays.toString(map[n]));
//		}
		
		System.out.println(max);
//			System.out.println(Arrays.toString(start));
//			System.out.println(Arrays.toString(end));
		
		
		
		
	}

}
