package vn.hcmute;

import java.util.Set;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.SessionTrackingMode;

@Configuration
public class ServletContextConfiguration {
	@Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setSessionTrackingModes(Set.of(SessionTrackingMode.COOKIE));
        };
    }
}
