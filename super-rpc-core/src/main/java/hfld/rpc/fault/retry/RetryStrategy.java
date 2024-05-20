package hfld.rpc.fault.retry;

import hfld.rpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * 重试策略
 */
public interface RetryStrategy {

    /**
     * 重试
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}
