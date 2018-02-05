package com.example.zy.searchbestpractice.util.gson;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */

//public class ImageJsonDeserializer implements JsonDeserializer<Tweet.Image> {
//    @Override
//    public Tweet.Image deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        try {
//            if (json.isJsonObject()) {
//                Tweet.Image image = new Tweet.Image();
//                // The whole object is available
//                final JsonObject jsonObject = json.getAsJsonObject();
//                image.setThumb(context.<String>deserialize(jsonObject.get("thumb"), String.class));
//                image.setHref(context.<String>deserialize(jsonObject.get("href"), String.class));
//                image.setH(context.<Integer>deserialize(jsonObject.get("h"), int.class));
//                image.setW(context.<Integer>deserialize(jsonObject.get("w"), int.class));
//                if (Tweet.Image.check(image))
//                    return image;
//                else
//                    return null;
//            }
//        } catch (Exception e) {
//            TLog.error("ImageJsonDeserializer-deserialize-error:" + (json != null ? json.toString() : ""));
//        }
//        return null;
//    }
//}