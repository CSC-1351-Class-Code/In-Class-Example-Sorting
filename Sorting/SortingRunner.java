package Sorting;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class SortingRunner {
	public static void main(String[] args){
		timeSorting();
	}

	public static void timeSorting(){
		long start;
		long end;
		for(int size = 10; size <= 100000000; size *= 10){
			int[] arr = makearr(size);
			int[] arrCopy = arr.clone();

			System.out.printf("Arrays of size %d%n", size);

			// We only want to run our n^2 algorithms when the array size is
			// relatively small
			if(size <= 100000){
				start = System.nanoTime();
				bubbleSort(arrCopy);
				end = System.nanoTime();
				System.out.printf("\tBubble sort took %d milliseconds%n", (end-start)/1000);
				arrCopy = arr.clone();

				start = System.nanoTime();
				bubbleSortSC(arrCopy);
				end = System.nanoTime();
				System.out.printf("\tBubble sort with short circuit took %d milliseconds%n", (end-start)/1000);
				arrCopy = arr.clone();

				start = System.nanoTime();
				selectionSort(arrCopy);
				end = System.nanoTime();
				System.out.printf("\tSelection sort took %d milliseconds%n", (end-start)/1000);
				arrCopy = arr.clone();


				start = System.nanoTime();
				insertionSort(arrCopy);
				end = System.nanoTime();
				System.out.printf("\tInsertion sort took %d milliseconds%n", (end-start)/1000);
				arrCopy = arr.clone();
			}

			start = System.nanoTime();
			mergeSort(arrCopy);
			end = System.nanoTime();
			System.out.printf("\tMerge sort took %d milliseconds%n", (end-start)/1000);
			arrCopy = arr.clone();

			start = System.nanoTime();
			quickSort(arrCopy);
			end = System.nanoTime();
			System.out.printf("\tQuick sort took %d milliseconds%n", (end-start)/1000);
			arrCopy = arr.clone();

		}
	}

	// Function to make a random array
	public static int[] makearr(int size){
		int[] arr = new int[__];

		__ rng = new __();
		//int bound = 10;
		int bound = Integer.MAX_VALUE;

		for(int i = 0; i < size; i++){
			arr[i] = rng.__(bound);
		}

		return arr;
	}

	// Function to print out our array
	public static void printarr(int[] arr){
		System.out.print("[");

		for(int e : arr){
			System.out.printf("%d, ", e);
		}

		System.out.println("]");
	}

	public static void bubbleSort(int[] arr){
		for(int i = 0; i < arr.length-1; i++){

			for(int j = 0; j<arr.length-i-1; j++){

				if(arr[j] > arr[j+1]){
					int __ = arr[__];
					arr[__] = arr[__];
					arr[__] = __;
				}
			}
		}
	}

	public static void bubbleSortSC(int[] arr){
		for(int i = 0; i < arr.length-1; i++){
			boolean swap  = __;

			for(int j = 0; j < arr.length-i-1; j++){
				if(arr[j] > arr[j+1]){
					int __ =  arr[_];
					arr[__] = arr[__];
					arr[__] = __;
					swap = __;
				}
			}

			if(!swap){
				__;
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for(int i=0; i< arr.length-1; i++){
			int __ = i;

			for(int j=i+1; j<arr.length; j++){
				if(arr[j]<arr[__]){
					__ = __;
				}
			}

			int smallerNumber = arr[__];
			arr[__] = arr[__];
			arr[__] = __;
		}
	}

	public static void insertionSort(int[] arr) {
		int i;
		int key;
		int j;

		for (i = 1; i < arr.length; i++){
			key = arr[i];
			j = i - 1;

			while (j >= 0 && arr[__] > __){
				arr[__] = arr[__];
				j = j - 1;
			}

			arr[j + 1] = key;
		}
	}

	public static void mergeSort(int[] arr) {
		if (arr.length < __){
			return;
		}

		int mid = arr.length / 2;
		int[] l = new int[mid];
		int[] r = new int[arr.length - mid];

		for (int i = 0; i < mid; i++){
			l[i] = arr[i];
		}

		for (int i = mid; i < arr.length; i++){
			r[i - mid] = arr[i];
		}

		mergeSort(l);
		mergeSort(r);

		merge(arr, l, r, mid, arr.length - mid);
	}

	public static void merge(int[] array, int[] l, int[] r, int left, int right) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < __ && j < __) {
			if (l[i] <= r[j]) {
				array[k] = l[i];
				i++;
			}
			else {
				array[k] = r[j];
				j++;
			}
			k++;
		}

		while (i < __){
			array[k++] = l[i++];
		}

		while (j < __){
			array[k++] = r[j++];
		}
	}

	public static void quickSort(int[] arr){
		Stack<int[]> stack = new Stack();
		int l,h;


		int[] bounds = {0,arr.length -1};
        stack.push(bounds);

        while (!stack.isEmpty()) {
			bounds = stack.pop();
			l = bounds[0];
            h = bounds[1];

            int p = partition(arr, l, h);

            if (p - 1 > l) {
				bounds[0] = l;
				bounds[1] = p - 1;
				stack.push(bounds);
            }

            if (p + 1 < h) {
				bounds[0] = p + 1;
				bounds[1] = h;
				stack.push(bounds);
            }
        }
	}


	public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
