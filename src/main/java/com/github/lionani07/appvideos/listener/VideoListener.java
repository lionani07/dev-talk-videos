package com.github.lionani07.appvideos.listener;

import com.github.lionani07.appvideos.service.VideoService;
import com.github.lionani07.appvideos.sqs_request.VideoCreationRequest;
import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class VideoListener {

    private final VideoService videoService;

//    @SqsListener(value = "${cloud.aws.sqs.queues.create_video_queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void sqsListen(final VideoCreationRequest videoCreationRequest) {
        this.videoService.create(videoCreationRequest);
    }
}
