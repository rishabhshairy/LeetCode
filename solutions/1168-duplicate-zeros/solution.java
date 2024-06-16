class Solution {
    public void duplicateZeros(int[] arr) {
        int i=arr.length-1;
        
       while(i>=0){
            if(arr[i]==0){
                int j=arr.length-1;
                while(j>i){
                    arr[j]=arr[j-1];
                    j--;
                }
            } 
           i--;
           
        }
    }
}
