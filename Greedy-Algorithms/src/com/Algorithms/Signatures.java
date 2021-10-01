package com.Algorithms;

import java.util.*;

public class Signatures{
    private static ArrayList<Integer> getMinimumVisits(ArrayList<Segmento> segmentos){
        ArrayList<Integer> points=new ArrayList<Integer>();
        Collections.sort(segmentos,new SegmentosSorter());
        int current_segment_index=0;
        while (current_segment_index<segmentos.size()-1){
            int right=segmentos.get(current_segment_index).end;
            while(current_segment_index<segmentos.size()-1 && segmentos.get(current_segment_index+1).start<=right){
                current_segment_index++;
                right=Math.min(segmentos.get(current_segment_index).end,right);

            }
            current_segment_index++;
            points.add(right);
        }
        return points;
    }

    public static void testMinimumVisits(){
        Scanner scanner=new Scanner(System.in);
        int number_segments=Integer.parseInt(scanner.nextLine());
        ArrayList<Segmento> segmentos=new ArrayList<Segmento>();
        for(int i=0;i<number_segments;i++){
            String[] segment_info= scanner.nextLine().split(" ");
            Segmento segment=new Segmento(Integer.parseInt(segment_info[0]),Integer.parseInt(segment_info[1]));
            segmentos.add(segment);
        }
        ArrayList<Integer> result=getMinimumVisits(segmentos);
        System.out.println(result.size());
        for(int point:result){
            System.out.print(point+" ");
        }
    }
}

class SegmentosSorter implements Comparator<Segmento>{
    @Override
    public int compare(Segmento segmento1, Segmento segmento2) {
        return segmento1.compareTo(segmento2);
    }
}

class Segmento implements Comparable<Segmento>{
    int start;
    int end;

    public Segmento(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Segmento segment) {
        return Integer.compare(this.start,segment.start);
    }
}