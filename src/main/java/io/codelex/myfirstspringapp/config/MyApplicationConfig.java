package io.codelex.myfirstspringapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myapp")
public class MyApplicationConfig {

    private String greeting;

    private String goodbye;

    private String name;

    private String lastGoodbye;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGoodbye() {
        return goodbye;
    }

    public void setGoodbye(String goodbye) {
        this.goodbye = goodbye;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastGoodbye() {
        return lastGoodbye;
    }

    public void setLastGoodbye(String lastGoodbye) {
        this.lastGoodbye = lastGoodbye;
    }
}
