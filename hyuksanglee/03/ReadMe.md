# [프로그래머스 - Lv2] 과제진행하기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 정렬
- bfs

## ⏲️**Time Complexity**
$O(N \log N)$

## :round_pushpin: **Logic**
1. 배열에 있는 값을 오래된 순으로 정렬을 시켜준다.
2. 배열에서 차례대로 꺼내고 스택에 값이 있으면 비교를 한다
   - 남은 시간이 0이면 큐에 넣어주고 아닐경우 스택에 넣어준다.
3. 배열을 다 탐색을 하고 스택에 남아있는것을 하나씩 뽑아 큐에 담아준다.
4. 큐에서 하나씩 뽑아 출력
```java
		 int len = plans.length;
        String[] answer = new String[len];
        Info[] infos = new Info[len];
        for(int l = 0; l < len; l++){
            String n = plans[l][0];
            String[] t = plans[l][1].split(":");
            int w = Integer.parseInt(plans[l][2]);
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            
            Info info = new Info(n,h,m,w);
            infos[l] = info;
        }
        Arrays.sort(infos);
        
        int startH = infos[0].hour;
        int startM = infos[0].minute;
        
        Stack<Info> stack = new Stack<Info>();
        Queue<String> que = new ArrayDeque<String>();
        for(int l = 0; l<len; l++){
            Info info = infos[l];
            int time = (info.hour - startH)*60 + info.minute - startM;
            while(time !=0 && !stack.isEmpty()){
                Info infoS = stack.pop();
                if (infoS.work <= time) {         
                    time -= infoS.work;
                    que.add(infoS.name);           
                } else {                           
                    infoS.work -= time;             
                    stack.push(infoS);              
                    time = 0;
                }
            }
            stack.push(info);
            startH = info.hour;
            startM = info.minute;
            
        }
        
        while(!stack.isEmpty()){
            Info i = stack.pop();
            que.add(i.name);
        }
        
        int index = 0;
        for(String s : que){
            answer[index] = s;
            index++;
        }
```

## :black_nib: **Review**

  ## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/176962

  

