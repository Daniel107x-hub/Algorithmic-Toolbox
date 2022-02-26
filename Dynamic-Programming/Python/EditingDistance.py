def edit_distance(s1, s2):
    distances = [[-1 for i in range(0, len(s1)+1)] for i in range(0, len(s2)+1)]
    for i in range(0, len(s2) + 1):
        distances[i][0] = i
    for i in range(0, len(s1) + 1):
        distances[0][i] = i

    for i in range(0, len(s2)):
        for j in range(0, len(s1)):
            if s1[j] == s2[i]:
                d = distances[i][j]
            else:
                d = distances[i][j] + 1
            distance = min(
                distances[i][j + 1] + 1,
                distances[i + 1][j] + 1,
                d
            )
            distances[i+1][j+1] = distance
    return distances[len(s2)][len(s1)]


if __name__ == "__main__":
    str1 = input()
    str2 = input()
    result = edit_distance(str1, str2)
    print(result)
