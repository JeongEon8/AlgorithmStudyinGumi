#include <iostream>
#include <deque>
#include <vector>
using namespace std;

int main()
{

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    deque<int> dq;
    vector<int> vec;


    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        vec.push_back(num);
    }

    for (int i = 1; i <= n; i++) {
        int temp;
        switch (vec[n - i]) {

        case 1:
            dq.push_front(i);
            break;

        case 2:
            temp = dq.front();
            dq.pop_front();
            dq.push_front(i);
            dq.push_front(temp);
            break;

        case 3:
            dq.push_back(i);
            break;
        }

    }
    
    for (int i = 0; i < n; i++) {
        cout << dq.front() << ' ';
        dq.pop_front();
    }

}

