import math


def cal_mid_point(up,low):
    return math.floor((up+low)/2)

def run_guess(low,up):
    mid=cal_mid_point(low,up)
    while mid!=low and mid!=up:
        print(str(mid)+' Up or low?: ')
        response=input()
        if response=='u':
            mid=run_guess(mid+1,up)
        if response=='l':
            mid=run_guess(low,mid-1)
    return mid



if __name__ == '__main__':
    print('Insert number [low up]: ')
    numbers=input().split()
    low=int(numbers[0])
    up=int(numbers[1])
    print("The guess is: " + str(run_guess(low,up)))