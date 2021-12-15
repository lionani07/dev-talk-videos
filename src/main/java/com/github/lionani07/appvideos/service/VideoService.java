package com.github.lionani07.appvideos.service;

import com.github.lionani07.appvideos.model.Video;
import com.github.lionani07.appvideos.repository.VideoRepository;
import com.github.lionani07.appvideos.sqs_request.VideoCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    public void create(final VideoCreationRequest videoCreationRequest) {
        this.videoRepository.save(Video.from(videoCreationRequest));
    }

    public List<Video> findByUser(Long userId) {
        return this.videoRepository.findByUser(userId);
    }

}
