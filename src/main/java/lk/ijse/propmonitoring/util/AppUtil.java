package lk.ijse.propmonitoring.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateProfilePicToBase64(byte[] profilePic) {
        return Base64.getEncoder().encodeToString(profilePic);
    }
    public static String generateCropCode(){
        return null;
    }

    public static String generateFieldEquipmentCode(){
        return null;
    }
}
