package hfld.rpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地注册中心
 */
public class LocalRegistry {

    /**
     * 注册信息存储
     */
    private static final Map<String, Class<?>> map = new ConcurrentHashMap<>();

    /**
     * 获取服务
     *
     * @param serviceName
     * @param impClass
     */
    public static void register(String serviceName, Class<?> impClass) {
        map.put(serviceName, impClass);
    }

    /**
     * 获取服务
     * @param serviceName
     * @return
     */
    public static Class<?> get(String serviceName) {
        return map.get(serviceName);
    }

    /**
     * 删除服务
     *
     * @param serverName
     */
    public static void remove(String serverName) {
        map.remove(serverName);
    }
}
