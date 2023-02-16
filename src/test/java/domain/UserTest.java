package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("유저가 제대로 생성되는지 확인")
    void generateUserTest() {
        String validUserName = "홍실";
        Assertions.assertDoesNotThrow(() -> new User(validUserName));
    }

    @Test
    @DisplayName("유저의 이름은 5글자 이하여야 한다.")
    void userNameOver5Test() {
        String longUserName = "홍실썬샷페어";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(longUserName));
    }

    @Test
    @DisplayName("유저의 이름이 공백인지 확인")
    void userNameBlankTest() {
        String blankUserName = " ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(blankUserName));
    }
}