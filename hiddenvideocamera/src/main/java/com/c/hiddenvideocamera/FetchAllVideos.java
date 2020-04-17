package com.c.hiddenvideocamera;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class FetchAllVideos {
    public static void fetchVideos(final Context context, String url1, final String uid) {
        // Create data variable for sent values to server

        try {
            String data = URLEncoder.encode("uid", "UTF-8")
                    + "=" + URLEncoder.encode(uid, "UTF-8");
            BufferedReader reader = null;
            try {

                // Defined URL  where to send data
                URL url = new URL(url1);

                // Send POST data request

                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();

                // Get the server response

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    // Append server response in string
                    sb.append(line).append("\n");
                }

                SharedPrefCamera.saveData(context, "cameraResponse", sb.toString());

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {

                    Objects.requireNonNull(reader).close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
