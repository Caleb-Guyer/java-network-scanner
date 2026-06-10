// first version of the network scanner

import java.util.Scanner;
import java.net.InetAddress;

public class SimpleNetworkScanner
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a subnet");
        String subnet = scan.next();

        for (int i = 1; i <= 50; i++)
        {
            String ip = subnet + "." + i;

            try
            {
                InetAddress address = InetAddress.getByName(ip);

                if (address.isReachable(300))
                {
                    System.out.println("Found device: " + ip);
                }
            }
            catch (Exception e)
            {
                System.out.println("Error scanning: " + ip);
            }
        }
    }
}