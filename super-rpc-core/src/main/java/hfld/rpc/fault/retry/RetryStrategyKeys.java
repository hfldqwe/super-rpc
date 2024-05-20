package hfld.rpc.fault.retry;

public interface RetryStrategyKeys {

    /**
     * 不重试策略
     */
    String NO = "no";

    /**
     * 固定时间间隔
     */
    String FIXED_INTERVAL = "fixedInterval";
}
