package hfld.example.consumer;

import hfld.example.common.model.User;
import hfld.example.common.service.UserService;
import hfld.rpc.config.RpcConfig;
import hfld.rpc.proxy.ServiceProxyFactory;
import hfld.rpc.utils.ConfigUtils;

public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("hfld");

        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        short number = userService.getNumber();
        System.out.println(number);
    }
}
