def solution(record):
    answer = []
    re = {}
    for records in record:
        split = records.split(" ")

        if split[0] == "Enter" or split[0] == "Change":
            re[split[1]] = split[2]
    
    for records in record:
        split = records.split(" ")
        if split[0] == "Enter":
            name = re[split[1]] + "님이 들어왔습니다."
            answer.append(name)
        elif split[0] == "Leave":
            name = re[split[1]] + "님이 나갔습니다."
            answer.append(name)

    return answer

