package by.arsy.p2dto;

import jakarta.validation.constraints.NotBlank;

public class LoginAttributesDto {

    @NotBlank(message = "create not blank username")
    private String userName;
    @NotBlank(message = "create not blank password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
