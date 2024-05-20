package hfld.rpc.fault.tolerant;

import hfld.rpc.spi.SpiLoader;

public class TolerantStrategyFactory {

    static {
        SpiLoader.load(TolerantStrategy.class);
    }

    /**
     * 获取实例
     */
    public static TolerantStrategy getInstance(String key) {
        return SpiLoader.getInstance(TolerantStrategy.class, key);
    }
}
