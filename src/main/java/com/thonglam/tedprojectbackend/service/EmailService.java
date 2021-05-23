package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Email;
import com.thonglam.tedprojectbackend.domain.EmailResponse;

public interface EmailService {
    EmailResponse sendEmail(Email mail);
}
