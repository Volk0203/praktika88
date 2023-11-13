import java.util.*;

class User {
    private String name;
    private Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return name + ", возраст " + age + " лет";
    }
}
public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя пользователя: ");
            String name = scanner.nextLine();
            System.out.print("Введите возраст пользователя: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            User user = new User(name, age);
            if (usersMap.containsKey(age)) {
                List<User> userList = usersMap.get(age);
                userList.add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                usersMap.put(age, userList);
            }
        }
        System.out.print("\nВведите требуемый возраст для вывода пользователей: ");
        Scanner scanner = new Scanner(System.in);
        int requiredAge = scanner.nextInt();
        if (usersMap.containsKey(requiredAge)) {
            List<User> userList = usersMap.get(requiredAge);
            userList.sort(Comparator.comparing(User::getName));
            for (User user : userList) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователей данного возраста не найдено.");
        }
    }
}
