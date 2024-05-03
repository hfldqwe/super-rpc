package hfld.example.consumer;

import hfld.rpc.config.RpcConfig;
import hfld.rpc.utils.ConfigUtils;

public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc.toString());
    }
}
