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

                String service = getServiceName(i);

                System.out.println("  [+] OPEN PORT: " + i + " (" + service + ")");
                count++;

                report.append("  [+] OPEN PORT: ")
                        .append(i)
                        .append(" (")
                        .append(service)
                        .append(")\n");

                socket.close();
            }
            catch (Exception e)
            {
                // closed port
            }
        }

        return count;
    }

    public static String getServiceName(int port)
    {
        if (port == 21)
        {
            return "FTP";
        }
        else if (port == 22)
        {
            return "SSH";
        }
        else if (port == 25)
        {
            return "SMTP";
        }
        else if (port == 80)
        {
            return "HTTP";
        }
        else if (port == 443)
        {
            return "HTTPS";
        }
        else if (port == 3389)
        {
            return "RDP";
        }
        else if (port == 8080)
        {
            return "HTTP-ALT";
        }
        else
        {
            return "Unknown";
        }
    }
}
