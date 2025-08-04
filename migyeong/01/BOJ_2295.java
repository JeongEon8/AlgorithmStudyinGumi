import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        List<Integer> sumList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            nums[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(nums);

        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++)
                sumList.add(nums[i] + nums[j]); // 두 수의 합
        Collections.sort(sumList);

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int target = nums[i] - nums[j]; // 큰 수에서 하나를 뺀 수가 
                if(Collections.binarySearch(sumList, target) >= 0) { // sumList 안에 있는가?
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }
}
