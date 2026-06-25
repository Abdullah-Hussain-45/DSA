public class findingMax{
    public int findMax(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;

    }
    public static void main(String args[]){
        findingMax fM = new findingMax();
        int[] arr = {1,3,5,10,8,7};
        
        System.out.println("Max element in the array: "+fM.findMax(arr));
        
    }
}