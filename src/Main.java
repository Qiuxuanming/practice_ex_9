public class Main{
    public static void main(String[] args) throws Exception {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.createOrderSummary();
        System.out.println(handleOrders);
        handleOrders.displayCustomPizzas();
        OrderLogs orderLogs = new OrderLogs();
        orderLogs.handleLogs();
    }
}
