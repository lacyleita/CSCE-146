//Written By Lacy Leita
//Last Edited 10/30/2025
import java.util.*;
public class Sort {

    public static void quickSort(String[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high); // recursive
			quickSort(arr, low, pivot-1); //items less than arr[pivot]
			quickSort(arr, pivot+1, high); //items greater than arr[pivot]
		}
	}
	// return the position of the pivot element
	public static int partition(String[] arr, int low, int high) {
		String pivot = arr[high]; //designate the last element to be the pivot
        int pivotCount = howManySort(pivot);
		int i = low - 1; //out of the array
		//compare every element to pivot
		for (int j = low; j < high; j++) {
			if (howManySort(arr[j]) <= pivotCount) {
				i++;
				//swap arr[i] and arr[j]
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// place pivot in its proper position
		String temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}

    //getSize method: returns the size of the arr the user inserts without the null elements
    public static int getSize(String[] arr){
        int size = 0;
        for(String w: arr){
            if(w != null){
                size++;
            }
            }
            return size;
        }
    
        //newArr method: returns the new array made with just the elements the user provides
    public static String[] newArr(String[] arr){
        String[] newArr = new String[getSize(arr)];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                newArr[i] = arr[i];
            }
        }
        return newArr;
        }
    //counts how many items we need to sort
    public static int howManySort(String line){
        if(line != null){
            line = line.toLowerCase();
            int count = 0;
            int i = 0;
            while ((i = line.indexOf("sort", i)) != -1){
                count++;
                i+=4;
            }
            return count;
        }
        return 0;
    }
    // prints array
    public static void printArray(String [] arr){
        for(int i = 0; i < arr.length; i++){
        if(arr[i] != null){
            System.out.println(arr[i]);
        } System.out.println(" ");
        
    }}

    //runs the code, enables the loop.
    public static void run(){
        System.out.println("Enter any number of strings and I will sort by SORT's.' Once you're done entering sentences enter 'quit'.");
        Scanner scan = new Scanner(System.in);
        String[] arr = new String[100];
        int i = 0;
        String s;

        while (true){
            s = scan.nextLine();
            s.toLowerCase();
            if(s.equalsIgnoreCase("quit")){
                break;
            }
            arr[i] = s;
            i++;
        }

        String[] arr1 = newArr(arr);
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(" ");
        System.out.println("sort Sorted!");
        System.out.println(" ");
        printArray(arr1);
        System.out.println("Do you want to sort again?");
        String a = null;
        a = scan.nextLine();
        if(a.equalsIgnoreCase("yes")){
            run();
        } else {
            System.out.println("Goodbye!");
        }

    }

    public static void main(String[] args) {
        run();
    }}