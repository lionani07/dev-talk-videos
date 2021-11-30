package com.github.lionani07.appvideos.sqs_request;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoCreationRequest {
    private Long userId;
    private String name;
    private String visibility;
    private String description;
}
