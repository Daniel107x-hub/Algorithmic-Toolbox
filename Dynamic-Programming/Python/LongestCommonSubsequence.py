def lcs(s1, s2):
    sizes = [[0 for i in range(0, len(s1) + 1)] for i in range(0, len(s2) + 1)]
    for i in range(0, len(s2)):
        for j in range(0, len(s1)):
            d = max(
                sizes[i + 1][j],
                sizes[i][j + 1]
            )
            if s2[i] == s1[j]:
                d = sizes[i][j]
                d += 1
            sizes[i + 1][j + 1] = d
    return sizes[len(s2)][len(s1)]


if __name__ == "__main__":
    n = int(input())
    str1 = input().split(" ")
    m = int(input())
    str2 = input().split(" ")
    result = lcs(str1, str2)
    print(result)
