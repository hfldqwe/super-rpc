package hfld.rpc.registry;

import hfld.rpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * 注册中心本地缓存
 */
public class RegistryServiceCache {

    /**
     * 服务缓存
     */
    private List<ServiceMetaInfo> serviceCache = null;

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
