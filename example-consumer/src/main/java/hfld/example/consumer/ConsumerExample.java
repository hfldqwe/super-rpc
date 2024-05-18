package hfld.example.consumer;

import hfld.example.common.model.User;
import hfld.example.common.service.UserService;
import hfld.rpc.proxy.ServiceProxyFactory;

public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("hfld");

        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println("user == "+newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
