import java.util.*;
class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;

    public CustomHashMap() {
        // Cast the array to LinkedList<Entry<K, V>>[] to avoid the warning
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update value if key already exists
                return;
            }
        }

        bucket.add(new Entry<>(key, value));  // Add new entry if key doesn't exist
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;  // Return null if key is not found
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove();  // Remove entry if key is found
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;  // Return false if key is not found
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println("a: " + map.get("a"));  // Output: a: 1
        System.out.println("b: " + map.get("b"));  // Output: b: 2
        System.out.println("c: " + map.get("c"));  // Output: c: 3

        map.remove("b");
        System.out.println("Contains key 'b': " + map.containsKey("b"));  // Output: Contains key 'b': false

        map.put("a", 4);  // Update value of 'a'
        System.out.println("Updated a: " + map.get("a"));  // Output: Updated a: 4
    }
}

