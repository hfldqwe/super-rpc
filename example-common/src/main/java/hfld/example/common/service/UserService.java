package hfld.example.common.service;

import hfld.example.common.model.User;

/**
 * 用户服务
 */
public interface UserService {

    User getUser(User user);

    /**
     * 新方法，用于测试mock是否生效
     */
    default short getNumber() {
        return 1;
    }
}
