# [백준 - S4] 28278. 스택2

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
- 1일때 넣고, 2일때 사이즈 비교해서 풀, 3일때 사이즈 출력, 4일때 사이즈 비교해서 1또는0출력, 5일때 마지막에 들어온거 get으로 꺼낸다.
```java
	for(int i = 0; i<X; i++){
            String[] input = in.readLine().split(" ");
            if(input[0].equals("1")){
                arr.add(Integer.parseInt(input[1]));
            }else if(input[0].equals("2")){
                if (arr.size()>0){
                    System.out.println(arr.pollLast());
                }else{
                    System.out.println(-1);
                }
            }
            else if(input[0].equals("3")){
                System.out.println(arr.size());
            }else if(input[0].equals("4")){
                if(arr.size()>0){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }else{
                if (arr.size()>0){
                    System.out.println(arr.getLast());
                }else{
                    System.out.println(-1);
                }
            }
        }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/28278
