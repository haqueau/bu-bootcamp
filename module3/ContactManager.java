import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("Ben Dover", new Contact("Ben Dover", "+1 123 123 1234"));
        contacts.put("Mike Hawk", new Contact("Mike Hawk", "+1 123 123 1235"));
        contacts.put("Mike Hunt", new Contact("Mike Hunt", "+1 123 123 1236"));
        contacts.put("Joe Momma", new Contact("Joe Momma", "+1 123 123 1237"));
        contacts.put("Eileen Dover", new Contact("Eileen Dover", "+1 123 123 1238"));

        // Step 5: look up a contact
        String lookup = "Ben Dover";
        System.out.println("Looking up: " + lookup);
        Contact found = contacts.get(lookup);
        if (found == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(found);
        }

        // Look up a name that is not in the map
        String missingName = "Bilbo Baggins";
        System.out.println("Looking up: " + missingName);
        Contact missing = contacts.get(missingName);
        if (missing == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(missing);
        }

        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}