import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args)  {

        System.out.println("Ah, so you've Decided to play BlackJack!");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        // Player's Deck//
        Deck playerDeck = new Deck();

        Deck dealerDeck = new Deck();

         Scanner user = new Scanner(System.in);

    //Game function////
       double initialMoney = 500.00;
       double firstBet = user.nextDouble();

       while(initialMoney> 0) { 
           
       System.out.println(" You have $ " + initialMoney + ", how much you wanna bet?");     
           
        if(firstBet > initialMoney){
            System.out.println("Now I know you know you can't bet that.");   
            break;
            }

       }

       boolean endRound = false;
   
    //Lets Deal Some Cards////////
           
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playerDeck);
            dealerDeck.draw(playerDeck);


            while(true){ 

               //Player Hand///   
                
                System.out.println("Your hand is : ");
                System.out.print(playerDeck.toString());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

            // Dealer Hand//
                
                System.out.println("Dealer's hand is" + dealerDeck.getCard(0).toString()+ " ");
                System.out.println("Second card is face down");

                
                System.out.println("Would you like to (1) Hit or (2) Stand ");
                
                int response = user.nextInt();

            //if HIT
                 if(response == 1) { 
                     playerDeck.draw(playingDeck);
                    System.out.println("You draw a:" + playerDeck.getCard(playerDeck.deckSize() -1).toString());
            //BUST 
                    if(playerDeck.cardsValue() > 21) { 
                        System.out.println("YOU BUSTED. The value of your hand is : " + playerDeck.cardsValue());
                        
                        initialMoney -= firstBet; 

                        endRound = true;
                        break;
                     }

                 }

                 if(response == 2) { 
                     break;
                 }


                 System.out.println("Dealer's Cards: " + dealerDeck.toString());
                 if((dealerDeck.cardsValue()> playerDeck.cardsValue()) && endRound == false) { 
                    
                    System.out.println("Dealer Won!!");
                    initialMoney -= firstBet;
                    endRound = true;
                 }

                 while((dealerDeck.cardsValue()< 17) && endRound == false) { 
                     dealerDeck.draw(playingDeck);
                     System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
                 }

                 ///Value of Dealer Hand 
                 System.out.println( " Dealer's hand is valued at: " + dealerDeck.cardsValue());

                //  Dealer Bust
                if((dealerDeck.cardsValue()> 21) && endRound == false) { 
                    System.out.println(" DEALER BUSTED! WIN WIN WIN WIN");
                    initialMoney+=firstBet;
                    endRound = true;
                }

                if((playerDeck.cardsValue()== dealerDeck.cardsValue())&& endRound == false) { 
                    System.out.println(" Tie");
                    endRound = true;
                }

                if((playerDeck.cardsValue()>dealerDeck.cardsValue()&& endRound== false)){
                    System.out.println("YOU WOOOON!");
                    initialMoney += firstBet;
                    endRound =  true;
                }

                 playerDeck.moveAllToDeck(playingDeck);
                 dealerDeck.moveAllToDeck(playingDeck);
                 System.out.println("End Hand");
            }

           
            System.out.println(" Game Over");

        }
         

              
        
    }

