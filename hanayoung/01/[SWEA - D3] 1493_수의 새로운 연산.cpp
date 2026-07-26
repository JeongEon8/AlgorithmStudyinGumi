#include <iostream>

std::pair<int, int> getPair(int num);
int getNum(std::pair<int, int> pair);

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int p, q;
        std::cin >> p >> q;
        std::pair<int, int> pPair, qPair;
        pPair = getPair(p);
        qPair = getPair(q);

        std::pair<int, int> result = {pPair.first+qPair.first, pPair.second+qPair.second};

        std::cout << '#' << tc << ' ' << getNum(result) << '\n';
    }
    return 0;
}

std::pair<int, int> getPair(int num) {
    int cur = 1;
    int prev = 0;
    int cnt = 1;
    std::pair<int, int> pair;

    while(1) {
        if(num >= prev && num < cur) {
            pair = {1+num-prev, cnt -1 -num + prev};
            break;
        }
        prev = cur;
        cur += cnt;
        cnt++;
    }
    return pair;
}

int getNum(std::pair<int, int> pair) {
    int sum = 1;
    int d = pair.first + pair.second - 1;
    for(int i = d-1; i >= 1; i--) {
        sum += i;
    }
    while(d > pair.second) {
        d--;
        sum++;
    }
    return sum;
}
