
        class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxProduct = nums[0];  // Initialize with the first element
        int currentProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            currentProduct *= nums[i];
            maxProduct = Math.max(maxProduct, currentProduct);

            // Reset if currentProduct is zero
            if (currentProduct == 0) {
                currentProduct = 1;  // Start fresh for the next potential subarray
            }
        }

        // We should also check for negative products by restarting the calculation
        currentProduct = 1;  // Reset for the next pass
        for (int i = nums.length - 1; i >= 0; i--) {
            currentProduct *= nums[i];
            maxProduct = Math.max(maxProduct, currentProduct);

            if (currentProduct == 0) {
                currentProduct = 1;  // Reset again if zero
            }
        }

        return maxProduct;
    }
}