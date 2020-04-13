package com.learning.demo.dto.acc;

import lombok.Data;

@Data
public class ResetPasswordDto {
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}
