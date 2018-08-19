import java.util.*;

class Solution {
    public int solution(int[] A) {
        

	// sort the given array
        int[] sorted = A;
        Arrays.sort(sorted);
        
        int smallestPosInt = 1;
        
        for(int i =0; i < sorted.length; i++){
            if(smallestPosInt == sorted[i]){
                smallestPosInt++;
            }
        }
        
        return(smallestPosInt);
    }
}
