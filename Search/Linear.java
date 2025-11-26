package Search;
/**
 * LinearSearch: triển khai thuật toán tìm kiếm tuyến tính.
 * Tìm vị trí của phần tử cần tìm trong mảng.
 */
import java.util.ArrayList;
import java.util.List;

public class Linear {

    /**
     * Tìm giá trị target trong mảng arr bằng cách duyệt qua các thành phần trong mảng nếu  có 3 phần tử giống nhau trả về vị trí đầu tiên.
     * Nếu muốn tìm tất cả phải thêm t
     * @param arr    Mảng số cần tìm
     * @param target Giá trị cần tìm
     * @return vị trí (index) của target; nếu không tìm thấy trả về -1
     */
    public static int[] search(int[] arr, int target) {
        // Kiểm tra mảng null để tránh NullPointerException
        if (arr == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result.add(i); // Trả về vị trí khi tìm thấy
            }

        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {10, 30,  20, 30, 40, 50, 30, 40 ,30 };
        int target = 30;

        int[] index = search(numbers, target);

        if (index.length > 0) {
            System.out.print("Found at indexes: ");
            for (int idx : index) {
                System.out.print(idx + " ");
            }
        } else {
            System.out.println("Not found!");
        }
    }
}
