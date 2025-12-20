package com.example.demo.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to enable Servlet component scanning.
 * This ensures that @WebServlet annotations in the 'servlet' package
 * are automatically registered by the Spring container.
 */
@Configuration
@ServletComponentScan(basePackages = "com.example.demo.servlet")
public class ServletConfig {
    // No additional beans are required here as @ServletComponentScan 
    // handles the registration of SimpleStatusServlet and HelloServlet.
}