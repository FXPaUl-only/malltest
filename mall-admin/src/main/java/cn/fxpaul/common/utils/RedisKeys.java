package cn.fxpaul.common.utils;

/**
 * Redis所有Keys
 *
 * @author FXPaul
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
