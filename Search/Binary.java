package Search;
/**
 * Triển khai Binary Search dạng iterative.
 * Yêu cầu mảng phải được sắp xếp tăng dần.
 */
public class Binary {

    /**
     * Tìm kiếm target trong mảng arr bằng Binary Search.
     *
     * @param arr    Mảng đã được sắp xếp
     * @param target Giá trị cần tìm
     * @return index của target; không tìm thấy trả về -1
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Tính middle tránh overflow bằng cách không dùng (left + right) / 2
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                right = mid - 1; // thu hẹp về nửa trái
            } else {
                left = mid + 1;  // thu hẹp về nửa phải
            }
        }

        return -1; // không tìm thấy
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};
        int target = 40;

        int index = search(numbers, target);

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not found!");
        }
    }
}
