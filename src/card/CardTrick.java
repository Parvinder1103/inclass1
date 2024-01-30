import java.util.Scanner;

/**
 * Parvinder Kaur 991716974
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * Modified by: [Your Name]
 * Student Number: [Your Student Number]
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Fill magicHand with random Card Objects
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomSuitIndex()]);
            magicHand[i] = c;
        }

        // Ask the user for Card value and suit, create their card
        Card userCard = new Card();
        userCard.setValue(promptForValue());
        userCard.setSuit(promptForSuit());

        // Search magicHand for the user's card
        boolean isCardFound = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                isCardFound = true;
                break;
            }
        }

        // Report the result
        if (isCardFound) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry! Your card is not in the magic hand.");
        }

        // Add one lucky card hard-coded as 2 of clubs
        Card luckyCard = new Card(2, Card.SUITS[2]);
        magicHand[0] = luckyCard;

        // Now search magicHand for the lucky card
        boolean isLuckyCardFound = false;
        for (Card card : magicHand) {
            if (card.equals(luckyCard)) {
                isLuckyCardFound = true;
                break;
            }
        }

        // Report the result for the lucky card
        if (isLuckyCardFound) {
            System.out.println("You have the lucky card! You win!");
        } else {
            System.out.println("Sorry! The lucky card is not in the magic hand.");
        }
    }

    private static int generateRandomValue() {
        // Generate a random number between 1 and 13 (inclusive)
        return (int) (Math.random() * 13) + 1;
    }

    private static int generateRandomSuitIndex() {
        // Generate a random number between 0 and 3 (inclusive)
        return (int) (Math.random() * 4);
    }

    private static int promptForValue() {
        // Use Scanner to get user input for card value
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the card value (1-13): ");
        return scanner.nextInt();
    }

    private static String promptForSuit() {
        // Use Scanner to get user input for card suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the card suit (hearts, diamonds, clubs, spades): ");
        return scanner.next();
    }
}
