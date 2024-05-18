package hfld.example.provider;

import hfld.example.common.service.UserService;
import hfld.rpc.RpcApplication;
import hfld.rpc.config.RegistryConfig;
import hfld.rpc.config.RpcConfig;
import hfld.rpc.model.ServiceMetaInfo;
import hfld.rpc.registry.LocalRegistry;
import hfld.rpc.registry.Registry;
import hfld.rpc.registry.RegistryFactory;
import hfld.rpc.server.HttpServer;
import hfld.rpc.server.VertxHttpServer;
import hfld.rpc.server.tcp.VertxTcpClient;
import hfld.rpc.server.tcp.VertxTcpServer;

public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(rpcConfig.getServerPort());
    }
}
