n = int(input())
dict_book = {}
for _ in range(n):
    title = input()
    if title in dict_book:
        dict_book[title] += 1
    else:
        dict_book[title] = 1

sort_book = dict(sorted(dict_book.items(), key=lambda x: x[1], reverse=True))
_max = list(sort_book.values())[0]

result = []
for key, value in sort_book.items():
    if value == _max:
        result.append(key)

result.sort()
print(result[0])