class Solution {

    /*Top Down Approach(Memoization)
    HashMap<Integer,Integer> cache = new HashMap<>();
    public int fib(int n) {

        if(n==0 || n==1) {
            return n;
        }
        //before compute , first check my cache(HashMap)
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        // If value not in cache then compute
       int result =  fib(n-1) + fib(n-2);

       //Store(number,result)
       cache.put(n,result);
       return result;
    }*/

    //Bottom Up Approach(Tabulation)
    public int fib(int n){
        if(n<=1){
            return n;
        }
        //Prepare a table(Array)
        int dp[] = new int[n+1];

        //Fill the base case first
        dp[0]=0;
        dp[1]=1;

        //once base case filled, fill rest values
        for(int i=2; i <=n; i++){
           // fib(n-1)+ fib(n-2);  //Recurance relation
           dp[i]=dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}
