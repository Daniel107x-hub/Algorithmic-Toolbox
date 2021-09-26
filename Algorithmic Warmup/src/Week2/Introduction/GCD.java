package Week2.Introduction;

public class GCD {
    public Long naiveGCD(Long a,Long b){
        Long bestResult=0L;
        for(Long i=1L;i<a+b;i++){
            if(a%i==0 && b%i==0){
                bestResult=i;
            }
        }
        return bestResult;
    }

    public Long euclidGCD(Long a,Long b){
        if(b==0){
            return a;
        }
        Long ap=a%b;
        return euclidGCD(b,ap);
    }
}
