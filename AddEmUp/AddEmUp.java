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
    private int[][] numbers;

    public AddEmUp(int[][] num)
    {
        numbers = num;
    }

    /*
     *    returns a list of all possible sums using two entries from the given row.
     *    
     *    The returned List<Integer> should have no repeated values
     */
    public List<Integer> rowSum(int row)
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
    public String getState(int row)
    {
        int oddCount = 0;
        int evenCount = 0;
        String resp = "";
        List<Integer> totalrow = new ArrayList<Integer>();
        totalrow = rowSum(row);
        for(int i = 0; i < totalrow.size(); i++){
            int temp = totalrow.get(i);
            System.out.println("Current Temp:" + temp);
            if (temp %2 == 0){
                System.out.println("Current Temp is Even");
                evenCount++;}
            else
            {
                System.out.println("Current Temp is Odd");
                oddCount++;}
        }
        System.out.println("Even Count: " + evenCount);
        System.out.println("Odd Count: " + oddCount);
        if(evenCount > oddCount){
            return "EVEN";}
        else if(oddCount > evenCount){
            return "ODD";}
        else{
            return "NEITHER";}

    }

    /*
     *   returns a List of all values that are contained in every List returned by rowSum(k) method, 0 <= k < numbers.length 
     *   for all rows in the 2D array.
     *
     *   That is, a List of all values that would be contain in the rowSum(k) method for all possible values of k.
     */
    public List<Integer> commonSum()
    {
        System.out.println("" + Arrays.asList(numbers));    
        List<Integer> commonvalues = new ArrayList<Integer>();
        List<Integer> megaList = new ArrayList<Integer>();
        for(int i = 0; i < numbers[0].length; i++){
            List<Integer> tempList = rowSum(i);
            System.out.println("Temp List" + tempList);
            for(int a = 0; a < tempList.size(); a++){
                megaList.add(tempList.get(a));
                System.out.println("Individual Element: + " + tempList.get(a)); 
            }
        }
        System.out.println("Mega List" + megaList);
        commonvalues = findDuplicates(megaList);
        /*
        for(int i = 0; i < megaList.size();i++){
        int temp = megaList.get(i);
        System.out.println("Comparison Element: " + temp);
        for(int a = i; a < megaList.size(); a++){
        if(temp == megaList.get(a)){
        System.out.println("Active Comparison" + megaList.get(a));
        commonvalues.add(a);}}
        }
         */
        return commonvalues;
    }

    public List<Integer> findDuplicates(List<Integer> a){
        List<Integer> found = new ArrayList<Integer>();
        for(int i = 0; i < a.size(); i++){
            int temp = a.get(i);
            int freq = Collections.frequency(a, temp);
            if((freq == numbers[0].length) && (found.contains(temp) == false))
                found.add(temp);
        }
        return found;}
}