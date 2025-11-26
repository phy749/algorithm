package Search;
public class Jump {

    /**
     * Jump Search
     * @param arr Mảng đã sắp xếp tăng dần
     * @param target Giá trị cần tìm
     * @return index của target; -1 nếu không tìm thấy
     */
    public static int jumpSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int n = arr.length;
        int step = (int) Math.sqrt(n); // kích thước block
        int prev = 0;

        // Tìm block chứa target
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1; // không tìm thấy
        }

        // Linear search trong block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) return i;
        }

        return -1; // không tìm thấy
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80};
        int target = 50;

        int index = jumpSearch(numbers, target);
        System.out.println(index != -1 ? "Found at index: " + index : "Not found!");
    }
}
