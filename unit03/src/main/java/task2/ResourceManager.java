package task2;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Мария on 08.03.2017.
 */
public class ResourceManager {
    private ResourceBundle bundle;
    private Locale locale;

    public Locale setLocale(String language, String country) throws MissingResourceException {
        if (language == null || country == null){
            throw  new NullPointerException("Empty data");
        }
        locale = new Locale(language, country);
        return  locale;
    }

    public Locale setLocale(String language) throws MissingResourceException{
        if (language == null){
            throw  new NullPointerException("Empty data");
        }
        locale = new Locale(language);
        return locale;
    }

    public ResourceBundle setResourceBundle(String resource, Locale locale)throws MissingResourceException{
        if (resource == null || locale == null){
            throw  new NullPointerException("Empty data");
        }
        bundle = ResourceBundle.getBundle(resource, locale);
        return  bundle;
    }

    public ResourceBundle setResourceBundle(String resource)throws MissingResourceException{
        if (resource == null){
            throw  new NullPointerException("Empty data");
        }
        bundle = ResourceBundle.getBundle(resource);
        return bundle;
    }

}
