package task02;

import java.util.*;

/**
 * Created by Мария on 22.03.2017.
 */
public class PropertiesReaderToHashMap {
    private HashMap<String, String> propertiesMap;

    public PropertiesReaderToHashMap() {
        propertiesMap = new HashMap<>();
    }

    public HashMap<String, String> getPropertiesToHashMap(String resource, String locale) throws MissingResourceException {
        if (resource == null || locale == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            Locale loc = new Locale(locale);
            ResourceBundle bundle = ResourceBundle.getBundle(resource, loc);
            Set<String> bundleKeySet = bundle.keySet();
            for (String key : bundleKeySet) {
                if (key==null){
                    throw new NullPointerException("Key can't be null");
                }
                propertiesMap.put(key, bundle.getString(key));
            }
        } catch (MissingResourceException e) {
            System.out.println("Properties file not found");
        }
        return propertiesMap;
    }

    public String getValueByKey(String key) {
        if (propertiesMap == null) {
            throw new NullPointerException("Empty data");
        }
        if (!propertiesMap.containsKey(key)) {
            return "Key not found";
        }
        return propertiesMap.get(key);
    }

    public void showAllProperties() {
        if (propertiesMap == null) {
            throw new NullPointerException("Empty data");
        }
        for (Map.Entry f : propertiesMap.entrySet()) {
            System.out.println(f.getKey() + " " + f.getValue());
        }
    }

}
