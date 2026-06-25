public class sortedArray{
	public boolean isSorted(int[] arr){
		for(int i=1;i<arr.length;i++){
			if(arr[i-1] > arr[i]){
				return false;
			}
		
			
		}
		return true;
	}
	public static void main(String arg[]){
		sortedArray sR = new sortedArray();
		int[] arr = {10,9,30,40,50};
		
		if(sR.isSorted(arr)){
			System.out.println("Array is sorted.");
		}
		else{
			System.out.print("Array is not sorted");
		}
		
	}
	
}