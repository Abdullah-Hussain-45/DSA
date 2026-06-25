class InsertionAtBegining {
	public void insertAtBegining(int[] arr,int element){
		int inx,inx2;
		for(int i=0;i<arr.length;i++){//finding zero value
			if (arr[i]==0){
				inx = i - 1;
				//int newlength = arr.length - i;
				break;
			}
		}
		inx2 = inx;
		System.out.print("Before Insertion: ");
		for(int i =0;i<arr.length-inx2; i++){
			System.out.print(arr[i]+" ");
		}
		

		for(int i=inx; i>=0; i--){//Shifting all elements
			arr[i+1] = arr[i];
			inx2--;
		}
		arr[0] = element;
		System.out.println();
		System.out.print("After Insertion: ");
		for(int i =0;i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String args[]){
		InsertionAtBegining insert = new InsertionAtBegining();
		int[] arr = {4,5,6,7,0,0,0};
		int element1 = 3;
		int element2 = 2;
		int element3 = 1;
		insert.insertAtBegining(arr,element1);
		insert.insertAtBegining(arr,element2);
		insert.insertAtBegining(arr,element3);
		
	}
}