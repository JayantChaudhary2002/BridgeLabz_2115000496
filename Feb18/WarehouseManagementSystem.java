abstract class WarehouseItem{
	private String name;
	private double price;

	public WarehouseItem(String name, double price){
		this.name=name;
		this.price=price;
	}
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	@Override
	public String toString(){
		return "Item: "+name+", Price: "+price;
	}
}
class Electronics extends WarehouseItem{
	public Electronics(String name, double price){
		super(name,price);
	}
}
class Groceries extends WarehouseItem{
	public Groceries(String name, double price){
		super(name, price);
	}
}
class Furniture extends WarehouseItem{
	public Furniture(String name, double price){
		super(name, price);
	}
}
class Storage<T extends WarehouseItem>{
	private T[] items;
	private int currentIndex;

	@SuppressWarnings("unchecked")
	public Storage(int capacity){
		items=(T[]) new WarehouseItem[capacity];
		currentIndex=0;
	}

	public void addItem(T item){
		if(currentIndex<items.length){
			items[currentIndex++]=item;
		}
		else{
			System.out.println("Storage is full.");
		}
	}
	public T[] getItems(){
		return items;
	}
}
public class WarehouseManagementSystem{
	
	public static void displayItems(WarehouseItem[] items){
		for(WarehouseItem item : items){
			if(item!=null){
				System.out.println(item);
			}
		}
	}
	public static void main(String args[]){
		Electronics laptop=new Electronics("Laptop",55000);
		Groceries apple=new Groceries("Apple",150);
		Furniture chair=new Furniture("chair",1000);

		Storage<Electronics> electronicsStorage = new Storage<>(5);
		electronicsStorage.addItem(laptop);

		Storage<Groceries> groceriesStorage = new Storage<>(5);
		groceriesStorage.addItem(apple);

		Storage<Furniture> furnitureStorage = new Storage<>(5);
		furnitureStorage.addItem(chair);

		System.out.println("Electronics Storage:");
		displayItems(electronicsStorage.getItems());

		System.out.println("Groceries Storage:");
                displayItems(groceriesStorage.getItems());

		System.out.println("Furniture Storage:");
                displayItems(furnitureStorage.getItems());
	}
}
