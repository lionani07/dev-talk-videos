package com.github.lionani07.appvideos.resource;

import com.github.lionani07.appvideos.model.Video;
import com.github.lionani07.appvideos.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoResource {

    private final VideoService videoService;

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody Video video) {
        final var videoCreated = this.videoService.save(video);

        final var location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(videoCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(videoCreated);
    }

    @GetMapping(params = "user")
    public ResponseEntity<List<Video>> findByUser(@RequestParam(value = "user") Long userId) {
        final var videos = this.videoService.findByUser(userId);
        return ResponseEntity.ok(videos);
    }
}

