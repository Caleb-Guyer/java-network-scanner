# Java Network Scanner

A Java-based network scanner that discovers active hosts, scans TCP ports, identifies common services, and exports results to a report file.

## Features

- Subnet scanning (for example, `172.31.11.x`)
- Host discovery using reachability checks
- Configurable TCP port ranges
- Common service identification (SSH, HTTP, HTTPS, FTP, SMTP, RDP, and others)
- Scan report generation with timestamps
- Input validation for subnet and port ranges

## Project Structure
src/
├── NetworkScanner.java      # Main application logic and user interaction
├── HostChecker.java         # Host discovery and reachability checks
├── PortScanner.java         # Port scanning and service detection
└── ReportWriter.java        # Report file creation and export
text## How It Works

1. Enter a subnet (for example, `172.31.11`).
2. Choose a start and end port.
3. The scanner checks hosts in the subnet range **.1 – .50**.
4. For each active host, the scanner attempts TCP connections across the selected port range.
5. Open ports and identified services are displayed in the console and saved to a report file.

## Example Output

**Console Output**  
*(Screenshot or example console log would go here)*

**Generated Report**  
*(Example report file content would go here)*

## Technologies Used

- Java
- `java.net.Socket` for TCP connections
- `InetAddress` for host discovery
- `FileWriter` for report generation
- Object-oriented design with multiple classes

## What I Learned

- TCP socket programming in Java
- Host discovery and network scanning concepts
- Exception handling and input validation
- File I/O and report generation
- Organizing larger Java programs into multiple classes

## Disclaimer

**Educational use only**  
This tool is intended for educational purposes and should only be used on networks you own or are a
