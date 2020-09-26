package com.pf.unit.core.loader.helper;

import com.pf.unit.core.entity.AlarmConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by yihui on 2018/2/7.
 */
@Slf4j
public class PropertiesConfListenerHelper {

    public static boolean registerConfChangeListener(File file, Function<File, Map<String, AlarmConfig>> func) {
        try {
            // 轮询间隔 5 秒
            long interval = TimeUnit.SECONDS.toMillis(5);


            File dir = file.getParentFile();

            // 创建一个文件观察器用于处理文件的¬格式
            FileAlterationObserver observer = new FileAlterationObserver(dir,
                    FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
                            FileFilterUtils.nameFileFilter(file.getName())));

            //设置文件变化监听器
            observer.addListener(new MyFileListener(func));
            FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
            monitor.start();

            return true;
        } catch (Exception e) {
            log.error("register properties change listener error! e:{}", e);
            return false;
        }
    }


    static final class MyFileListener extends FileAlterationListenerAdaptor {

        private Function<File, Map<String, AlarmConfig>> func;

        public MyFileListener(Function<File, Map<String, AlarmConfig>> func) {
            this.func = func;
        }

        @Override
        public void onFileChange(File file) {
            System.out.println("change >>> " + System.currentTimeMillis());
            Map<String, AlarmConfig> ans = func.apply(file); // 如果加载失败，打印一条日志
            log.warn("PropertiesConfig changed! reload ans: {}", ans);
        }
    }
}
