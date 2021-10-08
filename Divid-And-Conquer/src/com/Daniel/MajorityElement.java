package com.Daniel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {
    private static List<Integer> Merge(List<Integer> A,List<Integer> B){
        List<Integer> result=new ArrayList<Integer>();
        int Apointer=0;
        int Bpointer=0;
        while(Apointer<A.size() && Bpointer<B.size()){
            if(A.get(Apointer)<B.get(Bpointer)){
                result.add(A.get(Apointer));
                Apointer++;
            }else{
                result.add(B.get(Bpointer));
                Bpointer++;
            }
        }
        if(Apointer<A.size()){
            result.addAll(A.subList(Apointer,A.size()));
        }else if(Bpointer<B.size()){
            result.addAll(B.subList(Bpointer,B.size()));
        }
        return result;
    }

    private static List<Integer> MergeSort(List<Integer> A,int start, int end){
        if(start==end){
            return A.subList(start,end+1);
        }
        int mid=(start+end)/2;
        List<Integer> B=MergeSort(A,start,mid);
        List<Integer> C=MergeSort(A,mid+1,end);
        List<Integer> result=Merge(B,C);
        return result;
    }

    private static int findMajority(List<Integer> A){
        A=MergeSort(A,0,A.size()-1);
        int currElement=-1;
        int currFreq=0;
        for(int element:A){
            if(currElement==-1 || currElement!=element){
                currElement=element;
                currFreq=0;
            }
            if(element==currElement){
                currFreq++;
            }
            if(currFreq>A.size()/2){
                return 1;
            }
        }
        return 0;
    }

    public static void testMajority(){
        List<Integer> A=new ArrayList<Integer>(Arrays.asList(4,4,2,1,3,4,4,2,4));
        int result=findMajority(A);
        System.out.println(result);
    }
}
