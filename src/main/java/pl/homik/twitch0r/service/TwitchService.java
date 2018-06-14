package pl.homik.twitch0r.service;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import pl.homik.twitch0r.pojo.TwitchAccessToken;

import java.net.URL;
import java.util.*;

public class TwitchService {

    private static final String USHER_API = "http://usher.twitch.tv/api/channel/hls/{channel}.m3u8?player=twitchweb" +
            "&token={token}&sig={sig}&$allow_audio_only=true&allow_source=true" +
            "&type=any&p={random}";
    private static final String TOKEN_API = "https://api.twitch.tv/api/channels/{channel}/access_token?client_id=kd1unb4b3q4t58fwlpcbzcbnm76a8fp";

    private TwitchAccessToken getAccessToken(String channel) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = Collections.singletonMap("channel", channel);
        String result = restTemplate.getForObject(TOKEN_API, String.class, params);
        return parseAccessTokenJson(result);
    }

    private TwitchAccessToken parseAccessTokenJson(String result) {

        JSONObject obj = new JSONObject(result);

        String token = obj.getString("token");
        String sig = obj.getString("sig");
        return new TwitchAccessToken(sig, token);
    }

    public String getM3U8FileForChannel(String channel) {
        TwitchAccessToken at = getAccessToken(channel);
        int random = new SplittableRandom().nextInt(0, 1_000_000);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> params = new HashMap<>();
        params.put("channel", channel);
        params.put("sig", at.getSig());
        params.put("token", at.getToken());
        params.put("random", random);
        return restTemplate.getForObject(USHER_API, String.class, params);
    }


}
