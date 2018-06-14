package pl.homik.twitch0r.service;

import spock.lang.Specification;

class TwitchServiceIntegrationTest extends Specification {

    TwitchService service

    def setup() {
        service = new TwitchService();
    }

    def "should load m3u8 file"() {
        given:

        def alwaysAvailableChannel = "streamerhouse"
        when:
        def result = service.getM3U8FileForChannel(alwaysAvailableChannel)

        then:
        result.startsWith("#EXTM3U")

    }
}
