package hfld.example.provider;

import hfld.example.common.model.User;
import hfld.example.common.service.UserService;

public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
