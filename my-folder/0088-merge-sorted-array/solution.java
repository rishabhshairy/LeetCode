class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        if(n==0){
            return;
        }
        if (m == 0)
        {
            for(int i=0;i<n;i++){
                arr1[i]=arr2[i];
            }
        }
        
        int k=m;
        for(int i=0;i<n;i++){
            arr1[k]=arr2[i];
            k++;
        }
        Arrays.sort(arr1);
    }
}
