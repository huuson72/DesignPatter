package Strategy;

public class BubbleSort implements Strategy {
	 public void execute(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = n - 1; j > i; j--) {
	                if (arr[j] < arr[j - 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j - 1];
	                    arr[j - 1] = temp;
	                }
	            }
	        }
	    }

}
