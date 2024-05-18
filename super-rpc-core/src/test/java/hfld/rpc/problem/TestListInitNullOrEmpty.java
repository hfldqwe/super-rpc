package hfld.rpc.problem;

import hfld.rpc.model.ServiceMetaInfo;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 问题： 类型为List<Object>出现为null和 size=0的列表 两种情况
 *
 * 具体说明：
 *      cachedServiceMetaInfoList的类型为：List<Object>
 *      运行 if (cachedServiceMetaInfoList != null) 显示 cachedServiceMetaInfoList为size=0的列表，因此判断为true
 *      运行 if (!cachedServiceMetaInfoList.isEmpty()) 显示 cachedServiceMetaInfoList为null, 因此 NullPointException
 *      具体定位：在初始化的过程中使用了反射加载这个类，猜测可能是反射导致初始化行为不一致的问题
 *
 */
public class TestListInitNullOrEmpty {

    public static void main(String[] args) throws Exception {
        Class<?> registryClass = Class.forName("hfld.rpc.problem.TestEtcdRegistry");
        Method discovery = registryClass.getMethod("discovery");
        Object registry = registryClass.getDeclaredConstructor().newInstance();
        discovery.invoke(registry);
    }

}

class TestEtcdRegistry {

    private RegistryServiceCache registryServiceCache = new RegistryServiceCache();

    public void discovery() {
//        System.out.println(registryServiceCache.readCache());
        if (registryServiceCache.readCache() != null) {
            System.out.println("cache != null");
            return;
        }
    }
}


/**
 * 注册中心本地缓存
 */
class RegistryServiceCache {

    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存
     */
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        this.serviceCache = null;
    }
}



