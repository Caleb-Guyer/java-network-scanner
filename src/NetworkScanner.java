import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NetworkScanner
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter subnet:");
        String subnet = scan.next();

        System.out.println("Starting scan...\n");

        long startTime = System.currentTimeMillis();

        int hostsFound = 0;
        int portsFound = 0;

        for (int i = 1; i <= 50; i++)
        {
            String ip = subnet + "." + i;

            if (isAlive(ip))
            {
                hostsFound++;

                System.out.println("\n[HOST UP] " + ip);
                int found = scanPorts(ip);
                portsFound += found;
            }
        }

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        System.out.println("\n==================================");
        System.out.println("SCAN COMPLETE");
        System.out.println("Hosts found: " + hostsFound);
        System.out.println("Open ports found: " + portsFound);
        System.out.println("Time taken: " + duration + " ms");
        System.out.println("==================================");
    }

    public static boolean isAlive(String ip)
    {
        try
        {
            InetAddress address = InetAddress.getByName(ip);
            return address.isReachable(200);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    // this will then scan the ports on host
    public static int scanPorts(String ip)
    {
        int[] ports = {22, 80, 443, 21, 25, 3389, 8080};

        int count = 0;

        for (int port : ports)
        {
            try
            {
                Socket socket = new Socket(ip, port);

                System.out.println("  [+] OPEN PORT: " + port);
                count++;

                socket.close();
            }
            catch (Exception e)
            {
                // closed port
            }
        }

        return count;
    }
}