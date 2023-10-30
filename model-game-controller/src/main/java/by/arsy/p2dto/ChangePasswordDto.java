package by.arsy.p2dto;

import jakarta.validation.constraints.NotBlank;

public class ChangePasswordDto {

    @NotBlank
    private String oldPass;
    @NotBlank
    private String newPass;
    @NotBlank
    private String repeatPass;


    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }
}
