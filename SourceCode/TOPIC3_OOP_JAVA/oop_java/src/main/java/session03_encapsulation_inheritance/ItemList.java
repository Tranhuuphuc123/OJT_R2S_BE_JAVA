package session03_encapsulation_inheritance;

/*Class `ItemlistItem`: Quản lý danh sách các Item bằng mảng cố định (tối đa 100 phần tử), 
    thực hiện các chức năng: Thêm, Hiển thị tất cả, Tìm theo tác giả, Cập nhật theo ID, 
    Lọc theo loại (Vase/Statue/Painting). */
public class ItemList {
    private Item[] listItem;
    private int count; //
    private final int MAX = 100;

    // contructor
    public ItemList() {
        listItem = new Item[MAX];
        count = 0;
    }

    // method addItem
    public boolean addItem(Item item) {
        if (item == null || count >= MAX) {
            return false;
        }
        listItem[count++] = item;
        return true;
    }

    // method displayAll
    public void displayAll() {
        if (count == 0) {
            System.out.println("The listItem is empty!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(listItem[i]);
        }
    }

    // method tim item
    public Item findItem(String creator) {
        if (creator == null)
            return null;
        for (int i = 0; i < count; i++) {
            if (listItem[i].getCreator().equalsIgnoreCase(creator.trim())) {
                return listItem[i];
            }
        }
        return null;
    }

    // method update
    public boolean updateItem(String id) {
        if (id == null)
            return false;
        for (int i = 0; i < count; i++) {
            if (listItem[i].getId().equalsIgnoreCase(id.trim())) {
                System.out.println("Updating item details for ID: " + id);
                listItem[i].input();
                return true;
            }
        }
        return false;
    }

    // method display type of Item
    public void displayItemsByType(String type) {
        if (type == null)
            return;
        String t = type.trim().toUpperCase();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (t.equals("VASE") && listItem[i] instanceof Vase) {
                System.out.println(listItem[i]);
                found = true;
            } else if (t.equals("STATUE") && listItem[i] instanceof Statue) {
                System.out.println(listItem[i]);
                found = true;
            } else if (t.equals("PAINTING") && listItem[i] instanceof Painting) {
                System.out.println(listItem[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found of type: " + type);
        }
    }

}
