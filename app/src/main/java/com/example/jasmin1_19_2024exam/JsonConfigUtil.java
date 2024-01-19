package com.example.jasmin1_19_2024exam;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonConfigUtil {


    public static String readConfig(Context context, String fileName) {
        File configFile = new File(context.getFilesDir(), fileName);

        String config;
        if (configFile.exists()) {
            try (FileInputStream inputStream = context.openFileInput(fileName)) {
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                config = new String(buffer, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
                config = getDefaultConfigFromAssets(context, fileName);
            }
        } else {
            config = getDefaultConfigFromAssets(context, fileName);
        }

        return config;
    }

    private static String getDefaultConfigFromAssets(Context context, String fileName) {
        try {
            InputStream assetInputStream = context.getAssets().open(fileName);
            int size = assetInputStream.available();
            byte[] buffer = new byte[size];
            assetInputStream.read(buffer);
            assetInputStream.close();
            return new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"people\": []}";
        }
    }

    public static void saveConfig(Context context, String configContent, String fileName) {
        try (FileOutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)) {
            outputStream.write(configContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
