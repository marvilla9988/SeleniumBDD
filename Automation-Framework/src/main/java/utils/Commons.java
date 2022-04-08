package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Commons {
    public String generateRandomString(int leng){
        return RandomStringUtils.randomAlphabetic(leng);
    }

    public String generateRandomNumber(int leng){
        return RandomStringUtils.randomNumeric(leng);
    }
}
