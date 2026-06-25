public class RemoveFromEnd{
	public void removeFromEnd(int[] arr){
		System.out.print("\nBefore removing: ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		for(int i=(arr.length-1);i>=0;i--){
			if(i == (arr.length-1)){
				arr[i] = 0;
			}
			else if(arr[i]==0){
					arr[i-1] = 0;	
				}
		}
		System.out.print("\nAfter removing: ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}

	public static void main(String args[]){
		RemoveFromEnd remove = new RemoveFromEnd();
		int[] arr = {1,2,3};
		remove.removeFromEnd(arr);
		remove.removeFromEnd(arr);
		remove.removeFromEnd(arr);
	}
}