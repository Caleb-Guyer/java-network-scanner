import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter
{
    public static void saveReport(String report)
    {
        try
        {
            FileWriter writer = new FileWriter("scan-results.txt");

            writer.write(report);

            writer.close();

            System.out.println("\nResults saved to scan-results.txt");
        }
        catch (IOException e)
        {
            System.out.println("Error writing report file.");
        }
    }
}