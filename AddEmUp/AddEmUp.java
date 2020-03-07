import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * The test class .
 *
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class AddEmUp
{
    /*
     *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
     *    
     *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
     */
    private static int[][] numbers;

    public AddEmUp(int[][] num)
    {
        numbers = num;
    }

    /*
     *    returns a list of all possible sums using two entries from the given row.
     *    
     *    The returned List<Integer> should have no repeated values
     */
    public static List<Integer> rowSum(int row)
    {
        List<Integer> ans = new ArrayList<Integer>();
        int sum = 0;

        for(int i = 0; i < numbers[row].length-1; i++){

            for(int a = i+1; a < numbers[row].length; a++){ 
                ans.add(new Integer(numbers[row][a]) + numbers[row][i]);
            }

        }
        LinkedHashSet<Integer> setNote = new LinkedHashSet<>(ans);

        return new ArrayList<Integer>(setNote); 
    }

    /*
     *  determines the state of row in the 2D array.
     *  (For this method, repeated sums count multiple times.)
     *  Remember, a number, x, is even if x % 2 == 0.
     *  This method returns:
     *    �EVEN� if there exist more even numbers in the List of all possible sum of two entries in a given row.
     *    �ODD� if there exist more odd numbers in the List of all possible sum of two entries in a given row.
     *    �NEITHER� if there exist the same number of even and odd numbers in the List of all possible sum of two entries in a given row.
     */
    public static String getState(int row)
    {
        int oddCount = 0;
        int evenCount = 0;
        String resp = "";
        for(int i = 0; i < numbers[row].length; i++){
            int temp = numbers[row][i];
            if (temp %2 == 0){
                evenCount++;}
            else
            {
                oddCount++;}
        }
        if (oddCount > evenCount)
            return "ODD";
        return "EVEN";    
    }

    /*
     *   returns a List of all values that are contained in every List returned by rowSum(k) method, 0 <= k < numbers.length 
     *   for all rows in the 2D array.
     *
     *   That is, a List of all values that would be contain in the rowSum(k) method for all possible values of k.
     */
    public static List<Integer> commonSum()
    {
        List<Integer> commonvalues = new ArrayList<Integer>();
        List<Integer> compare = new ArrayList<Integer>();
        compare = rowSum(0);
        for(int i = 1; i < numbers[0].length; i++){
            List<Integer> temp = rowSum(i);
            System.out.println(commonvalues);
            System.out.println(temp);
            System.out.println("|| Checks for Common Values ||");
            System.out.println("Common Values found: " + commonvalues);
            commonvalues.retainAll(temp);

        }
        return compare;
    }
}