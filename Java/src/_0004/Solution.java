package _0004;

public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenNums1 = nums1.length;
        int lenNums2 = nums2.length;
        int totalLen = lenNums1 + lenNums2;
        double result = 0;

        if (lenNums1 == 0){
            if (lenNums2 % 2 == 0){
                int index = lenNums2/2;
                result = (nums2[index]+nums2[index-1])/2;
                return result;
            }
            if (lenNums2 % 2 == 1){
                int index = lenNums2/2;
                result = nums2[index];
                return result;
            }
        }
        if (lenNums2 == 0){
            if (lenNums1 % 2 == 0){
                int index = lenNums1/2;
                result = (nums1[index]+nums1[index-1])/2;
                return result;
            }
            if (lenNums1 % 2 == 1){
                int index = lenNums1/2;
                result = nums1[index];
                return result;
            }
        }

        nums1 = arrayAppend(nums1);
        nums2 = arrayAppend(nums2);
        if (totalLen % 2 == 1){
            int medianIndex = totalLen / 2;
            int i = -1;
            int j = -1;
            boolean isI = false;
            boolean isJ = false;
            while (true){
                if (medianIndex == i+j+1){
                    System.out.println("totalLen:"+totalLen);
                    System.out.println("medianIndex:"+medianIndex);
                    System.out.println("i:"+i);
                    System.out.println("j:"+j);
                    break;
                }
                if (nums1[i+1] <= nums2[j+1]){
                    i += 1;
                    isI = true;
                    isJ = false;
                }
                else{
                    j += 1;
                    isI = false;
                    isJ = true;
                }
            }
            if (isI == true){
                result = nums1[i];
            }
            if (isJ == true){
                result = nums2[j];
            }
        }

        if (totalLen % 2 == 0){
            int medianIndexL = totalLen / 2 - 1;
            int medianIndexR = totalLen / 2;
            int i = -1;
            int j = -1;
            boolean isI = false;
            boolean isJ = false;
            double result1 = 0;
            double result2 = 0;
            while (true){
                if (medianIndexL == i+j+1){
                    if (isI == true){
                        result1 = nums1[i];
                    }
                    if (isJ == true){
                        result1 = nums2[j];
                    }
                }
                if (medianIndexR == i+j+2){
                    if (isI == true){
                        result2 = nums1[i];
                    }
                    if (isJ == true){
                        result2 = nums2[j];
                    }
                    System.out.println("totalLen:"+totalLen);
                    System.out.println("medianIndexL:"+medianIndexL);
                    System.out.println("medianIndexR:"+medianIndexR);
                    System.out.println("i:"+i);
                    System.out.println("j:"+j);
                    break;
                }
                if (nums1[i+1] <= nums2[j+1]){
                    i += 1;
                    isI = true;
                    isJ = false;
                }
                else{
                    j += 1;
                    isI = false;
                    isJ = true;
                }
            }
            result = (result1+result2)/2;
        }
        return result;
    }

    private static int[] arrayAppend(int[] nums){
        int[] tempArray = new int[nums.length+1];
        for (int i=0; i<nums.length; i++){
            tempArray[i] = nums[i];
        }
        tempArray[nums.length] = 100000000;
        return tempArray;
    }

    public static void main(String[] args) {
        ///
        ///int[] nums1 = {1,2};
        ///int[] nums2 = {3,4};
        ///double result = findMedianSortedArrays(nums1, nums2);
        ///System.out.println(result);
        ///
        System.out.println(3&1);
    }
}
