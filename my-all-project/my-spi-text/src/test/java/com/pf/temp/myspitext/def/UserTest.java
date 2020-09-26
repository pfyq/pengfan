package com.pf.temp.myspitext.def;

import com.pf.temp.myspitext.SpiLoader;
import com.pf.temp.myspitext.def.entity.MarketEnum;
import com.pf.temp.myspitext.def.entity.UserDO;
import com.pf.temp.myspitext.def.spi.IUser;
import com.pf.temp.myspitext.exception.SpiProxyCompileException;
import org.junit.Test;

public class UserTest {

    @Test
    public void testUserSPI() throws SpiProxyCompileException {
        SpiLoader<IUser> loader = SpiLoader.load(IUser.class);
        IUser user = loader.getAdaptive();


        UserDO weixinUser = new UserDO();
        weixinUser.setAvatar("weixin.avatar.jpg");
        weixinUser.setUname("微信用户");
        weixinUser.setMarket(MarketEnum.WEIXIN);
        user.welcome(weixinUser);


        UserDO qqUser = new UserDO();
        qqUser.setAvatar("qq.avatar.jpg");
        qqUser.setUname("qq用户");
        qqUser.setMarket(MarketEnum.QQ);
        user.welcome(qqUser);

        System.out.println("-----over------");


    }

}
