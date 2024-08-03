package sf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class E535 {


    public class Codec {

        // Encodes a URL to a shortened URL.
        //https://leetcode.com/problems/design-tinyurl
        //http://tinyurl.com/4e9iAk
        //第一种策略：随机数
        //第二种策略：哈系数
        //第三种策略：递增数
        private final Map<String, String> LongURL = new HashMap<>();
        private final Map<String, String> shortURL = new HashMap<>();
        private final String URL = "http://tinyurl.com/";
        private  Long id = 1L;

        public String encode(String longUrl) {
            //加密
            String ShortURL = LongURL.get(longUrl);
            if (ShortURL != null) {
                return ShortURL;
            }
            ShortURL = URL + id;
            LongURL.put(longUrl, ShortURL);
            shortURL.put(ShortURL, longUrl);
            id++;

            return ShortURL;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            //解密
            return shortURL.get(shortUrl);
        }
    }


}
