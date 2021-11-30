package com.github.lionani07.appvideos.resource;

import com.github.lionani07.appvideos.model.Video;
import com.github.lionani07.appvideos.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoResource {

    private final VideoService videoService;

    @GetMapping(params = "user")
    public ResponseEntity<List<Video>> findByUser(@RequestParam(value = "user") Long userId) {
        return ResponseEntity.ok(this.videoService.findByUser(userId));
    }
}

