
package setCollection;


public class SetCollection {
    private int size;
    private int[] data;

    // Конструкторы
    public SetCollection() {
        this.size = 0;
        this.data = new int[0];
    }

    public SetCollection(int[] initialData, int initialSize) {
        if (initialData == null || initialSize < 0 || initialSize > initialData.length) {
            System.out.println("Invalid initial data or size");
        }
        
        // Сортируем и удаляем дубликаты
        this.data = initialData;
        this.size = initialSize;
        bubbleSort();
        removeDuplicates();

    }

    public SetCollection(SetCollection other){
        this.size = other.size;
        this.data = new int[size];
        System.arraycopy(other.data, 0, this.data, 0, other.size);
    }

    // Сортировка пузырьком
    private void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Удаление повторений
    private void removeDuplicates() {
        if (size == 0) return;
        
        int uniqueCount = 1;
        for (int i = 1; i < size; i++) {
            if (data[i] != data[i - 1]) {
                data[uniqueCount] = data[i];
                uniqueCount++;
            }
        }
        
        // Обрезаем массив до уникальных элементов
        int[] newData = new int[uniqueCount];
        System.arraycopy(data, 0, newData, 0, uniqueCount);
        this.data = newData;
        this.size = uniqueCount;
    }

    // Добавление элемента
    public void AddElement(int value) {
        if (!Contains(value)) {
            int[] newData = new int[size + 1];
            
            // Копируем все существующие элементы
            System.arraycopy(data, 0, newData, 0, size);
            // Находим позицию для вставки
            int insertPos = 0;
            while (insertPos < size && data[insertPos] < value) {
                insertPos++;
            }
            
            // Копируем элементы до позиции вставки
            System.arraycopy(data, 0, newData, 0, insertPos);
            
            // Вставляем новый элемент
            newData[insertPos] = value;
            
            // Копируем оставшиеся элементы
            System.arraycopy(data, insertPos, newData, insertPos + 1, size - insertPos);
            
            this.data = newData;
            this.size++;
        }
    }

    // Удаление элемента множества
    public void RemoveElement(int value){
        if (Contains(value)){
            // Находим позицию элемента в множестве
            int indPos = binarySearch(value);
            int[] newData = new int[size - 1];
            for (int i = 0, j = 0; i < size; i++) {
                if (i != indPos) {
                    newData[j++] = data[i];
                }
            }
            this.data = newData;
            this.size--;
        }
    }

    public boolean Contains(int value){
        return binarySearch(value) != -1;
    }

    // Бинарный поиск
    private int binarySearch(int value) {
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == value) {
                return mid;
            } else if (data[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Вывод множества
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(data[i]);
        }
        sb.append("}");
        return sb.toString();
    }
}