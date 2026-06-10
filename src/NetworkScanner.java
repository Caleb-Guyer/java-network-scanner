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

        System.out.println("Scanning network...\n");

        for (int i = 1; i <= 50; i++)
        {
            String ip = subnet + "." + i;

            if (isAlive(ip))
            {
                System.out.println("\nHost UP: " + ip);
                scanPorts(ip);
            }
        }
    }

    // this will check if the host exists
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
    public static void scanPorts(String ip)
    {
        int[] ports = {22, 80, 443, 21, 25, 3389, 8080};

        for (int port : ports)
        {
            try
            {
                Socket socket = new Socket(ip, port);
                System.out.println("OPEN PORT: " + port);
                socket.close();
            }
            catch (Exception e)
            {
                // closed port
            }
        }
    }
}
