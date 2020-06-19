package com.ronok.springweb.restapi.healthChecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class systemHealthCheck implements HealthIndicator
{
    public Health health()
    {
        boolean error = false;
        if(error)
        {
            return Health.down().withDetail("Test Erro Occured",420420).build();
        }

        return Health.up().build();
    }
}
