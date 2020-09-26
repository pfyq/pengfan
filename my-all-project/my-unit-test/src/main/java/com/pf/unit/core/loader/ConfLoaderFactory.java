package com.pf.unit.core.loader;



import com.pf.unit.core.exception.NoAlarmLoaderSpecifyException;
import com.pf.unit.core.loader.api.IConfLoader;

import java.util.*;

/**
 * Created by yihui on 2018/2/7.
 */
public class ConfLoaderFactory {

    private static IConfLoader currentAlarmConfLoader;

    public static IConfLoader loader() {
        if (currentAlarmConfLoader == null) {
            synchronized (ConfLoaderFactory.class) {
                if (currentAlarmConfLoader == null) {
                    initConfLoader();
                }
            }
        }

        return currentAlarmConfLoader;
    }


    private static void initConfLoader() {
        Iterator<IConfLoader> iterator = ServiceLoader.load(IConfLoader.class).iterator();

        List<IConfLoader> list = new ArrayList<>();
        // 根据优先级进行排序，选择第一个加载成功的Loader
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        list.sort(Comparator.comparingInt(IConfLoader::order));


        List<IConfLoader> ans = new ArrayList<>(list.size());

        for (IConfLoader iConfLoader : list) {
            if (iConfLoader.load()) {
                ans.add(iConfLoader);
            }
        }


        if (ans.isEmpty()) {
            throw new NoAlarmLoaderSpecifyException("no special alarmConfLoader selected!");
        }


        // 将currentAlarmConfLoader 设置为代理类，内部实现根据报警类型，选择具体的报警解析规则，执行报警
        currentAlarmConfLoader = new ConfLoaderProxy(ans);
    }


}
