import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

public class NetworkScanner
{
    public static void main(String[] args)
    {
        System.out.println("=== Network Scanner v1.0 ===\n");
        Scanner scan = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        System.out.println("Enter subnet: ");
        String subnet = scan.next();

        if (!subnet.matches("\\d+\\.\\d+\\.\\d+"))
        {
            System.out.println("Invalid subnet format.");
            System.exit(0);
        }

        System.out.println("Start port: ");
        int startPort = scan.nextInt();

        System.out.println("End port: ");
        int endPort = scan.nextInt();

        if (startPort < 1 || endPort > 65535 || startPort > endPort)
        {
            System.out.println("Invalid port range.");
            System.exit(0);
        }

        System.out.println("Starting scan...\n");

        long startTime = System.currentTimeMillis();

        int hostsFound = 0;
        int portsFound = 0;

        StringBuilder report = new StringBuilder();

        report.append("Network scan report\n");
        report.append("======================\n\n");
        report.append("Scan Date: ")
                        .append(formattedDate)
                        .append("\n\n");
        report.append("Subnet: ").append(subnet).append("\n");
        report.append("Port Range: ")
                .append(startPort)
                .append("-")
                .append(endPort)
                .append("\n\n");

        for (int i = 1; i <= 50; i++)
        {
            String ip = subnet + "." + i;

            if (HostChecker.isAlive(ip))
            {
                hostsFound++;

                System.out.println("\n[HOST UP] " + ip);

                report.append("\n[HOST UP] ").append(ip).append("\n");

                int found = PortScanner.scanPorts(ip, report, startPort, endPort);
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