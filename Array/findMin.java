public class findMin{

    public int findingMin(int[] arr){
        int length = arr.length;
        int min = arr[0];
        for(int i=0;i<length;i++){
            if(min < arr[i]){
                continue;
            }
            else{
                min = arr[i];
            }
        }
        return min;

    }

    public static void main(){
        findMin fM = new findMin();
        int[] arr = {4,6,0,2,3,1};
        System.out.println("Minimum Element: "+fM.findingMin(arr));

    }
}