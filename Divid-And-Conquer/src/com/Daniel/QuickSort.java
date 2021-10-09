package com.Daniel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
    private static final Random random=new Random();

    private static void swap(List<Integer> A,int index1,int index2){
        int temp=A.get(index1);
        A.set(index1,A.get(index2));
        A.set(index2,temp);
    }

    private static int partition(List<Integer> A,int start,int end){
        int pivot=start+random.nextInt(end-start);
        swap(A,pivot,end);
        int minor=start-1;
        for(int j=start;j<end;j++){
            if(A.get(j)<=A.get(end)){
                minor++;
                swap(A,minor,j);
            }
        }
        minor++;
        swap(A,minor,end);
        return minor;
    }

    private static void sort(List<Integer> A,int start,int end){
        if(start>=end){
            return;
        }
        int limit=partition(A,start,end);
        sort(A,start,limit-1);
        sort(A,limit+1,end);
    }

    private static void swapList(List<Integer> A,int from_1,int to_1,int from_2,int to_2){
        if(from_1>to_1 || from_2>to_2) {
            return;
        }else if(from_1==to_1 && from_2==to_2){
            swap(A,from_1,from_2);
            return;
        }
        int limit=Math.max(to_1-from_1,to_2-from_2);
        for(int i=0;i<=limit;i++){
            if(from_1>to_1){
                int element=A.remove(from_2);
                A.add(from_1-1,element);
                from_2++;
            }else if(from_2>to_2){
                int element=A.remove(from_1);
                A.add(from_2-1,element);
                from_1++;
            }else{
                swap(A,from_1,from_2);
                from_1++;
                from_2++;
            }

        }
        return;
    }

    private static int[] partition3(List<Integer> A,int start,int end){
        int pivot=start+random.nextInt(end-start);
        swap(A,pivot,end);
        int minor=start-1;
        int last_similar=end;
        for(int i=start;i<last_similar;i++){
            while(A.get(i)==A.get(last_similar) && i!=last_similar){
                last_similar--;
                swap(A,i,last_similar);
            }
            if(A.get(i)<A.get(last_similar)){
                minor++;
                swap(A,i,minor);
            }
        }
        swapList(A,minor+1,last_similar-1,last_similar,end);
        int right_end=minor+end-last_similar+1;
        int[] result={minor+1,right_end};
        return result;
    }

    private static void sort3(List<Integer> A,int start,int end){
        if(start>=end){
            return;
        }
        int[] limits=partition3(A,start,end);
        sort3(A,start,limits[0]-1);
        sort3(A,limits[1]+1,end);
    }

    public static void testPartition(){
        List<Integer> A=new ArrayList<>(Arrays.asList(1,5,2,7,3));
        int result=partition(A,0,A.size()-1);
        System.out.println(result);
    }

    public static void testSort(){
        List<Integer> A=new ArrayList<>(Arrays.asList(10,30,80,90,40,50,70));
        sort(A,0,A.size()-1);
        for(int element:A){
            System.out.print(element+" ");
        }
    }

    public static void testSwapList(){
        List<Integer> A=new ArrayList<Integer>(Arrays.asList(1,1,5,4,2,2,2,2));
        swapList(A,0,1,4,7);
        for(int element:A){
            System.out.print(element+" ");
        }
    }

    public static void testPartition3(){
        List<Integer> A=new ArrayList<Integer>(Arrays.asList(1,2,2,5,4,3,3,3,2,1,1));
        partition3(A,0,A.size()-1);
        for(int element:A){
            System.out.print(element+" ");
        }
    }

    public static void testSort3(){
        List<Integer> A=new ArrayList<Integer>(Arrays.asList(1,2,2,5,4,3,3,3,2,1,1));
        sort3(A,0,A.size()-1);
        for(int element:A){
            System.out.print(element+" ");
        }
    }
}
