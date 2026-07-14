# [PGS - Lv2] 01_소수 찾기

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 완전탐색

## ⏲️**Time Complexity**

$O( N * N! + M(K^(1/2)) )$   *N: 문자열의 길이, M: numberSet의 개수, K: 판별하려는 숫자

## :round_pushpin: **Logic**

1. comb는 조합된 숫자이고, numbers.substring(0, i) + numbers.substring(i + 1)을 통해 현재 선택한 i번째 문자를 제외한 나머지 문자열을 다음 재귀로 넘겨줍니다.
   ```java
    public void combine(String comb, String numbers){
        if(comb != ""){
            numberSet.add(Integer.parseInt(comb));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            combine(comb + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
   ```

2. 숫자가 소수인지 판별하는 함수이다. num이 2보다 작은 0, 1은 소수가 아니므로 false를 반환해준다. 0부터 num의 제곱근까지의 수로 num을 나눴을때 나누어지면 소수가 아니므로 false를 반환하고 전부 나누어지지 않으면 소수이므로 true를 반환한다.
   ```java
    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42839
