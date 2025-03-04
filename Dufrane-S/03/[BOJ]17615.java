import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String balls = br.readLine();
		List<Integer>reds = new ArrayList<>();
		List<Integer>blues = new ArrayList<>();
		char now = balls.charAt(0);
		int count=0;
		for(int i=0; i<balls.length(); i++) {
			if(balls.charAt(i)==now) {
				count++;
			} else {
				if(now=='R') {
					reds.add(count);
				} else {
					blues.add(count);
				}
				now=balls.charAt(i);
				count=1;
			}
		}
		if(now=='R') {
			reds.add(count);
		} else {
			blues.add(count);
		}
		int redSum=0;
		for(int red : reds) {
			redSum+=red;
		}
		int blueSum=0;
		for(int blue: blues) {
			blueSum+=blue;
		}
		int answer = Integer.MAX_VALUE;
		int tmp=0;
		
		if(balls.charAt(0)=='R') {
			for(int i=1; i<reds.size(); i++) {
				tmp+=reds.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		if(balls.charAt(0)=='B') {
			for(int i=1; i<blues.size(); i++) {
				tmp+=blues.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		if(balls.charAt(balls.length()-1)=='B') {
			for(int i=0; i<blues.size()-1; i++) {
				tmp+=blues.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		if(balls.charAt(balls.length()-1)=='R') {
			for(int i=0; i<reds.size()-1; i++) {
				tmp+=reds.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		for(int red:reds) {
			tmp+=red;
		}
		if(tmp<answer)answer=tmp;
		tmp=0;
		
		for(int blue:blues) {
			tmp+=blue;
		}
		if(tmp<answer)answer=tmp;
		tmp=0;
		
		System.out.println(answer);
	}
}
