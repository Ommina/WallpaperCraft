package net.ommina.wallpapercraft.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.language.LanguageInfo;
import net.minecraft.client.resources.language.LanguageManager;

import java.util.Locale;

public class Translator {

    private Translator() {
    }

    public static String translateToLocal(String key) {
        return I18n.get(key);
    }

    public static String translateToLocalFormatted(String key, Object... format) {
        return I18n.get(key, format);
    }

    public static String toLowercaseWithLocale(String string) {
        return string.toLowerCase(getLocale());
    }

    @SuppressWarnings("ConstantConditions")
    private static Locale getLocale() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft != null) {
            LanguageManager languageManager = minecraft.getLanguageManager();
            if (languageManager != null) {
                LanguageInfo currentLanguage = languageManager.getSelected();
                if (currentLanguage != null) {
                    return currentLanguage.getJavaLocale();
                }
            }
        }
        return Locale.getDefault();
    }
}
