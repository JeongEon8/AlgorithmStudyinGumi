# [PGS - Lv2] 03_주차 요금 계산

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- HashMap
- 구현

## ⏲️**Time Complexity**

// N은 records 개수 M은 차량수
$O(N + MlogM)$ 

## :round_pushpin: **Logic**

1. 주어진 기록을 순서대로 탐색하면서 차량별 정보를 갱신한다.
IN 일때, 입차 시간을 저장한다. 기존에 누적된 주차 시간은 유지한다.
OUT 일때, 저장되어 있던 입차 시간과 현재 출차 시간의 차이를 계산한다. 계산된 시간을 누적 주차 시간에 더한다.
   ```java
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
   ```

2. 차량번호순으로 정렬
   ```java
        for(int key : hashmap.keySet()){
            list.add(hashmap.get(key));
        }
        Collections.sort(list);
   ```

3. 미출차 차량 처리
모든 기록을 처리한 후에도 상태가 IN인 차량은 출차 기록이 없는 차량이다.
문제 조건에 따라 23:59에 출차한 것으로 간주하여 추가 주차 시간을 계산한다.
   ```java
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            CarInfo cur = list.get(i);
            if(cur.state.equals("IN")){
                cur.parkingTime += ((23 * 60 + 59) - cur.timeStamp);
            }
   ```

3. 주차 요금 계산
기본 시간 이하인 경우 기본 요금만 부과하고 기본 시간을 초과한 경우에는 초과시간 = 누적주차시간 - 기본시간을 구한 뒤, 추가요금 = ((초과시간 + 단위시간 - 1) / 단위시간) × 단위요금 을 구한뒤 기본 요금에 더한다.
   ```java
            int fee = fees[1];
            if(cur.parkingTime > fees[0]){
                fee += ((cur.parkingTime - fees[0] + fees[2] - 1) / fees[2]) * fees[3]; 
            }
            
            answer[i] = fee;
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/92341
