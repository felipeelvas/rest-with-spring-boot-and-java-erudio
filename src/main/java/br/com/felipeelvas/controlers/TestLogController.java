package br.com.felipeelvas.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/log")
    public  String testLog() {
        logger.info("Test log endpoint hit!");
        logger.debug("This is a DEBUG message for testing purposes.");
        logger.error("This is an ERROR message for testing purposes.");
        logger.warn("This is a WARNING message for testing purposes.");
        logger.trace("This is a TRACE message for testing purposes.");
        logger.info("Log messages generated successfully!");
        // You can add more log messages with different levels as needed
        return "Log messages generated successfully!";
    }
}
