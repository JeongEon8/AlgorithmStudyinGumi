# [백준 - S5] 31246. 모바일 광고 입찰

## ⏰**time**

40분

## :pushpin: **Algorithm**

우선 순위 큐

## :round_pushpin: **Logic**

1. 우선순위 큐를 만들어서 큐 사이즈가 k 이사이면 하나씩 뺴서 마지막에 값을 꺼내서 출력해주려고 했다
2. 우선순위 큐를 만들어서 2번째 줄 부터 b-a 를 값을 넣어주는데 음수값이면 0을 넣어준다
3. 넣고 나서 큐의 개수를 새고 k보다 크며 빼준다.


```kotlin
for(i in 1.. N){
        val(A, B) = readLine().split(' ').map{it.toInt()}
        val sum = B-A
        if(count == K){
            break
        }
        if(sum<0) {
            count++
            queSize++
            continue
        }
        queSize++
        queue.add(sum)
        if(queSize >K){
            queue.poll()
            queSize--
        }
    }
    
    

    if(count == K){
        println(0)
    }else{
        while(queSize > K){
        
            queSize--
            queue.poll()
        }
        println(queue.poll())
    }
```


## 📡 Link

<https://www.acmicpc.net/problem/31246>
