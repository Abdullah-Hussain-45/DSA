public class ReverseArray{
	public void reverseArray(int[] arr1,int[] arr2){
		int j=0;
		for(int i=arr1.length-1;i>=0;i--){
			arr2[j] = arr1[i];
			j++;
		}
	
	}
	public static void main(String[] args){
		ReverseArray RA = new ReverseArray();
		int[] arr1 = {1,2,3,4,5};
		int newLength = arr1.length;
		int[] arr2 = new int[newLength];
		RA.reverseArray(arr1,arr2);
		System.out.print("Elements in the 1st Array: ");
		for(int element:arr1){
			System.out.print(element+ " ");
		}
		System.out.println();//newline
		System.out.print("Elements in the 2nd Array: ");
		for(int element: arr2){
			System.out.print(element+ " ");
		}
	}
}
	
			