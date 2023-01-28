package com.epam.tc.hw5.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/jpg", value = "parameter: {name}")
    public static byte[] makeImageAttachment(String name, byte[] source) {
        return source;
    }
}
