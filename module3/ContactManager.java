import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("John Smith", new Contact("John Smith", "+1 123 123 1234"));
        contacts.put("Jane Doe", new Contact("Jane Doe", "+1 123 123 1235"));
        contacts.put("William Hunt", new Contact("William Hunt", "+1 123 123 1236"));
        contacts.put("Tim Cook", new Contact("Tim Cook", "+1 123 123 1237"));
        contacts.put("Mary Jane", new Contact("Mary Jane", "+1 123 123 1238"));

        // Step 5: look up a contact
        String lookup = "John Smith";
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