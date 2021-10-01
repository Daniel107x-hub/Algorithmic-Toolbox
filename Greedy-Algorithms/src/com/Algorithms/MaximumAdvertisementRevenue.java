package com.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumAdvertisementRevenue {
    private static int getMaxProductNaive(Integer[] A,Integer[] B_copy){
        Arrays.sort(A,Collections.reverseOrder());
        List<Integer> B=new ArrayList<Integer>(Arrays.asList(B_copy));
        int sum=0;
        for(int element_a:A){
            int max_product=0;
            int index_max_element_b=-1;
            for(int j=0;j<B.size();j++){
                int product=element_a*B.get(j);
                if(product>max_product){
                    max_product=product;
                    index_max_element_b=j;
                }
            }
            B.remove(index_max_element_b);
            sum+=max_product;
        }
        return sum;
    }

    private static int getMaxProduct(Integer[] A,Integer[] B){
        int sum=0;
        Arrays.sort(A,Collections.reverseOrder());
        Arrays.sort(B,Collections.reverseOrder());
        for(int i=0;i<A.length;i++){
            sum+=A[i]*B[i];
        }
        return sum;
    }

    public static void testNaiveAlgorithm(){
        Integer[] A={1,3,-5};
        Integer[] B={-2,4,1};
        int result=getMaxProductNaive(A,B);
        System.out.println(result);
    }

    public static void testGetMaxProduct(){
        Integer[] A={1,3,-5};
        Integer[] B={-2,4,1};
        int result=getMaxProduct(A,B);
        System.out.println(result);
    }
}
