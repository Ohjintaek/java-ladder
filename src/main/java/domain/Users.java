package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static exception.ErrorMessage.USER_NAME_NOT_EXISTS_IN_USERS_EXCEPTION;

public class Users {

    private final List<User> users;

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        this.users = initUsers(userNames);
    }

    public int size() {
        return users.size();
    }

    public void isExist(String userName) {
        List<String> userNames = getUserNames();
        if (userNames.contains(userName)) {
            return;
        }
        throw new IllegalArgumentException(USER_NAME_NOT_EXISTS_IN_USERS_EXCEPTION.getMessage());
    }

    public List<String> getUserNames() {
        final List<String> userNames = new ArrayList<>();
        for (final User user : users) {
            userNames.add(user.getName());
        }
        return userNames;
    }

    private void validateUserNamesEmpty(final List<String> userNames) {
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAMES_BLANK_EXCEPTION.getMessage());
        }
    }

    private List<User> initUsers(List<String> userNames) {
        final List<User> users = new ArrayList<>();
        for (final String userName : userNames) {
            users.add(new User(userName));
        }
        return users;
    }
}
