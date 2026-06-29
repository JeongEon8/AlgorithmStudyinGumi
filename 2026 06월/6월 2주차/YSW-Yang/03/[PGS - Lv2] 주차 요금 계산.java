import java.util.*;
class CarInfo implements Comparable<CarInfo>{
    int carNum;
    int timeStamp;
    String state;
    int parkingTime;
    
    public CarInfo(int carNum, int timeStamp, String state, int parkingTime){
        this.carNum = carNum;
        this.timeStamp = timeStamp;
        this.state = state;
        this.parkingTime = parkingTime;
    }
    
    public CarInfo(int carNum, int timeStamp, String state){
        this.carNum = carNum;
        this.timeStamp = timeStamp;
        this.state = state;
        this.parkingTime = 0;
    }
    
    @Override
    public int compareTo(CarInfo other){
        return this.carNum - other.carNum;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, CarInfo> hashmap = new HashMap<>();
        List<CarInfo> list = new ArrayList<>();
        
        for(String record : records){
            String[] cur = record.split(" ");
            int carNum = Integer.parseInt(cur[1]);
            String[] time = cur[0].split(":");
            int timeStamp = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            int parkingTime = hashmap.getOrDefault(carNum, new CarInfo(carNum, timeStamp, "IN")).parkingTime;
            
            if(cur[2].equals("IN")){
                hashmap.put(carNum, new CarInfo(carNum, timeStamp, cur[2], parkingTime));
            }else{
                CarInfo curCarInfo = hashmap.get(carNum);
                int addParkingTime = timeStamp - curCarInfo.timeStamp;
                hashmap.put(carNum, new CarInfo(carNum, timeStamp, cur[2], parkingTime + addParkingTime));
            }
        }
        
        for(int key : hashmap.keySet()){
            list.add(hashmap.get(key));
        }
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            CarInfo cur = list.get(i);
            if(cur.state.equals("IN")){
                cur.parkingTime += ((23 * 60 + 59) - cur.timeStamp);
            }
            
            int fee = fees[1];
            if(cur.parkingTime > fees[0]){
                fee += ((cur.parkingTime - fees[0] + fees[2] - 1) / fees[2]) * fees[3]; 
            }
            
            answer[i] = fee;
        }

        return answer;
    }
}
