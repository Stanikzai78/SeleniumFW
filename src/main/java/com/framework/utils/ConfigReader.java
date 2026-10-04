package com.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private static Properties load() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream in = ConfigReader.class.getClassLoader()
                    .getResourceAsStream("config.properties")) {
                if (in == null) {
                    throw new RuntimeException(
                        "config.properties not found on the classpath (expected under src/main/resources)");
                }
                properties.load(in);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException("Could not load config.properties", e);
            }
        }
        return properties;
    }

    public static String getProperty(String key) {
        String value = load().getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing key '" + key + "' in config.properties");
        }
        return value.trim();
    }

    public static String get(String key) {
        return getProperty(key);
    }
}