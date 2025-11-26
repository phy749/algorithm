package Search;

public class Interpolation {

    /**
     * Interpolation Search
     * @param arr Mảng đã sắp xếp tăng dần
     * @param target Giá trị cần tìm
     * @return index của target; -1 nếu không tìm thấy
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right && target >= arr[left] && target <= arr[right]) {
            // Tránh chia cho 0
            if (arr[left] == arr[right]) {
                if (arr[left] == target) return left;
                else return -1;
            }

            // Ước lượng vị trí
            int pos = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left]);

            if (arr[pos] == target) {
                return pos;
            } else if (arr[pos] < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }

        return -1; // không tìm thấy
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80};
        int target = 60;

        int index = search(numbers, target);
        System.out.println(index != -1 ? "Found at index: " + index : "Not found!");
    }
}
