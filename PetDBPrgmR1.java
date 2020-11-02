/** Created by James Buettner on Wednesday, October 28, 2020 for CSC 422. */

package pets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class PetDatabasePrgm.
 */
public class PetDBPrgmR1 {
    /** The pets. */
    static ArrayList<Pet> pets;
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        pets = new ArrayList<>();
        int option;
        do {
            menu();
            System.out.print("Your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    viewAllPets();
                    break;
                case 2:
                    addMorePets(scan);
                    break;
                case 3:
                    System.out.println("Thank you for using the Pet Database Program. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (option != 3);
        scan.close();
    }
    /**
     * View all pets.
     */
    private static void viewAllPets() {
        System.out.println("+---------------------------------------+");
        System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
        System.out.println("+---------------------------------------+");
        int i = 0;
        for (Pet pet : pets) {
            System.out.printf("|%5d%5s", i, pet.toString());
            i++;
        }
        System.out.println("+---------------------------------------+");
        System.out.println((i) + " rows in set.");
    }
    /**
     * Adds the more pets.
     *
     * @param scan the scan
     */
    private static void addMorePets(Scanner scan) {
        int count = 0;
        String petString = "";
        do {
            System.out.print("add pet (name, age): ");
            petString = scan.nextLine();
            if (petString.equalsIgnoreCase("done")) {
                break;
            }
            String name = petString.split("\\s+")[0];
            int age = Integer.parseInt(petString.split("\\s+")[1]);
            pets.add(new Pet(name, age));
            count++;
        } while (!petString.equalsIgnoreCase("done"));
        System.out.println(count + " pets added.");
    }
    /**
     * Menu.
     */
    public static void menu() {
        System.out.println("Welcome to the Pet Database Program!\n" +"What would like to do?\n" + "\t1) View all pets\n" + "\t2) Add more pets\n"
                + "\t3) Exit program");
    }
}