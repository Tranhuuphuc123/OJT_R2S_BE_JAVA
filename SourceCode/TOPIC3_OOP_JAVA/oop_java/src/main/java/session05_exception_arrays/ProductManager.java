package session05_exception_arrays;

public class ProductManager {
    private Product[] listPro = new Product[10];
    private int productCount = 0;

    // method addProduct
    public void addProduct(Product product) throws IllegalArgumentException {
        if (productCount >= listPro.length) {
            System.out.println("Cannot add product. Stock list is full");
            return;
        }

        if (product.getPrice() < 0 || product.getQuantityInStock() < 0) {
            throw new IllegalArgumentException("Price and quanity must be non negative(khong am) ");
        }

        for (int i = 0; i < productCount; i++) {
            if (listPro[i].getProductID() == product.getProductID()) {
                throw new IllegalArgumentException("Product ID already exists!");
            }
        }

        listPro[productCount++] = product;
        System.out.println("Product added successfully!");
    }

    // method tim kiem theo id
    public Product getProductByID(int productID) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (listPro[i].getProductID() == productID) {
                return listPro[i];
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }

    // method update
    public void updateProductQuantity(int productID, int newQuantity)
            throws ProductNotFoundException, IllegalArgumentException {

        if (newQuantity < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }

        Product product = getProductByID(productID);
        product.setQuantityInStock(newQuantity);
        System.out.println("Product quantity updated successfully.");
    }
}
