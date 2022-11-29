import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Person implements InOut {

    static Scanner sc = new Scanner(System.in);

    private String name;
    private int age;
    private String gender;
    private String email;
    private String address;
    private String phone;

    public Person() {
    }

    public Person(String name, int age, String gender, String email, String address, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.print("     - Enter Name: ");
        name = sc.nextLine();
        while (name.isEmpty()) {
            System.err.print("\n     Name must not be left blank! Enter again: ");
            name = sc.nextLine();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.print("     - Enter age: ");
        while (true) {
            try {

                age = Integer.parseInt(sc.nextLine());

                if (age >= 18 && age <= 50) {
                    break;
                } else {
                    System.out.print("\n     18 <= age <= 50. Enter again: ");
                }
            } catch (Exception e) {
                System.out.print("\n     Incorrect,  Enter again: ");
            }
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        System.out.print("     - Enter gender (Male/Female): ");
        gender = sc.nextLine();
        while (gender.isEmpty()) {
            System.out.print("\n     Gender must not be left blank! Enter again: ");
            gender = sc.nextLine();
        }
        while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            System.out.print("\n     Gender is Male or Female. Enter again: ");
            gender = sc.nextLine();
        }
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        do {
            System.out.print("     - Enter email: ");
            email = sc.nextLine();
            String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (email.isEmpty()) {
                System.out.println("    Email must not be left blank! Enter again: ");
                continue;
            } else if (!matcher.find()) {
                System.out.println("    Enter the wrong email format, please enter again: ");
                continue;
            }
            break;
        } while (true);
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.print("     - Enter address: ");
        address = sc.nextLine();
        while (address.isEmpty()) {
            System.out.print("\n    Gender must not be left blank! Enter again:  ");
            address = sc.nextLine();
        }
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.print("     - Enter phone(10 number): ");
        phone = sc.nextLine();
        while (phone.isEmpty()) {
            System.out.print("\n     Phone must not be left blank! Enter again: ");
            phone = sc.nextLine();
        }
        while (phone.length() != 10) {
            System.out.print("\n      Phone number has only 10 numbers, Enter again: ");
            phone = sc.nextLine();
        }
        this.phone = phone;
    }

    @Override
    public String toString() {
        String str = String.valueOf(age);
        return name + "-" + str + "-" + gender + "-" + email + "-" + address
                + "-" + phone;
    }

    public String handleName() {
        String firstName = "";
        for (String s : name.split("\\s", 0)) {
            if (s == null)
                break;
            firstName = s;
        }
        return firstName;
    }

    @Override
    public void input() {
        setName(name);
        setAge(age);
        setGender(gender);
        setEmail(email);
        setAddress(address);
        setPhone(phone);
    }

    @Override
    public void output() {
        // TODO Auto-generated method stub
        System.out.printf("  %-20s|  %-10d|  %-10s|  %-30s|  %-20s|  %-20s|", name, age, gender, email,
                address, phone);
    }

}
