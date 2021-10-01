# Uses python3
import sys
from collections import namedtuple

def my_compare(e):
    return e[0]

def optimal_points(segments):
    points = []
    segments.sort(key=my_compare,reverse=False)
    current_segment_index=0
    while current_segment_index<len(segments):
        right=segments[current_segment_index][1]
        while current_segment_index<len(segments)-1 and segments[current_segment_index+1][0]<=right:
            current_segment_index+=1
            right=min(segments[current_segment_index][1],right)
        current_segment_index+=1
        points.append(right)
    return points

if __name__ == '__main__':
    n = int(input())
    segments=[]
    for i in range(n):
        start,end=[int(data) for data in input().split()]
        segments.append([start,end])
    points = optimal_points(segments)
    print(len(points))
    print(*points)
