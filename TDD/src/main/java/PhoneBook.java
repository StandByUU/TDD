import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> nameToNumber;
    private final Map<String, String> numberToName;

    public PhoneBook() {
        nameToNumber = new HashMap<>();
        numberToName = new HashMap<>();
    }

    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size(); // не добавляем, возвращаем текущее кол-во
        }
        nameToNumber.put(name, number);
        numberToName.put(number, name);
        return nameToNumber.size();
    }
}

public String findByNumber(String number) {
    return null;
}

