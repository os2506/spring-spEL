package com.example.oss.beans;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ApplicationConfigTests {
    
	    @Autowired
	    private FileUploadConfig fileUploadConfig;

	    @Test
	    public void testIsDevelopmentProfile() {
	        boolean isDevelopment = fileUploadConfig.isDevelopmentProfile();
	        assertTrue(isDevelopment, "The 'development' profile should be active.");
	    }

}
