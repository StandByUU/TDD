import java.util.*;

public class PhoneBook {
    private final Map<String, String> nameToNumber;
    private final Map<String, String> numberToName;

    public PhoneBook() {
        nameToNumber = new TreeMap<>();
        numberToName = new HashMap<>();
    }

    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size();
        }
        nameToNumber.put(name, number);
        numberToName.put(number, name);
        return nameToNumber.size();
    }

    public String findByNumber(String number) {
        return numberToName.get(number);
    }

    public String findByName(String name) {
        return nameToNumber.get(name);
    }

    public void printAllNames() {
        nameToNumber.keySet().forEach(System.out::println);
    }
}
