n = int(input())
my_card = list(map(int, input().split()))
my_card.sort()

m = int(input())
find_card = list(map(int, input().split()))

def bs(find):
    st = 0
    en = n - 1

    while st <= en:
        mid = (st + en) // 2

        if my_card[mid] == find:
            return True
        elif my_card[mid] < find:
            st = mid + 1
        else:
            en = mid - 1

    return False


for find in find_card:
    if bs(find):
        print(1, end=" ")
    else:
        print(0, end=" ")