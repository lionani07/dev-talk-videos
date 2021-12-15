package com.github.lionani07.appvideos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lionani07.appvideos.model.enums.VideoVisibilityEnum;
import com.github.lionani07.appvideos.sqs_request.VideoCreationRequest;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "videos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("user_id")
    private Long userId;
    private String name;

    @Enumerated(EnumType.STRING)
    private VideoVisibilityEnum visibility;
    private String description;
    private String url;

    public static Video from(final VideoCreationRequest videoCreationRequest) {
        return Video.builder()
                .userId(videoCreationRequest.getUserId())
                .name(videoCreationRequest.getName())
                .visibility(VideoVisibilityEnum.valueOf(videoCreationRequest.getVisibility().toUpperCase()))
                .description(videoCreationRequest.getDescription())
                .url("http://localhost:8081/videos/" + UUID.randomUUID())
                .build();
    }
}
