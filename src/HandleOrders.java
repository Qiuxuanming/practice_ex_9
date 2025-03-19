import java.util.ArrayList;
import java.util.Scanner;

public class HandleOrders {

    private static final double PIZZA_BASE_PRICE = 10.0;

    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    private int numberOfPizzasOrdered = 0;
    private ArrayList<CustomPizza> customPizzas = new ArrayList<>();
    StringBuilder pizzaOrderSummary = new StringBuilder();

    Scanner input = new Scanner(System.in);

    public void takeOrder(){
        String orderAnother = "Y";
        int j= 0;
        int m = 0;
        int n = 0;
        int p = 0;

        do{
            int i = 1;
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve: \n");
            for(PizzaSelection pizza : PizzaSelection.values()){
                System.out.println(i + ". " + pizza);
                i++;
            }
            System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose: \n");

            System.out.println("Please enter your choice (1-6): \n");
            int choice = input.nextInt();
            input.nextLine();
            
            if(choice>0 && choice<6){
                switch(choice){
                    case 1:
                        System.out.println("You have selected " + PizzaSelection.PEPPERONI);
                        pizzasOrdered[j] = PizzaSelection.PEPPERONI.toString();
                        totalOrderPrice += PizzaSelection.PEPPERONI.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 2:
                        System.out.println("You have selected " + PizzaSelection.HAWAIIAN);
                        pizzasOrdered[j] = PizzaSelection.HAWAIIAN.toString();
                        totalOrderPrice += PizzaSelection.HAWAIIAN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 3:
                        System.out.println("You have selected " + PizzaSelection.VEGGIE);
                        pizzasOrdered[j] = PizzaSelection.VEGGIE.toString();
                        totalOrderPrice += PizzaSelection.VEGGIE.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 4:
                        System.out.println("You have selected " + PizzaSelection.BBQ_CHICKEN);
                        pizzasOrdered[j] = PizzaSelection.BBQ_CHICKEN.toString();
                        totalOrderPrice += PizzaSelection.BBQ_CHICKEN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 5:
                        System.out.println("You have selected " + PizzaSelection.EXTRAVAGANZA);
                        pizzasOrdered[j] = PizzaSelection.EXTRAVAGANZA.toString();
                        totalOrderPrice += PizzaSelection.EXTRAVAGANZA.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again.");
                        break;
                }
            } else if (choice == 6){
                double customPizzaPrice = 0;
                
                System.out.println("For your custom pizza, here are the toppings:");
                int k = 1;
                for(PizzaToppings topping : PizzaToppings.values()){
                    System.out.println(k + ". " + topping);
                    k++;
                }
                System.out.println("Please enter a maximum of 10 topping choices.\n");

                StringBuilder customPizza = new StringBuilder(" Custom Pizza with ");
                StringBuilder customPizzaToppings = new StringBuilder();
                
                int l = 1;
                do{
                    System.out.println("Enter topping #" + l + ". To stop, type 0: ");
                    int toppingChoice = input.nextInt();
                    input.nextLine();
                    if(toppingChoice == 0){
                        break;
                    }
                    customPizza.append(PizzaToppings.values()[toppingChoice-1].getTopping() + ", ");
                    customPizzaToppings.append(PizzaToppings.values()[toppingChoice-1].getTopping() + ", ");
                    customPizzaPrice += PizzaToppings.values()[toppingChoice-1].getToppingPrice();
                    l++;
                }while(l!=10 || l!=0);
                
                customPizzaPrice += PIZZA_BASE_PRICE;
                
                customPizza.append(": €" + customPizzaPrice);

                pizzasOrdered[j] = customPizza.toString();
                totalOrderPrice += customPizzaPrice;
                numberOfPizzasOrdered++;
                j++;

                // 创建 CustomPizza 对象并添加到 customPizzas ArrayList
                CustomPizza customPizzaObj = new CustomPizza(customPizzaToppings.toString(), customPizzaPrice);
                customPizzas.add(customPizzaObj);
            }

            i = 1;
            System.out.println("Here are the pizza sizes options: \n");
            for(PizzaSize pizza : PizzaSize.values()){
                System.out.println(i + ". " + pizza);
                i++;
            }

            System.out.println("Pick one size (1 - 3): \n");
            int sizeChoice = input.nextInt();
            input.nextLine();

            pizzaSizesOrdered[m] = PizzaSize.values()[sizeChoice-1].getPizzaSize() + ": €" + PizzaSize.values()[sizeChoice-1].getAddToPizzaPrice();
            totalOrderPrice += PizzaSize.values()[sizeChoice-1].getAddToPizzaPrice();
            m++;

            System.out.println("Here are the side dishes options: \n");
            i = 1;
            for(SideDish sideDish : SideDish.values()){
                System.out.println(i + ". " + sideDish);
                i++;
            }

            System.out.println("Pick one side dish (1 - 4): \n");
            int sideDishChoice = input.nextInt();
            input.nextLine();

            sideDishesOrdered[n] = SideDish.values()[sideDishChoice-1].getSideDishName() + ": €" + SideDish.values()[sideDishChoice-1].getAddToPizzaPrice();
            totalOrderPrice += SideDish.values()[sideDishChoice-1].getAddToPizzaPrice();
            n++;

            System.out.println("Here are the drinks options: \n");
            i = 1;
            for(Drinks drink : Drinks.values()){
                System.out.println(i + ". " + drink);
                i++;
            }

            System.out.println("Pick one drink (1 - 3): \n");
            int drinkChoice = input.nextInt();
            input.nextLine();

            drinksOrdered[p] = Drinks.values()[drinkChoice-1].getDrinkName() + ": €" + Drinks.values()[drinkChoice-1].getAddToPizzaPrice();
            totalOrderPrice += Drinks.values()[drinkChoice-1].getAddToPizzaPrice();
            p++;

            System.out.println("Would you like to order another pizza? (Y/N): \n");
            orderAnother = input.nextLine();
            

        }while(orderAnother.equalsIgnoreCase("Y"));
    }

    public void createOrderSummary(){
        
        pizzaOrderSummary.append("\nThank you for dining with Slice-o-Heaven. Your order details are as follows: \n");

        for(int i=0; i<numberOfPizzasOrdered; i++){
            pizzaOrderSummary.append((i+1) + pizzasOrdered[i] + "\n");
            pizzaOrderSummary.append(pizzaSizesOrdered[i] + "\n");
            pizzaOrderSummary.append(sideDishesOrdered[i] + "\n");
            pizzaOrderSummary.append(drinksOrdered[i] + "\n \n");
        }

        pizzaOrderSummary.append("ORDER TOTAL: €" + totalOrderPrice + "\n");
    }

    public void displayCustomPizzas() {
        System.out.println("Custom Pizzas Ordered:");
        for (CustomPizza customPizza : customPizzas) {
            System.out.println(customPizza);
        }
    }

    @Override
    public String toString(){
        return pizzaOrderSummary.toString();
    }
}