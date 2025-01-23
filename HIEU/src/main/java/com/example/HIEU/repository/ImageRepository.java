package com.example.HIEU.repository;

import com.example.HIEU.entity.Image;
import com.example.HIEU.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
