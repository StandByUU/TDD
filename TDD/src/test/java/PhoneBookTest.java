import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    @Test
    public void testAdd_ShouldReturnOneAfterFirstAdd() {
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add("Alice", "123");
        assertEquals(1, result);
    }

    @Test
    public void testAdd_ShouldReturnTwoAfterSecondAdd() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        int result = phoneBook.add("Bob", "456");
        assertEquals(2, result);
    }

    @Test
    public void testAdd_DuplicateNameShouldNotBeAdded() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        int result = phoneBook.add("Alice", "999");
        assertEquals(1, result);
    }

    @Test
    public void testFindByNumber_ShouldReturnNameIfExists() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        String result = phoneBook.findByNumber("123");
        assertEquals("Alice", result);
    }

    @Test
    public void testFindByNumber_ShouldReturnNullIfNotFound() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        String result = phoneBook.findByNumber("999");
        assertNull(result);
    }

    @Test
    public void testFindByName_ShouldReturnNumberIfExists() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        String result = phoneBook.findByName("Alice");
        assertEquals("123", result);
    }

    @Test
    public void testFindByName_ShouldReturnNullIfNotFound() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        String result = phoneBook.findByName("Bob");
        assertNull(result);
    }

    @Test
    public void testPrintAllNames_ShouldPrintInAlphabeticalOrder() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Charlie", "789");
        phoneBook.add("Alice", "123");
        phoneBook.add("Bob", "456");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();

        System.setOut(originalOut);

        String[] lines = outContent.toString().trim().split("\n");
        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie"}, lines);
    }
}
