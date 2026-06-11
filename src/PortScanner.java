import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner
{
    public static int scanPorts(String ip, StringBuilder report)
    {
        int[] ports = {22, 80, 443, 21, 25, 3389, 8080};

        int count = 0;

        for (int port : ports)
        {
            try
            {
                Socket socket = new Socket();

                socket.connect(new InetSocketAddress(ip, port), 200);

                System.out.println("  [+] OPEN PORT: " + port);
                count++;

                report.append("  [+] OPEN PORT: ")
                        .append(port)
                        .append("\n");

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
