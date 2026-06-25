public class LinearSearch{
    public int linearSearch(int[] arr,int target){
            for(int i=0;i<arr.length;i++){
                if(target==arr[i]){
				return i;
				}
			}
				return 0;
    }//method end
    public static void main(String[] args){
		LinearSearch LS = new LinearSearch();
		int arr[] = {2,4,15,46,78,32};
		int target = 100;
		int foundIndex = LS.linearSearch(arr,target);
		if(foundIndex !=0){
			System.out.println(target+" is at index "+foundIndex);
		}
		else{
			System.out.println(target+" is not present in the array");
		}
	}
}