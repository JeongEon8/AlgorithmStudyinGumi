# [SWEA - D3] 01_최장 증가 부분 수열

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현, LIS

## ⏲️**Time Complexity**

$O(N^2logN)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. pair의 두 번째 값으로 내림차순 정렬 진행할 struct 생성, 우선순위큐에 전달해서, pair의 두 번째 값인 길이로 정렬해서 길이가 긴 순서대로 나올 수 있게끔 함
   ```
   struct Compare {
    bool operator()(const std::pair<int,int>& a, const std::pair<int,int>& b) const {

        return a.second < b.second;  

    }

};
   ```
```
std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, Compare> pq;
```
2. N까지 순회하며, 임시 배열과 추가된 여부 관리하는 변수로 관리
3. 우선순위큐가 빌 때까지나, 추가될 때까지 반복
4. 가장 앞의 값(길이가 가장 긴 경우)을 꺼내서 arr[i]번째보다 현재 가리키는 값이 더 작거나 같으면 증가하는 수열이므로 우선순위큐에 값 push, isAdd 값 업데이트 후 탈출
5. tmp배열의 값 다시 우선순위큐에 삽입
6. 만약 isAdd가 false이면 해당 값으로 시작하고 길이 1인 경우이므로 {i, 1} 값 push
```
        for (int i = 0; i < N; i++) {

            bool isAdd = false;

            std::vector<std::pair<int, int>> tmp;

            while(pq.size() > 0) {

                std::pair<int, int> num = pq.top();

                tmp.push_back(pq.top());

                pq.pop();

                if(arr[num.first] <= arr[i]) {

                    pq.push({i, num.second+1});

                    isAdd = true;

                    break;

                }

            }

            for (const auto& p: tmp) {

                pq.push(p);

            }



            if(isAdd == false) {

                pq.push({i, 1});

            }

        }
```
7. 가장 위의 값 출력
```std::cout << '#' << tc << ' ' << last.second << '\n';
```
## :black_nib: **Review**

- 문제를 이해를 처음에는 제대로 못해서 좀 걸렸던 문제!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
