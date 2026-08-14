package session06_collections;

// ĐÃ XÓA: import entities.Course; (Vì chung package nên không cần nữa)
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lớp Validator - Chứa các phương thức kiểm tra tính hợp lệ của dữ liệu khóa
 * học
 * Tuân thủ nguyên lý Single Responsibility: chỉ quản lý validation logic
 * Sử dụng Utility Class Pattern: constructor private, tất cả method đều static
 * Mục đích: Tập trung logic validate, không phụ thuộc vào trạng thái
 * (stateless)
 */
public final class Validator {
    // Constructor private để ngăn chặn việc khởi tạo instance
    private Validator() {
    }

    /**
     * Kiểm tra xem mã khóa học (code) có hợp lệ không
     * 
     * Quy tắc: Code phải khớp với pattern ^RA\d{3}$ (RA + 3 chữ số)
     * Ví dụ hợp lệ: "RA001", "RA999", "RA123"
     * Ví dụ không hợp lệ: null, "", "RA01", "ABC123", "ra001" (lowercase)
     * 
     * @param code Chuỗi cần kiểm tra
     * @return true nếu code khớp regex, false nếu code null hoặc không khớp
     */
    public static boolean validateCode(String code) {
        // code != null: Đảm bảo code không phải null trước khi gọi matches()
        // code.matches(): So sánh chuỗi với regex từ Constants.COURSE_CODE_REGEX
        return code != null && code.matches(Constants.COURSE_CODE_REGEX);
    }

    /**
     * Kiểm tra xem code đã tồn tại trong danh sách khóa học chưa
     * (Ngăn chặn trùng lặp)
     * 
     * Quy tắc: So sánh không phân biệt hoa/thường (case-insensitive)
     * Ví dụ: "RA001" == "ra001" == "Ra001" -> đều được coi là trùng
     * 
     * @param code    Mã khóa học cần kiểm tra
     * @param courses Danh sách tất cả khóa học hiện có
     * @return true nếu code đã tồn tại, false nếu chưa có code này
     */
    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        // Dùng Stream API để duyệt qua danh sách:
        // - stream(): Chuyển ArrayList thành stream để xử lý hàm loại
        // - anyMatch(): Trả về true nếu ít nhất 1 phần tử thỏa điều kiện
        // - equalsIgnoreCase(): So sánh không phân biệt chữ hoa/thường
        return courses.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(code));
    }

    /**
     * Kiểm tra xem flag (nhãn) có hợp lệ không
     * 
     * Quy tắc: Flag phải là một trong các giá trị: "optional", "prerequisite",
     * "N/A"
     * Không phân biệt hoa/thường: "OPTIONAL" == "optional" == "Optional"
     * Ví dụ hợp lệ: "optional", "prerequisite", "N/A"
     * Ví dụ không hợp lệ: null, "", "invalid", "core"
     * 
     * @param flag Chuỗi cần kiểm tra
     * @return true nếu flag nằm trong danh sách hợp lệ, false nếu không
     */
    public static boolean validateFlag(String flag) {
        // Kiểm tra null trước tiên để tránh NullPointerException
        if (flag == null)
            return false;

        // Chuẩn hóa chuỗi: trim() loại bỏ khoảng trắng ở đầu/cuối
        // VD: " optional " -> "optional"
        String normalizedFlag = flag.trim();

        // Dùng Stream API để so sánh với danh sách hợp lệ:
        // - Arrays.stream(Constants.ALLOWED_FLAGS): Chuyển mảng thành stream
        // - anyMatch(): Trả về true nếu bất kỳ flag nào khớp (case-insensitive)
        // - equalsIgnoreCase(): Bỏ qua chữ hoa/thường
        return Arrays.stream(Constants.ALLOWED_FLAGS)
                .anyMatch(a -> a.equalsIgnoreCase(normalizedFlag));
    }

    /**
     * Kiểm tra xem thời lượng khóa học (duration) có hợp lệ không
     * 
     * Quy tắc: Duration phải là số dương (> 0)
     * Ví dụ hợp lệ: 10, 20, 30, 100, 999
     * Ví dụ không hợp lệ: 0, -5, -1
     * 
     * @param duration Số giờ/ngày học của khóa học (kiểu short)
     * @return true nếu duration > 0, false nếu duration <= 0
     */
    public static boolean validateDuration(short duration) {
        // Đơn giản: chỉ cần kiểm tra duration lớn hơn 0
        return duration > 0;
    }
}