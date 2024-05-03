package hfld.example.provider;

import hfld.example.common.service.UserService;
import hfld.rpc.RpcApplication;
import hfld.rpc.registry.LocalRegistry;
import hfld.rpc.server.HttpServer;
import hfld.rpc.server.VertxHttpServer;

public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
