package Search;

public class Fibonacci {

    /**
     * Tìm số Fibonacci nhỏ nhất >= n
     */
    private static int fibCeil(int n) {
        int fibM_minus_2 = 0; // F(n-2)
        int fibM_minus_1 = 1; // F(n-1)
        int fibM = fibM_minus_1 + fibM_minus_2; // F(n)

        while (fibM < n) {
            fibM_minus_2 = fibM_minus_1;
            fibM_minus_1 = fibM;
            fibM = fibM_minus_1 + fibM_minus_2;
        }
        return fibM;
    }

    /**
     * Fibonacci Search
     */
    public static int search(int[] arr, int target) {
        int n = arr.length;

        // Initialize Fibonacci numbers
        int fibM_minus_2 = 0; // F(m-2)
        int fibM_minus_1 = 1; // F(m-1)
        int fibM = fibM_minus_1 + fibM_minus_2; // F(m)

        // Find the smallest Fibonacci number >= n
        while (fibM < n) {
            fibM_minus_2 = fibM_minus_1;
            fibM_minus_1 = fibM;
            fibM = fibM_minus_1 + fibM_minus_2;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM_minus_2, n - 1);

            if (arr[i] < target) {
                fibM = fibM_minus_1;
                fibM_minus_1 = fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibM_minus_2;
                fibM_minus_1 = fibM_minus_1 - fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
            } else {
                return i; // tìm thấy
            }
        }

        // Kiểm tra phần tử còn lại
        if (fibM_minus_1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1;
        }

        return -1; // không tìm thấy
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 50;

        int index = search(numbers, target);
        System.out.println(index != -1 ? "Found at index: " + index : "Not found!");
    }
}
