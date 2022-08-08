package timeComplexity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairSumInArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
        String[] strNums; 
        strNums = br.readLine().split("\\s");
        

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static int pairSum(int[] arr, int num) {
    	Arrays.sort(arr);
        int i = 0, j = arr.length -1,count = 0;
	        while(i < j){
	            if(arr[i] + arr[j] > num) j--;
	            else if(arr[i] + arr[j] < num) i++;
	            else if(arr[i] == arr[j]) {
	            		count += ((j-i)*(j-i+1))/2;
	            		break;
	            }else {
	            		int a = 1, b = 1;
                        int temp = arr[i];
                        while(++i < j && arr[i] == temp ) a++;
                        --i;
                        temp = arr[j];
                        while(--j > i && arr[j] == temp) b++; 
                        i++;   
                        count += a*b;
	            	}
	            }
	    return count;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] arr = takeInput();
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(pairSum(arr, num));

            t -= 1;
        }
    }
}
