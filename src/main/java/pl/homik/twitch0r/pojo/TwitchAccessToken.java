package pl.homik.twitch0r.pojo;

import lombok.Data;

@Data
public class TwitchAccessToken {

    private final String sig;
    private final String token;

}
