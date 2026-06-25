public class AddToEnd{
	public void addToEnd(int[] arr,int element){
		int newLength = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				newLength = arr.length -i;
			}				
		}
		System.out.print("\nBefore Insertion: ");
		for(int i=0;i<arr.length-newLength;i++){
			System.out.print(arr[i]+" ");		
	}
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				arr[i] = element;
				break;
			}
		}
		System.out.print("\nAfter Insertion: ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");	
		}
	}
	

	public static void main(String args[]){
		AddToEnd add = new AddToEnd();
		int[] arr = {1,2,3,4,5,0,0};
		int element = 6;
		add.addToEnd(arr,element);
		element = 7;
		add.addToEnd(arr,element);
		
	}
}
