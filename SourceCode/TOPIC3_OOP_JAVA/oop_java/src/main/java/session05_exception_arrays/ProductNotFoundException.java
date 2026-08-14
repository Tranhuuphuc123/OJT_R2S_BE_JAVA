package session05_exception_arrays;

/* class này dùng để Kế thừa từ `Exception`, dùng để ném 
    ngoại lệ khi tìm kiếm hoặc cập nhật sản phẩm không tồn tại
    trong hệ thống. */
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
