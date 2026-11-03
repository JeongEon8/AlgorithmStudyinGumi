#include <iostream>
#include <vector>
#include <map>
#include <queue>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int n, m;
        int answer = 0;
        std::cin >> n >> m;
    
        std::vector<int> costs(n+1); // 주차공간 요금
        std::vector<int> cars(m+1); // 차들의 무게
        std::vector<int> map(n+1, -1); // 주차공간 여부, 존재할 경우 map[주차공간 인덱스] = 차량번호 
        std::vector<int> revMap(m+1); // revMap[차량번호] = 주차공간 인덱스
        std::queue<int> q;

        for(int i = 1; i <= n; i++) {
            std::cin >> costs[i];
        }

        for(int i = 1; i <= m; i++) {
            std::cin >> cars[i];
        }

        for(int i = 1; i <= 2*m; i++) {
            int op; // op는 차량번호, index는 주차위치
            std::cin >> op;

            if(op < 0) {
                int index = revMap[op*-1];
                if(q.size() > 0) {
                    int top = q.front(); // 차량번호
                    q.pop();
                    map[index] = top;
                    revMap[top] = index;
                    answer += cars[top] * costs[index];
                } else {
                    map[index] = -1;
                    revMap[op*-1] = -1;
                }
            } else {
                int index = 1;
                while(index <= n && map[index] != -1) {
                    index++;
                }
                if(index >= n+1) {
                    q.push(op);
                } else {
                    answer += cars[op] * costs[index];
                    map[index] = op;
                    revMap[op] = index;
                }
            }
        }
        std::cout << '#' << tc << ' ' << answer << '\n';
    }

    return 0;
}
