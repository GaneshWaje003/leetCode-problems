public class MergeSortedArray {
    public static void main(String args[]) {
        MergeSortedArray obj = new MergeSortedArray();
        int arr1[] = {1 ,2,2,0,0,0};
        int arr2[] = {4,5,6};

        obj.merge(arr1,arr1.length, arr2,  arr2.length);
    }

    // solving method always starting from end , setting large elements first 

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m -1 ;
        int j = n -1 ;
        int k = m + n - 1 ;

        while(j >= 0 ){
            if(i >=0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];    
            }else{
                nums1[k--] = nums2[j--];
            }
        }
    }
}   