package com.Algorithms;

public class CarFueling {
    private static int getNumberStops(int full_capacity,int[] stops){
        int stops_count=0;
        int last_refuel=0;
        int last_stop=0;
        while(last_stop<stops.length-2){
            int capacity=full_capacity;
            last_refuel=last_stop;
            while(last_stop<stops.length-1 && stops[last_stop+1]-stops[last_refuel]<capacity){
                last_stop++;
            }
            if(last_stop==last_refuel){
                return -1;
            }
            if(last_stop<stops.length-1){
                stops_count++;
            }
        }
        return stops_count;
    }

    public static void testRefueling(){
        int distance=10;
        int full_capacity=3;
        int[] stops={0,1,2,5,9,distance};
        int result=getNumberStops(full_capacity,stops);
        System.out.println(result);
    }
}
