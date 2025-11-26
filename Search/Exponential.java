package Search;

public class Exponential {

    /**
     * Binary Search trong khoảng [left, right]
     */
    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Exponential Search
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        if (arr[0] == target) return 0; // kiểm tra đầu tiên

        int n = arr.length;
        int bound = 1;

        // Tăng số mũ để tìm khoảng chứa target
        while (bound < n && arr[bound] < target) {
            bound *= 2;
        }

        // Binary Search trong khoảng [bound/2, min(bound, n-1)]
        return binarySearch(arr, bound / 2, Math.min(bound, n - 1), target);
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 70;

        int index = search(numbers, target);
        System.out.println(index != -1 ? "Found at index: " + index : "Not found!");
    }
}
