public class largestElement{
	public int findMax(int[] arr){
	 int max = arr[0];
	 for(int i=1;i<arr.length;i++){
		if(arr[i] > max){
			max = arr[i];
			}
		}
		
		return max;
	}
	public static void main(String arg[]){
	largestElement fM = new largestElement();
	int[] arr = {1,2,4,5,89,100,3};
	int max = fM.findMax(arr);
	System.out.println("Largest element in the array: "+max);
	
	
	}
}