package utils.user;

import model.User;

public class UserUtils {

    public static User provideUser() {
        return User.builder()
                .firstName("Teodor")
                .lastName("Pop")
                .password("test1234")
                .email("teodor.pop@yahoo.com")
                .phone("079832543453")
                .address("Str. Mihai Eminescu")
                .build();
    }
}
