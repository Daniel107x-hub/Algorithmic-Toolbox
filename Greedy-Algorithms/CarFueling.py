# python3
import sys


def compute_min_refills(distance, tank, stops):
    # write your code here
    stops.insert(0,0)
    stops.append(distance)
    stops_count=0
    last_stop=0
    while last_stop<len(stops)-2:
        capacity=tank
        last_refuel=last_stop
        while last_stop<len(stops)-1 and stops[last_stop+1]-stops[last_refuel]<capacity:
            last_stop+=1
        if last_stop==last_refuel:
            return -1
        if last_stop<len(stops)-1:
            stops_count+=1
    return stops_count

if __name__ == '__main__':
    d=int(input())
    m=int(input())
    n=int(input())
    stops=[int(stop) for stop in input().split()]
    print(compute_min_refills(d, m, stops))
