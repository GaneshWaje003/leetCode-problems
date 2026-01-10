public class Prob2258_maximiseMinimumPoweredCity {
    public static void main(String[] args) {
      int[] stations =   {1,2,4,5,0};
      Solution s = new Solution();
      s.maxPower(stations, 1, 2);
    }
}


class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long result = 0 ;
        int i  = 0 , size = stations.length;
        int[] power = new int[size];
        int mins = 0 ;

        while (i < size) {
            if(i - 1 < 0){
                power[i] = stations[i] + stations[i+1];
                (power[i] < mins) ? min = power[i]:null;
            }else if(i+1 > size-1){
                power[i] = stations[i-1] + stations[i];
            }
            else{
                power[i] = stations[i-1] + stations[i] + stations[i+1];
            }

            i++;
        }

        // adding the new stations k to the stations not 




        for(int child:power){
            System.out.print(child + " ");
        }

        return result;
    }
}