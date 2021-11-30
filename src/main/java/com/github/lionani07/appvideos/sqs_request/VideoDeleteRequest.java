package com.github.lionani07.appvideos.sqs_request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoDeleteRequest {
    private Long videoId;
}
