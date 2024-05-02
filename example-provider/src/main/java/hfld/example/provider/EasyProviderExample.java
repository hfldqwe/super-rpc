package hfld.example.provider;

import hfld.example.common.service.UserService;
import hfld.rpc.registry.LocalRegistry;
import hfld.rpc.server.HttpServer;
import hfld.rpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
