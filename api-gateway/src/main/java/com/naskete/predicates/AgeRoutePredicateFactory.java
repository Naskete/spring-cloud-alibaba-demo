package com.naskete.predicates;

import com.alibaba.nacos.common.utils.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
@Slf4j
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    public  AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        // 与配置文件参数顺序一致
        return Arrays.asList("minAge", "maxAge");
    }

    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //从serverWebExchange获取传入的参数
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.isNotEmpty(ageStr)) {
                    int age = Integer.parseInt(ageStr);
                    log.info(">> get age params, age = " + age);
                    return age > config.getMinAge() && age < config.getMaxAge();
                }
                return true;
            }
        };
    }

    @Data
    static class Config {
        private int minAge;
        private int maxAge;

        public int getMinAge() {
            return minAge;
        }

        public void setMinAge(int minAge) {
            this.minAge = minAge;
        }

        public int getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(int maxAge) {
            this.maxAge = maxAge;
        }
    }
}
