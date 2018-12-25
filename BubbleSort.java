import java.util.*;
import java.lang.*;
import java.io.*;
class BubbleSort
{
    void bubbleSort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr.get(j) > arr.get(j+1))
                {
                    Collections.swap(arr, j, (j+1));
                }
    }
    void printArray(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i=0; i<n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        BubbleSort ob = new BubbleSort();
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
        ob.bubbleSort(arr);
        System.out.print("Sorted array: ");
        ob.printArray(arr);
    }
}
