import java.util.*;

class Solution {
    
    class Info{
        int head;
        int tail;
        int price;
        Info(int head, int tail, int price){
            this.head = head;
            this.tail = tail;
            this.price = price;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Info> [] list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList();
        }
        
        for(int i = 0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int price = road[i][2];
            
            list[a].add(new Info(a,b,price));
            list[b].add(new Info(b,a,price));
        }
        
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        
        int[] dst = new int[N+1];
        
        
        Arrays.fill(dst,Integer.MAX_VALUE);
        dst[1] = 0;
        dst[0] = 0;
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] Qdata = pq.poll();
            int num = Qdata[0];
            int price = Qdata[1];
            
            if(dst[num] < price){
                continue;
            }
            
            for(Info info :list[num]){
                int head = info.head;
                int tail = info.tail;
                int movePrice = info.price;
                int total = price + movePrice;
                
                if(dst[tail] > total){
                    dst[tail] = total;
                    pq.add(new int[]{tail, total});
                }
            }
        }
        
        int count = 0;
        for(int num : dst){
            if(num<=K){
                count++;
            }
        }
        

        return count-1;
    }
}
