package session06_collections;

/**
 * Lớp Constants - Chứa tất cả các hằng số cấu hình cho chương trình quản lý
 * khóa học
 * Sử dụng pattern Utility Class: constructor private và các thành viên static
 * final
 * Mục đích: Tập trung các giá trị không đổi, dễ bảo trì và tái sử dụng
 */
public final class Constants {
    // Constructor private để ngăn chặn việc khởi tạo instance (đây là utility
    // class)
    private Constants() {
    }

    // ==================== CÁC GIỚI HẠN KHÓA HỌC (FLAGS) ====================
    /** Flag "optional": Khóa học tùy chọn, không bắt buộc */
    public static final String FLAG_OPTIONAL = "optional";

    /** Flag "prerequisite": Khóa học tiên quyết, bắt buộc phải học trước */
    public static final String FLAG_PREREQUISITE = "prerequisite";

    /** Flag "N/A": Không áp dụng (trạng thái trung lập) */
    public static final String FLAG_NA = "N/A";

    /**
     * Mảng chứa tất cả các giá trị Flag hợp lệ - dùng để validate input của người
     * dùng
     */
    public static final String[] ALLOWED_FLAGS = { FLAG_OPTIONAL, FLAG_PREREQUISITE, FLAG_NA };

    // ==================== REGEX VÀ QUY TẮC ĐỊNH DẠNG ====================
    /**
     * Regex cho mã khóa học: ^RA\d{3}$
     * - ^ : Bắt đầu chuỗi
     * - RA : Bắt buộc bắt đầu với "RA"
     * - \d{3} : Theo sau là đúng 3 chữ số (0-9)
     * - $ : Kết thúc chuỗi
     * Ví dụ hợp lệ: RA001, RA999, RA123
     * Ví dụ không hợp lệ: RA01 (thiếu chữ số), ABC123, RA1234 (thừa chữ số)
     */
    public static final String COURSE_CODE_REGEX = "^RA\\d{3}$";

    // ==================== LỰA CHỌN MENU ====================
    /** Menu option 1: Thêm khóa học mới (Create) */
    public static final int MENU_CREATE = 1;

    /** Menu option 2: Tìm kiếm khóa học theo tiêu chí (Search) */
    public static final int MENU_SEARCH = 2;

    /** Menu option 3: Hiển thị danh sách khóa học theo Flag (Display by Flag) */
    public static final int MENU_DISPLAY_BY_FLAG = 3;

    /** Menu option 0: Thoát chương trình (Quit) */
    public static final int MENU_QUIT = 0;

    // ==================== ĐỊNH DẠNG BẢNG HIỂN THỊ ====================
    /**
     * Tiêu đề bảng (TABLE HEADER) với cách căn chỉnh cứng định:
     * %-6s : CODE - căn trái, chiều rộng 6 ký tự
     * %-20s : NAME - căn trái, chiều rộng 20 ký tự
     * %-6s : STATUS - căn trái, chiều rộng 6 ký tự
     * %-8s : DURATION - căn trái, chiều rộng 8 ký tự
     * %-12s : FLAG - căn trái, chiều rộng 12 ký tự
     * Dùng String.format() để tạo header căn chỉnh đẹp mắt khi in danh sách
     */
    public static final String TABLE_HEADER = String.format("%-6s | %-20s | %-6s | %-8s | %-12s",
            "CODE", "NAME", "STATUS", "DURATION", "FLAG");
}