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

        StringBuilder report = new StringBuilder();

        for (int i = 1; i <= 50; i++)
        {
            String ip = subnet + "." + i;

            if (HostChecker.isAlive(ip))
            {
                hostsFound++;

                System.out.println("\n[HOST UP] " + ip);

                report.append("\n[HOST UP] ").append(ip).append("\n");

                int found = PortScanner.scanPorts(ip, report);
                portsFound += found;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        report.append("\n==================================\n");
        report.append("SCAN COMPLETE\n");
        report.append("Hosts found: ").append(hostsFound).append("\n");
        report.append("Open ports found: ").append(portsFound).append("\n");
        report.append("Time taken: ").append(duration).append(" ms\n");
        report.append("==================================\n");

        ReportWriter.saveReport(report.toString());

        System.out.println("\n==================================");
        System.out.println("SCAN COMPLETE");
        System.out.println("Hosts found: " + hostsFound);
        System.out.println("Open ports found: " + portsFound);
        System.out.println("Time taken: " + duration + " ms");
        System.out.println("==================================");
    }
}