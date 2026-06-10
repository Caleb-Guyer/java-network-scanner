// quick practice (haven't done try/catch in a while)

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        try
        {
            System.out.println("Please enter a number");
            int num = scan.nextInt();

            System.out.println("You entered " + num);
        }

        catch (InputMismatchException e)
        {
            System.out.println("Invalid number.");
            scan.next();
        }
    }
}
