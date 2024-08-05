package Main;

public class MyArrayList implements List{
    private int[] array;
    private int size;
    private final int DEFAULT_MEMORY_ALLOCATION = 10;
    private int memoryAllocated = DEFAULT_MEMORY_ALLOCATION;

    public MyArrayList(){
        array = new int[DEFAULT_MEMORY_ALLOCATION];
    }

    @Override
    public void add(int i) {
        size++;
        if (size > memoryAllocated){
            memoryAllocated += DEFAULT_MEMORY_ALLOCATION;
            var newArray = new int[memoryAllocated];
            System.arraycopy(array, 0, newArray, 0, 0);
            array = newArray;
        }
        array[size - 1] = i;
    }

    @Override
    public void add(int i, int index) {
        size++;
        memoryAllocated++;
        int[] newArray = new int[array.length + 1];
        newArray[index] = i;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        array = newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        size--;
        var newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
    }

    @Override
    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("[Index: "+index+", Range: "+(size - 1)+"]");
        }
        return array[index];
    }

}
