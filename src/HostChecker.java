import java.net.InetAddress;

public class HostChecker
{
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
}
