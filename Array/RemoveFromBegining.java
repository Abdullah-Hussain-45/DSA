public class RemoveFromBegining{

	public void removeFromBegining(int[]arr,int index){
		
		System.out.print("Before removing element: ");
		for(int i=0;i<arr.length-index;i++){
			System.out.print(arr[i]+" ");
		}
		for(int i=1;i<arr.length;i++){
			arr[i-1] = arr[i];
			if(i==(arr.length - 1)){
				arr[i] = 0;
			}
		}
		index +=1;
		System.out.println();
		System.out.print("After removing element: ");
		for(int i=0;i<arr.length-index;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
		
	}
	
	public static void main(String args[]){
		RemoveFromBegining remove = new RemoveFromBegining();
		int[] arr = {1,2,3,4,5,6,7,8};
		int index = 0;
		while (index!=(arr.length)){
			remove.removeFromBegining(arr,index);
			if(index == (arr.length-1)){
				arr[index] = 0;
				System.out.println("Elements in the array: "+arr[index]);
			}
			index ++;
		}
	}
}
