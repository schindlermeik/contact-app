package de.meida.themes.enums;

public class BeforeEnums {
    public static final int ROLE_USER = 1;
    public static final int ROLE_ADMIN = 2;

    public static final String STATUS_OK = "OK";
    public static final String STATUS_READY = "READY";

    static void login(int role) {
        if (role == ROLE_ADMIN) System.out.println("Welcome, admin");
        else System.out.println("Welcome, user");
    }

    public static void main(String[] args) {
        login(999);                 // akzeptiert – aber semantisch Unsinn
        System.out.println(STATUS_OK.equals("ok")); // false – Tippfehler nicht abgefangen
    }

}

enum Role { USER, ADMIN }

class EnumIntroDemo {
    static void login(Role role) {
        if (role == Role.ADMIN) System.out.println("Welcome, admin");
        else System.out.println("Welcome, user");
    }
    public static void main(String[] args) {
        login(Role.USER);
        // login(999); // Compilerfehler – guter Schutz
    }
}
