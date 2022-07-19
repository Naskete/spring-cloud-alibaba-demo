package com.naskete.Filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {
    public LogGatewayFilterFactory() {
        super(LogGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog", "cacheLog");
    }

    @Override
    public GatewayFilter apply(LogGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            if (config.isCacheLog()) {
                System.out.println("cacheLog 已经开启");
            }
            if (config.isConsoleLog()) {
                System.out.println("consoleLog 已经开启");
            }
            return chain.filter(exchange);
        };
    }

    @Data
    @NoArgsConstructor
    static class Config {
        private boolean consoleLog;
        private boolean cacheLog;

        public boolean isConsoleLog() {
            return consoleLog;
        }

        public void setConsoleLog(boolean consoleLog) {
            this.consoleLog = consoleLog;
        }

        public boolean isCacheLog() {
            return cacheLog;
        }

        public void setCacheLog(boolean cacheLog) {
            this.cacheLog = cacheLog;
        }
    }
}
