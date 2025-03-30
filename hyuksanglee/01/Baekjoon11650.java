package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point implements Comparable<Point> {
    int x, y;
    
    
    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

public class Baekjoon11650 {
	
	

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		List<Point> list = new ArrayList<>();
		
		for (int i = 0; i<N; i++) {
			String[] input = in.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			Point p = new Point();
			p.x=x;
			p.y=y;
			
			list.add(p);
		}
		Collections.sort(list);
		
		for (Point l : list) {
            System.out.println(l.x + " " + l.y);
        }
		

	}

}
