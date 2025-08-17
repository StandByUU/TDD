import org.junit.jupiter.api.Test;
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
        int result = phoneBook.add("Alice", "999"); // Дубликат по имени
        assertEquals(1, result); // Должно остаться 1
    }
}
