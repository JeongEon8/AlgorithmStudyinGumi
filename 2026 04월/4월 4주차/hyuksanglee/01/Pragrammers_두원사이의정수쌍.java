package programmers;

public class Pragrammers_두원사이의정수쌍 {

	public long solution(int r1, int r2) {
        long answer = 0;
        
        for (long x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt((long)r2 * r2 - x * x));
            
            long minY = 0;
            if (x < r1) {
                minY = (long) Math.ceil(Math.sqrt((long)r1 * r1 - x * x));
            }
            
            answer += (maxY - minY + 1);
        }
        
        return answer * 4;
    }

}
