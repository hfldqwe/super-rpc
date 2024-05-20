package hfld.rpc.fault.retry;

import hfld.rpc.spi.SpiLoader;

public class RetryStrategyFactory {

    static {
        SpiLoader.load(RetryStrategy.class);
    }

    /**
     * 获取实例
     */
    public static RetryStrategy getInstance(String key) {
        return SpiLoader.getInstance(RetryStrategy.class, key);
    }
}
