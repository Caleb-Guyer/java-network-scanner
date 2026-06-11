import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner
{
    public static int scanPorts(String ip, StringBuilder report, int startPort, int endPort)
    {
        int count = 0;

        for (int i = startPort; i  <= endPort; i++)
        {
            try
            {
                Socket socket = new Socket();

                socket.connect(new InetSocketAddress(ip, i), 200);

                System.out.println("  [+] OPEN PORT: " + i);
                count++;

                report.append("  [+] OPEN PORT: ")
                        .append(i)
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
