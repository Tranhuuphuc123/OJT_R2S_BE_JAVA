public class ItemList {
    Item[] list; // mảng chứa các đối tượng kiểu item
    int numOfItem; // so luong do co hien co
    final int MAX = 100; // suc chua toi da cua mang

    // contructor
    public ItemList() {
        list = new Item[MAX];
    }
}
