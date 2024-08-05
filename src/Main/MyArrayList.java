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
        handleMemoryAllocation();
        array[size] = i;
        size++;
    }

    @Override
    public void add(int i, int index) {
        handleOutOfBounds(index, size);
        handleMemoryAllocation();
        System.arraycopy(array, index, array, index + 1 ,array.length - index - 1);
        array[index] = i;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        handleOutOfBounds(index, size - 1);
        System.arraycopy(array, index + 1, array, index, size - 1);
        size--;
    }

    @Override
    public int get(int index) {
        handleOutOfBounds(index, size - 1);
        return array[index];
    }

    private void handleOutOfBounds(int index, int size){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("[Index: "+index+", Range: "+size+"]");
        }
    }

    private void handleMemoryAllocation() {
        if (size + 1 > memoryAllocated){
            memoryAllocated += DEFAULT_MEMORY_ALLOCATION;
            var newArray = new int[memoryAllocated];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

}
