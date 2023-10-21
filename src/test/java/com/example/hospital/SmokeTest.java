package com.example.hospital;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hospital.controller.PatientController;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PatientController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();

    }

}
