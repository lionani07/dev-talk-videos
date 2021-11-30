package com.github.lionani07.appvideos.listener;

import com.github.lionani07.appvideos.service.VideoService;
import com.github.lionani07.appvideos.sqs_request.VideoDeleteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VideoDeleteListener {

    private final VideoService videoService;

    @SqsListener(value = "${cloud.aws.sqs.queues.delete_video_queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void sqsListen(final VideoDeleteRequest videoDeleteRequest) {
        this.videoService.delete(videoDeleteRequest.getVideoId());
    }
}
