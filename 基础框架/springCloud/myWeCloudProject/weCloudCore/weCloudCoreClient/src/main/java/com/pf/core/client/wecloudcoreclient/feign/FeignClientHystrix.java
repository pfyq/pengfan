package com.pf.core.client.wecloudcoreclient.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClientHystrix implements FeignClientService{
    @Override
    public String getMessage() {
        return "sorry, getMessage service call failed.";
    }
}
