class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startPoint = 0;
        int surplus = 0;
        int deficit = 0;

        for(int i = 0; i < gas.length; i++){
            int balance = gas[i] - cost[i];
            surplus = surplus + balance;
            deficit = deficit + balance;
            if(surplus < 0){
                surplus = 0;
                startPoint = i + 1; //Move to next station
            }
        }
        if(deficit >= 0){
            return startPoint;
        }else{
            return -1;
        }
    }
}
