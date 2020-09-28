public class Fibonaqi {
    public static void main(String[] args) {
        int nums[]={4,5,6,1,2,3};
        System.out.println(search(nums,4));

    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int length = nums.length;
        int r = length - 1;
        while (l < r) {
            int mid = (r+l)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[l] < nums[mid]) {
                if (nums[l] < target && nums[mid] > target) {
                        r = mid ;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (nums[mid]<target&&target<nums[r]){
                    l=mid+1;
                }
                else r=mid-1;
            }
        }

        return -1;
    }


}
