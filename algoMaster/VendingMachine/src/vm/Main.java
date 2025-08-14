package vm;

import vm.model.Coin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachineContext context = VendingMachineContext.getInstance();
        context.addInInventory(1,10,"PEPSI",15);
        context.addInInventory(2,1,"MIRANDA",15);
        context.addInInventory(3,2,"LAYS",5);
        while(true){

            context.showInventory();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Want to purchase? (Y/N)");
            String input = scanner.nextLine();
            if(!input.equals("Y")){
                break;
            }
            System.out.println("Enter the code you want to purchase: ");
            int code = scanner.nextInt();
            while(!context.pickItem(code)){
                context.showInventory();
                code = scanner.nextInt();
            }
            while(true){
                System.out.println("Type C to add more coin else type anything else");
                String flag = scanner.next();
                if(flag.equals("C")){
                    System.out.println("Type quantity and price to add more coin");
                    int quantity = scanner.nextInt();
                    int value = scanner.nextInt();
                    context.addCoin(Coin.getCoinType(value),quantity);
                } else {
                    if(context.paymentComplete())
                        break;
                }
            }
            context.dispenseItem();
            System.out.println("Transaction complete!!");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("\n");
            System.out.println("\n");
        }

    }
}
