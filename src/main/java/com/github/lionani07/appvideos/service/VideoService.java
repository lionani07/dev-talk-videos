package com.github.lionani07.appvideos.service;

import com.github.lionani07.appvideos.model.Video;
import com.github.lionani07.appvideos.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    public Video save(Video video) {
        return this.videoRepository.save(video);
    }

    public List<Video> findByUser(Long userId) {
        return this.videoRepository.findByUser(userId);
    }
}
