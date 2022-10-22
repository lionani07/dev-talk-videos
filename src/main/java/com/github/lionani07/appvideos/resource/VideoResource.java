package com.github.lionani07.appvideos.resource;

import com.github.lionani07.appvideos.model.Video;
import com.github.lionani07.appvideos.service.VideoService;
import com.github.lionani07.appvideos.sqs_request.VideoCreationRequest;
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

    @GetMapping(params = "user")
    public ResponseEntity<List<Video>> findByUser(@RequestParam(value = "user") Long userId) {
        return ResponseEntity.ok(this.videoService.findByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody VideoCreationRequest videoCreationRequest) {
        final var videoCrated = this.videoService.create(videoCreationRequest);

        final var location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(videoCrated.getId())
                .toUri();

        return ResponseEntity.created(location).body(videoCrated);

    }
}

