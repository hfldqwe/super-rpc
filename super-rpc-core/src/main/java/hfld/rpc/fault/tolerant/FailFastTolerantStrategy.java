package hfld.rpc.fault.tolerant;

import hfld.rpc.model.RpcResponse;

import java.util.Map;

/**
 * 跨速失败 - 容错策略 （立刻通知外层调用方）
 */
public class FailFastTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        throw new RuntimeException("服务报错", e);
    }
}
