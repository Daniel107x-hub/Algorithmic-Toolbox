package Week2;

public class GCD {
    public int euclidGCD(int a,int b){
        if(b==0){
            return a;
        }
        int ap=a%b;
        return euclidGCD(b,ap);
    }

    public void testEuclidGCD(){
        int result=euclidGCD(18,35);
        if(result!=1){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=euclidGCD(28851538,1183019);
        if(result!=17657){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
    }
}
