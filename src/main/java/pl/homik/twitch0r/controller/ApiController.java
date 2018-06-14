package pl.homik.twitch0r.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.homik.twitch0r.pojo.StreamInfo;

import java.util.List;

@RestController
public class ApiController {

    @GetMapping(value = "/api/{channel}")
    public List<StreamInfo> getStreamInfo(@PathVariable String channel) {
        return null;
    }
}
