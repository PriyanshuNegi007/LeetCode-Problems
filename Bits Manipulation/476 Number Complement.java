class Solution {
    public int findComplements(int num) {
        int mask=0;
        int temp=num;

        while(temp>0){
            mask=(mask<<1) | 1;
            temp=temp>>1;
        }
        return num ^ mask;
    }

    public int findComplement(int num){
        int numberOfBits = Integer.toBinaryString(num).length();
        int mask=(1 << numberOfBits) - 1;
        return num^mask;
    }
}
