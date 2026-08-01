class Solution {

    public double recursive(double x, int n){
        if(n == 0){
            return 1;
        }

        double half = recursive(x, n/2);

        if(n%2 == 0){
            return half*half;
        }
        else{
            return x*half*half;
        }
    }

    public double myPow(double x, int n) {
        if(n<0){
            n = -n;
            x = (double)1/x;
        }

        return recursive(x, n);
    }
}