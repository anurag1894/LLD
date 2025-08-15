package AuactionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Auction Service");
        Scanner scanner = new Scanner(System.in);
        User user1 = new User(1, "Anurag");
        User user2 = new User(2, "Anshu");
        User user3 = new User(3, "Anu");
        User user4 = new User(4, "Monika");
        User user5 = new User(5, "Aditi");
        User user6 = new User(6, "Ashish");
        AuctionManager auctionManager = AuctionManager.getInstance();
        auctionManager.addUser(user1);
        auctionManager.addUser(user2);
        auctionManager.addUser(user3);
        auctionManager.addUser(user4);
        auctionManager.addUser(user5);
        auctionManager.addUser(user6);
        Item item1 = new Item(1, 250,"Bat");
        Item item2 = new Item(2, 20,"Ball");

        auctionManager.addItem(item1, user5);
        auctionManager.addItem(item2, user6);
        while(true){
            System.out.println("Welcome to Auction Service");
            System.out.println("Type Y for show item or type others for close these auctions");
            String state = scanner.nextLine();
            if(state.equals("Y")){
                System.out.println("Items are ");
                auctionManager.showItem();
                System.out.println("Pick the item Id");
                int item = scanner.nextInt();
                boolean flag = auctionManager.startAuction(item);
                if(!flag){
                    scanner.nextLine();
                    continue;
                }
                System.out.println("Start bidding...");

                while(true) {
                    System.out.println("Type Y for close the bid or other for continue bidding");
                    scanner.nextLine(); // to clear the new line
                    String bidCloser = scanner.nextLine();
                    if(bidCloser.equals("Y")){
                        break;
                    }
                    System.out.println("give userId and bid price");
                    int userId = scanner.nextInt();
                    int bid = scanner.nextInt();

                    auctionManager.addBid(userId, bid);
                }
                User winner = auctionManager.getWinner();
                System.out.println("Winner is " + winner.name);
            }else{
                break;
            }
        }
    }
}
