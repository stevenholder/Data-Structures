public class Bubblesort{ 
    private static void bubbleSort(Comparable[] array) {
    	Comparable temp;
        int counter, index;
       
        for(counter=0; counter<array.length-1; counter++) { //Loop once for each element in the array.
            for(index=0; index<array.length-1-counter; index++) { //Once for each element, minus the counter.
                if(array[index].compareTo(array[index+1]) > 0) { //Test if need a swap or not.
                    temp = array[index]; //These three lines just swap the two elements:
                    array[index] = array[index+1];
                    array[index+1] = temp;
                }
            }
            /*
			for(Comparable c : array ){
				System.out.println(c);
			}
			System.out.println();
			*/
        }
    }
    
    public static void selectionSort(Comparable[] x) {
        for (int i=0; i<x.length-1; i++) {
            for (int j=i+1; j<x.length; j++) {
                if (x[i].compareTo(x[j]) > 0) {
                    Comparable temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(Comparable[] array){
        for (int i = 1; i < array.length; i++){
          int j = i;
          Comparable B = array[i];
          while ((j > 0) && (array[j-1].compareTo(B) > 0)){
            array[j] = array[j-1];
            j--;
          }
          array[j] = B;
        }
      }
	
    public static void main(String[] args) {
        Comparable unsortedArray[] = {10, 97, 6, 23, 0, -45, 697, -1000, 1, 0}; 
       
        //bubbleSort(unsortedArray); 
        //selectionSort(unsortedArray); 
        insertionSort(unsortedArray); 
       
        System.out.println("After sorting, the list elements are: "); 
       
        for(int i=0; i<unsortedArray.length; i++) {
            System.out.print(unsortedArray[i] + " ");
        }
    }
}   