package com.example.sendon;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class DataPackager {
    /* packs data we want to send
    *  add them to the json object
    *  read all the data and encode it such that it can be transformed by the network
    * */

    String name;

    public DataPackager(String name) {
        this.name = name;

    }

    public String packData() {
        JSONObject jo = new JSONObject();
        StringBuffer packedData = new StringBuffer();

        try {
            jo.put("Name", name);


            Boolean firstValue = true;

            Iterator it = jo.keys();

            do {
                String key = it.next().toString();
                String value = jo.get(key).toString();

                if (firstValue) {
                    firstValue = false;
                } else {
                    packedData.append("&");
                }

                packedData.append(URLEncoder.encode(key, "UTF-8"));
                packedData.append("=");
                packedData.append(URLEncoder.encode(value, "UTF-8"));

            } while (it.hasNext());

            return packedData.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }
}
