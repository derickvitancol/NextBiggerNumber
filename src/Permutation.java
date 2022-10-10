import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Scanner;
public class Permutation {

    public static void main(String[] args)
    {
        System.out.println("Input: ");
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        System.out.println(nextBigger(n));
    }


    public static long nextBigger(long number)
    {
        long result;
        String numberString = String.valueOf(number);
        List<String> integers = new ArrayList<>();
        printPerm(numberString,"",integers);
        //integers.forEach(System.out::println);
        List<Long> nums = integers.stream()
                .map(numberElement -> Long.parseLong(numberElement))
                .collect(Collectors.toList());
        nums.forEach(System.out::println);
        Collections.sort(nums);
        System.out.println("Sorted");
        nums.forEach(System.out::println);
        int i = nums.indexOf(number);

        System.out.println(i +" "+nums.get(i+1));
        result = nums.get(i+1);
        if(!(nums.get(i+1) > number))
        {
            result = -1;
        }


        return result;
    }

    public static void printPerm(String str, String ans,List<String> numbers)
    {
        if (str.length() == 0) {
            numbers.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPerm(ros, ans + ch, numbers);
        }
    }

}
