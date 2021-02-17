import java.util.*;
import java.lang.*;
import java.lang.String; 


public class Lab02 
{
    //findIndex searches for the value of the index from the sorted array in the unsorted array and returns the index value
    public int findIndex(int[] unsorted, int elem) {
        for(int i=0; i < unsorted.length; i++){
            if(unsorted[i] == elem){
                return i; 
            }
        }
        return -1; 
    }
    
    //twoSum function that sorts original array and finds two values that add to the target
    public int[] twoSum(int[] sum, int num) {
        //orignal unsorted array that is used before it gets sorted
        int [] unsorted = new int[sum.length];
        
        //adds the orginal array sum into unsorted before sorting
        for (int i=0; i < sum.length; i++){
            unsorted[i] = sum[i];
        }
        
        //sorts the sum array from least to greatest 
        for (int i=1; i<sum.length; i++){
            int temp = sum[i];
            int j = i-1;
            while (j>=0 && sum[j]>temp) {
                sum[j+1] = sum[j]; 
                --j;
            }
            sum[j+1] = temp; 
        }
        //two pointers that start at opposite ends and iterate until they've all been added together 
        int leftP = 0;
        int rightP = sum.length-1; 
        while (leftP < rightP){
            if ((sum[rightP] + sum[leftP]) == num) { //finds the two values and returns the indices from the original array
                return new int[] {findIndex(unsorted, sum[leftP]), findIndex(unsorted, sum[rightP])}; //calls on the findIndex function to find where the indices were from the original array
            } else if ((sum[rightP] + sum[leftP]) > num) {
                rightP--; 
            } else {
                leftP++;
            }
        }
        return new int[] {-1}; //if no combination was found it returns -1 
    }
    
    //main function to test code
    public static void main(String[] args){
        Lab02 example1 = new Lab02();
        System.out.println(Arrays.toString(example1.twoSum(new int[]{2,12,8,7}, 9)));
        
        Lab02 example2 = new Lab02();
        System.out.println(Arrays.toString(example2.twoSum(new int[]{1,13,18,20,30}, 40)));
    }
}