class Inventory {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Inventory next;

    public Inventory(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private Inventory head;

    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemId, quantity, price);
        newInventory.next = head;
        head = newInventory;
    }

    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemId, quantity, price);
        if (head == null) {
            head = newInventory;
            return;
        }
        Inventory current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newInventory;
    }

    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Inventory newInventory = new Inventory(itemName, itemId, quantity, price);

        if (position == 0) {
            newInventory.next = head;
            head = newInventory;
            return;
        }

        Inventory current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current != null) {
            newInventory.next = current.next;
            current.next = newInventory;
        } else {
            System.out.println("Position not found");
        }
    }

    public void deleteByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Inventory current = head;
        Inventory previous = null;
        while (current != null && current.itemId != itemId) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Item with item id " + itemId + " not found");
            return;
        }
        previous.next = current.next;
    }

    public void updateQuantityByItemId(int itemId, int quantity) {
        Inventory current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = quantity;
                System.out.println("Updated quantity for " + current.itemName + " is: " + current.quantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with item id " + itemId + " not found");
    }

    public Inventory searchItemByItemId(int itemId) {
        Inventory current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Inventory searchItemByItemName(String itemName) {
        Inventory current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public double calculateTotalInventoryValue() {
        double totalValue = 0;
        Inventory current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        return totalValue;
    }

    public void sortInventoryByItemNameAscending() {
        head = mergeSortByItemName(head);
    }

    public void sortInventoryByItemNameDescending() {
        head = mergeSortByItemNameDescending(head);
    }

    public void sortInventoryByPriceAscending() {
        head = mergeSortByPrice(head);
    }

    public void sortInventoryByPriceDescending() {
        head = mergeSortByPriceDescending(head);
    }

    private Inventory mergeSortByItemName(Inventory head) {
        if (head == null || head.next == null) {
            return head;
        }
        Inventory middle = getMiddle(head);
        Inventory nextOfMiddle = middle.next;
        middle.next = null;
        Inventory left = mergeSortByItemName(head);
        Inventory right = mergeSortByItemName(nextOfMiddle);
        return mergeByItemName(left, right);
    }

    private Inventory mergeSortByItemNameDescending(Inventory head) {
        if (head == null || head.next == null) {
            return head;
        }
        Inventory middle = getMiddle(head);
        Inventory nextOfMiddle = middle.next;
        middle.next = null;
        Inventory left = mergeSortByItemNameDescending(head);
        Inventory right = mergeSortByItemNameDescending(nextOfMiddle);
        return mergeByItemNameDescending(left, right);
    }

    private Inventory mergeSortByPrice(Inventory head) {
        if (head == null || head.next == null) {
            return head;
        }
        Inventory middle = getMiddle(head);
        Inventory nextOfMiddle = middle.next;
        middle.next = null;
        Inventory left = mergeSortByPrice(head);
        Inventory right = mergeSortByPrice(nextOfMiddle);
        return mergeByPrice(left, right);
    }

    private Inventory mergeSortByPriceDescending(Inventory head) {
        if (head == null || head.next == null) {
            return head;
        }
        Inventory middle = getMiddle(head);
        Inventory nextOfMiddle = middle.next;
        middle.next = null;
        Inventory left = mergeSortByPriceDescending(head);
        Inventory right = mergeSortByPriceDescending(nextOfMiddle);
        return mergeByPriceDescending(left, right);
    }

    private Inventory getMiddle(Inventory head) {
        if (head == null) {
            return head;
        }
        Inventory slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Inventory mergeByItemName(Inventory left, Inventory right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.itemName.compareTo(right.itemName) <= 0) {
            left.next = mergeByItemName(left.next, right);
            return left;
        } else {
            right.next = mergeByItemName(left, right.next);
            return right;
        }
    }

    private Inventory mergeByItemNameDescending(Inventory left, Inventory right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.itemName.compareTo(right.itemName) > 0) {
            left.next = mergeByItemNameDescending(left.next, right);
            return left;
        } else {
            right.next = mergeByItemNameDescending(left, right.next);
            return right;
        }
    }

    private Inventory mergeByPrice(Inventory left, Inventory right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.price <= right.price) {
            left.next = mergeByPrice(left.next, right);
            return left;
        } else {
            right.next = mergeByPrice(left, right.next);
            return right;
        }
    }

    private Inventory mergeByPriceDescending(Inventory left, Inventory right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.price > right.price) {
            left.next = mergeByPriceDescending(left.next, right);
            return left;
        } else {
            right.next = mergeByPriceDescending(left, right.next);
            return right;
        }
    }

    	public void displayItems() {
        	if (head == null) {
            	System.out.println("Inventory is empty");
           	return;
        	}
        	Inventory current = head;
        	while (current != null) {
            		System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId + 
                               ", Quantity: " + current.quantity + ", Price: " + current.price);
            	current = current.next;
        }
    }
}

class InventorySystem {
    public static void main(String[] args) {
        InventoryLinkedList inventoryList = new InventoryLinkedList();

        inventoryList.addItemAtBeginning("Item A", 101, 20, 15.5);
        inventoryList.addItemAtEnd("Item B", 102, 50, 25.0);
        inventoryList.addItemAtEnd("Item C", 103, 10, 5.0);
        
        System.out.println("All Inventory Items:");
        inventoryList.displayItems();

        System.out.println("\nUpdating quantity for item with item ID 102:");
        inventoryList.updateQuantityByItemId(102, 60);
        
        System.out.println("\nTotal Inventory Value: " + inventoryList.calculateTotalInventoryValue());

        System.out.println("\nSorting by Item Name (Ascending):");
        inventoryList.sortInventoryByItemNameAscending();
        inventoryList.displayItems();
        
        System.out.println("\nSorting by Price (Descending):");
        inventoryList.sortInventoryByPriceDescending();
        inventoryList.displayItems();
    }
}
