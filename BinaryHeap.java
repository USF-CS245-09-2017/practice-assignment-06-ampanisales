/**
 * @author Anthony Panisales
 */

public class BinaryHeap {
	
	int[] arr;
	int size;
	
	public BinaryHeap() {
		arr = new int[10];
		size = 0;
	}
	
	public int parent(int index) {
		return (index-1)/2;
	}
	
	public int leftChild(int index) {
		return index*2+1;
	}
	
	public int rightChild(int index) {
		return index*2+2;
	}
	
	public void swap(int indexA, int indexB) {
		int temp = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = temp;
	}
	
	public void growHeap() {
		int[] newArr = new int[arr.length*2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	public void add(int priority) {
		if (size == arr.length) {
			growHeap();
		}
		arr[size++] = priority;
		int index = size-1;
		while (arr[index] < arr[parent(index)] && index > 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public int remove()  {
		if (size == 0) {
			return -1;
		}
		int removed = arr[0];
		arr[0] = arr[--size];
		if (size == 0) {
			return removed;
		}
		int index = 0;
		int child = leftChild(index);
		if (arr[child] > arr[rightChild(index)] && rightChild(index) < size) {
			child = rightChild(index);
		}
		while (arr[child] < arr[index] && child < size) {
			swap(index, child);
			index = child;
			if (leftChild(index) < size) {
				child = leftChild(index);
				if (arr[child] > arr[rightChild(index)] && rightChild(index) < size) {
					child = rightChild(index);
				}
			} else {
				break;
			}
		}
		return removed;
	}
}
