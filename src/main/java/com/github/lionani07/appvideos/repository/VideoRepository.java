package com.github.lionani07.appvideos.repository;

import com.github.lionani07.appvideos.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("SELECT v FROM Video v WHERE v.userId = :userId")
    List<Video> findByUser(@Param("userId") Long userId);
}
