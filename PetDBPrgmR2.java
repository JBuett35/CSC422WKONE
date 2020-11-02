/** Created by James Buettner on Wednesday, October 28, 2020 for CSC 422. */

package pets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class PetDBPrgmR2.
 */
public class PetDBPrgmR2 {
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
                    searchByPetName(scan);
                    break;
                case 4:
                    searchByPetAge(scan);
                    break;
                case 5:
                    System.out.println("Thank you for using the Pet Database Program. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (option != 5);
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
     * Search by pet name.
     *
     * @param scan the scan
     */
    private static void searchByPetName(Scanner scan) {
        System.out.print("Enter name to search: ");
        String name = scan.nextLine();
        System.out.println("+---------------------------------------+");
        System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
        System.out.println("+---------------------------------------+");
        int i = 0;
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                System.out.printf("|%5d%5s", i, pet.toString());
                i++;
            }
        }
        System.out.println("+---------------------------------------+");
        System.out.println((i) + "rows in set.");
    }
    /**
     * Search by pet age.
     *
     * @param scan the scan
     */
    private static void searchByPetAge(Scanner scan) {
        System.out.print("Enter age to search: ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.println("+---------------------------------------+");
        System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
        System.out.println("+---------------------------------------+");
        int i = 0;
        for (Pet pet : pets) {
            if (pet.getAge() == age) {
                System.out.printf("|%5d%5s", i, pet.toString());
                i++;
            }
        }
        System.out.println("+---------------------------------------+");
        System.out.println((i) + "rows in set.");
    }
    /**
     * Menu.
     */
    public static void menu() {
        System.out.println("Welcome to the Pet Database Program!\n" +"What would like to do?\n" + "\t1) View all pets\n" + "\t2) Add more pets\n"
                + "\t3) Search pets by name\n" + "\t4) Search pets by age\n" + "\t5) Exit program");
    }
}