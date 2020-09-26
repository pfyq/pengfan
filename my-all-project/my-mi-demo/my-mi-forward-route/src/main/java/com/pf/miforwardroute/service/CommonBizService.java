package com.pf.miforwardroute.service;


import com.pf.micommon.enums.StatusEnum;
import com.pf.micommon.exception.CIMException;
import com.pf.micommon.pojo.RouteInfo;
import com.pf.miforwardroute.cache.ServerCache;
import com.pf.miforwardroute.kit.NetAddressIsReachable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Function:
 *
 * @author crossoverJie
 * Date: 2020-04-12 21:40
 * @since JDK 1.8
 */
@Component
public class CommonBizService {
    private static Logger logger = LoggerFactory.getLogger(CommonBizService.class) ;


    @Autowired
    private ServerCache serverCache ;

    /**
     * check ip and port
     * @param routeInfo
     */
    public void checkServerAvailable(RouteInfo routeInfo){
        boolean reachable = NetAddressIsReachable.checkAddressReachable(routeInfo.getIp(), routeInfo.getCimServerPort(), 1000);
        if (!reachable) {
            logger.error("ip={}, port={} are not available", routeInfo.getIp(), routeInfo.getCimServerPort());

            // rebuild cache
            serverCache.rebuildCacheList();

            throw new CIMException(StatusEnum.SERVER_NOT_AVAILABLE) ;
        }

    }
}
