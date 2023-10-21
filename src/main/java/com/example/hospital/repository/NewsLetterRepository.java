package com.example.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hospital.model.NewsLetter;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter, Long>{}