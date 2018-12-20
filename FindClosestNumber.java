import java.util.*;
import java.lang.*;
import java.io.*;
public class FindClosestNumber {

    public static int findClosest(ArrayList<Integer> arr, int target)
    {
        int n = arr.size();
        // Quick edge cases
        if (target <= arr.get(0))
            return arr.get(0);
        if (target >= arr.get(n - 1))
            return arr.get(n - 1);
        int i = 0, j = n, midpoint = 0;
        while (i < j) {
            midpoint = (i + j) / 2;

            if (arr.get(midpoint) == target)
                return arr.get(midpoint);
            if (target < arr.get(midpoint)) {
                if (midpoint > 0 && target > arr.get(midpoint-1))
                    return isItClosest(arr.get(midpoint-1),
                                  arr.get(midpoint), target);

                j = midpoint;
            }

            else {
                if (midpoint < n-1 && target < arr.get(midpoint+1))
                    return isItClosest(arr.get(midpoint),
                          arr.get(midpoint+1), target);
                i = midpoint + 1; // update i
            }
        }

        // Only single element left after search
        return arr.get(midpoint);
    }
    public static int isItClosest(int num1, int num2,
                                         int target)
    {
        if (target - num1 >= num2 - target)
            return num2;
        else
            return num1;
    }

    public static void main(String[] args)
    {
        System.out.println("Please enter your numbers, and type 'end' when you are done.");
        Scanner sc = new Scanner(System.in);
        String line;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        do {
          line = sc.nextLine();
          try {
           arr.add(Integer.parseInt(line)); // Cast the number, if it does not succeed catch the exception.
         }
         catch(NumberFormatException e) {
           if(!line.equalsIgnoreCase("end")) { // Wrong input
               System.out.println("Wrong input, input another number or end");
           }
       }
   } while (!line.equalsIgnoreCase("end"));
        System.out.println("Please enter your target number.");
        int target = sc.nextInt();
        Collections.sort(arr);
        System.out.println(findClosest(arr, target));
    }
}
