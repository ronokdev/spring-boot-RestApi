package com.ronok.springweb.restapi.healthChecks;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class customInfoBuilder implements InfoContributor
{
    @Override
    public void contribute(Info.Builder builder)
    {
        builder.withDetail("CustomBuildInfo","This Is CustomBuild Info Just For Testing");
    }
}
