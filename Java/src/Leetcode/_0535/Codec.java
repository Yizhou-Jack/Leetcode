package Leetcode._0535;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    public Map<Integer, String> map = new HashMap<>();
    public int i = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
