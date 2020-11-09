package com.github.kotvertolet.youtubejextractor;

import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.Cipher;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.PlayerResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.urlDecode;

class IGsonFactoryImpl implements IGsonFactory {

    @Override
    public Gson initGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Cipher> cipherDeserializer = (json, typeOfT, context) -> {
//            JsonObject jsonObject = json.getAsJsonObject();
//            String s = jsonObject.get("s").getAsString();
//            String sp = jsonObject.get("sp").getAsString();
//            String url = urlDecode(jsonObject.get("url").getAsString());
            String[] arr = json.getAsString().split("&");
            return new Cipher(arr[0].replace("s=", ""), arr[1].replace("sp=", ""), urlDecode(arr[2].replace("url=", "")));
        };
        JsonDeserializer<PlayerResponse> playerResponseJsonDeserializer = (json, typeOfT, context) -> {
            Gson tempGson = new GsonBuilder().registerTypeAdapter(Cipher.class, cipherDeserializer).create();
            String jsonRaw = json.getAsString();
            return tempGson.fromJson(jsonRaw, PlayerResponse.class);
        };
        gsonBuilder.registerTypeAdapter(PlayerResponse.class, playerResponseJsonDeserializer);
        return gsonBuilder.create();
    }
}
