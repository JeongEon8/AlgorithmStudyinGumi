#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct Quiz {
    int score = 0;
    int num = 0;
};

vector<Quiz> arr;

bool compare(Quiz a, Quiz b) {
    return a.score > b.score;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int input;
    for (int i = 1; i <= 8; i++) {
        Quiz quiz;
        cin >> input;
        quiz.score = input;
        quiz.num = i;
        arr.push_back(quiz);
    }

    sort(arr.begin(), arr.end(), compare);

    int sum = 0;
    priority_queue<int, vector<int>, greater<>> q;
    for (int i = 0; i < 5; i++) {
        sum += arr[i].score;
        q.push(arr[i].num);
    }

    cout << sum << "\n";
    for (int i = 0; i < 5; i++) {
        cout << q.top() << " ";
        q.pop();
    }

    return 0;
}
