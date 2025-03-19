import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class OrderLogs {
    private Deque<String> orderLogs;

    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println("Most recent log entry: " + orderLogs.peek());
        } else {
            System.out.println("No log entries available.");
        }
    }

    private String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        } else {
            return "No log entries available.";
        }
    }

    private void removeAllLogEntries() {
        orderLogs.clear();
    }

    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    public void handleLogs() {
        try (Scanner input = new Scanner(System.in)) {
            String choice;
            do {
                System.out.println("Choose what you want to do with order logs:");
                System.out.println("1. Display all the logs");
                System.out.println("2. Display the most recent log");
                System.out.println("3. Remove a log entry");
                System.out.println("4. Remove all log entries");
                System.out.println("5. Check if the log is completely empty");
                System.out.println("Enter your choice (1–5):");
                int option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 1:
                        displayOrderLogs();
                        break;
                    case 2:
                        if (!orderLogsEmpty()) {
                            mostRecentLogEntry();
                        } else {
                            System.out.println("The log is completely empty.");
                        }
                        break;
                    case 3:
                        if (!orderLogsEmpty()) {
                            System.out.println("Removed log entry: " + getOrderLog());
                        } else {
                            System.out.println("The log is completely empty.");
                        }
                        break;
                    case 4:
                        removeAllLogEntries();
                        System.out.println("All log entries have been removed.");
                        break;
                    case 5:
                        if (orderLogsEmpty()) {
                            System.out.println("The log is completely empty.");
                        } else {
                            System.out.println("The log is not completely empty.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println("Would you like to perform another action? (Y/N):");
                choice = input.nextLine();
            } while (choice.equalsIgnoreCase("Y"));
        }
    }

    private void displayOrderLogs() {
        System.out.println("Order Logs:");
        for (String log : orderLogs) {
            System.out.println(log);
        }
    }
}