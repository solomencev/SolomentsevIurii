package utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/jpg", value = "parameter: {name}")
    public static byte[] makeImageAttachment(String name, byte[] source) {
        return source;
    }
}
