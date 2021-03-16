package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface Account {

    boolean getRequireUniqueEmail();

    int getMinRequiredPasswordLength();

    int getMaxRequiredPasswordLength();

    void register(String username, String password);

    void login(String username, String password);

    void changePassword(String oldPass, String newPass);

    Iterable<User> getAllUsersOnline();

    // usually for data base object
    Iterable<User> getAllUsers();

    User getUserByName(String name);
}
