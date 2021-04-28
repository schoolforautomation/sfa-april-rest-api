package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName;

    private String lastName;

    @EqualsAndHashCode.Exclude
    private String password;

    private String email;

    private String phone;

    private String address;

    private String errorMessage;
}
