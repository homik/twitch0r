package pl.homik.twitch0r.service

import org.junit.Test
import pl.homik.twitch0r.pojo.TwitchAccessToken
import spock.lang.Specification


class TwitchServiceUnitTest extends Specification {

    TwitchService service

    def setup() {
        service = new TwitchService();
    }

    @Test
    def "should parse access token json"() {

        given: "i have "
        def json = "{\"token\":\"{\\\"adblock\\\":true,\\\"authorization\\\":{\\\"forbidden\\\":false,\\\"reason\\\":\\\"\\\"},\\\"channel\\\":\\\"ptys\\\",\\\"channel_id\\\":183087000,\\\"chansub\\\":{\\\"restricted_bitrates\\\":[],\\\"view_until\\\":1924905600},\\\"ci_gb\\\":false,\\\"device_id\\\":\\\"yX4MZSINwRjHSS90C94MeuYkwbALRyAj\\\",\\\"expires\\\":1529010082,\\\"game\\\":\\\"\\\",\\\"hide_ads\\\":false,\\\"https_required\\\":false,\\\"mature\\\":false,\\\"partner\\\":false,\\\"platform\\\":null,\\\"player_type\\\":null,\\\"private\\\":{\\\"allowed_to_view\\\":true},\\\"privileged\\\":false,\\\"show_ads\\\":true,\\\"subscriber\\\":false,\\\"turbo\\\":false,\\\"user_id\\\":null,\\\"version\\\":2}\",\"sig\":\"5959251f68f800d515c51f56503d1108895399e7\",\"mobile_restricted\":false}"

        when: "token parsing is executed"
        TwitchAccessToken result = service.parseAccessTokenJson(json)

        then: "sig and token are available in result object"
        result.sig == "5959251f68f800d515c51f56503d1108895399e7"
        result.token == "{\"adblock\":true,\"authorization\":{\"forbidden\":false,\"reason\":\"\"},\"channel\":\"ptys\",\"channel_id\":183087000,\"chansub\":{\"restricted_bitrates\":[],\"view_until\":1924905600},\"ci_gb\":false,\"device_id\":\"yX4MZSINwRjHSS90C94MeuYkwbALRyAj\",\"expires\":1529010082,\"game\":\"\",\"hide_ads\":false,\"https_required\":false,\"mature\":false,\"partner\":false,\"platform\":null,\"player_type\":null,\"private\":{\"allowed_to_view\":true},\"privileged\":false,\"show_ads\":true,\"subscriber\":false,\"turbo\":false,\"user_id\":null,\"version\":2}"

    }

}