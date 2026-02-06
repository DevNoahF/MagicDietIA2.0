package com.example.newmagicdietia.utility;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class TextFormatter {

    public static String formatRecipeText(String text){
        if (text==null){
            return null;
        }
        return text.replaceAll("\\n+", "")
                .replaceAll("\\n4","")
                .replaceAll("\\n5","")
                .replaceAll(" {3}","")
                .replaceAll("\\n*","")
                .trim();

    }


}
