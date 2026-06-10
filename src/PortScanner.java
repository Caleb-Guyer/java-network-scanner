// simple port scanner, which was integrated into the full network scanner

import java.net.Socket;
import java.util.Scanner;

public class PortScanner
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter IP address:");
        String ip = scan.next();

        System.out.println("Scanning " + ip + " ports 1-1024...\n");

        for(int port = 1; port <= 1024; port++)
        {
            final int currentPort = port;

            new Thread(() ->
            {
                try
                {
                    Socket socket = new Socket(ip, currentPort);
                    System.out.println("OPEN: " + currentPort);

                    socket.close();
                }
                catch (Exception ignored)
                {

                }
            }).start();
        }
    }
}