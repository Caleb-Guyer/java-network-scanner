# Java Network Scanner

A simple network reconnaissance tool built in Java.  
It scans a local subnet and checks for active hosts and open ports.

---

## Features

- Subnet scanning (example: 172.31.11.x)
- Host discovery using reachability checks
- TCP port scanning
- Detects common service ports (SSH, HTTP, HTTPS, etc.)

---

## How it works

1. Enter a subnet (example: 172.31.11)
2. The program scans IP addresses in the range .1 to .50
3. For each active host, it scans selected TCP ports
4. Displays open ports in the console

---

## Example Output


Host UP: 172.31.11.1
OPEN PORT: 80
OPEN PORT: 443


---

## Technologies Used

- Java
- Sockets (java.net.Socket)
- InetAddress API
- Basic multithreaded concepts (in later versions)

---

## Disclaimer

This tool is for educational purposes only and should only be used on networks you own or have permission to scan.
