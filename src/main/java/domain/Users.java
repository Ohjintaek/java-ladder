package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        this.users = initUsers(userNames);
    }

    public int size() {
        return users.size();
    }

    public boolean isExist(String userName) {
        List<String> userNames = getUserNames();
        return (userNames.contains(userName));
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateUserNamesEmpty(final List<String> userNames) {
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAMES_BLANK_EXCEPTION.getMessage());
        }
    }

    private List<User> initUsers(List<String> userNames) {
        final List<User> users = new ArrayList<>();
        userNames.forEach(userName -> users.add(new User(userName)));
        return users;
    }
}
