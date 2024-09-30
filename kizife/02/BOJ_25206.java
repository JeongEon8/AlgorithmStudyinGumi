import java.util.Scanner;

public class BOJ_25206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Double numSum = 0.0;
		Double scoreSum = 0.0;

		for (int i = 0; i < 20; i++) {
			String subject = sc.next();
			Double num = sc.nextDouble();
			String grade = sc.next();
			Double score = 0.0;

			if (grade.equals("A+")) {
				score = 4.5;
			} else if (grade.equals("A0")) {
				score = 4.0;
			} else if (grade.equals("B+")) {
				score = 3.5;
			} else if (grade.equals("B0")) {
				score = 3.0;
			} else if (grade.equals("C+")) {
				score = 2.5;
			} else if (grade.equals("C0")) {
				score = 2.0;
			} else if (grade.equals("D+")) {
				score = 1.5;
			} else if (grade.equals("D0")) {
				score = 1.0;
			} else if (grade.equals("F")) {
				score = 0.0;
			} else if (grade.equals("P")) {
				num = 0.0;
				score = 0.0;
			}

			numSum = numSum + num; //학점 가중치 합
			scoreSum = scoreSum + (num * score); //학점*과목평점 합 
			
			
		}
		
		System.out.println(scoreSum / numSum);
		
	}

}
