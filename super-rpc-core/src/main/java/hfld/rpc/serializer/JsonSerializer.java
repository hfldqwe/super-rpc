package hfld.rpc.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hfld.rpc.model.RpcRequest;
import hfld.rpc.model.RpcResponse;

import java.io.IOException;

public class JsonSerializer implements Serializer{

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 序列化器
     */
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        return OBJECT_MAPPER.writeValueAsBytes(object);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> classType) throws IOException {
        T object = OBJECT_MAPPER.readValue(bytes, classType);
        if (object instanceof RpcRequest) {
            return handleRequest((RpcRequest) object, classType);
        }
        if (object instanceof RpcResponse) {
            return handleResponse((RpcResponse) object, classType);
        }
        return object;
    }

    /**
     * 由于Object的原始对象会被擦除，导致反序列化时会被作为LinkedHashMap，无法转换成原始对象，因此需要特殊处理
     */
    private <T> T handleRequest(RpcRequest rpcRequest, Class<T> classType) throws IOException {
        Class<?>[] parameterTypes = rpcRequest.getParameterTypes();
        Object[] args = rpcRequest.getArgs();

        // 循环处理每个参数的类型
        for (int i=0; i< parameterTypes.length; i++) {
            Class<?> clazz = parameterTypes[i];
            // 如果类型不同，则重新处理一下类型
            if (!clazz.isAssignableFrom(args[i].getClass())) {
                byte[] argBytes = OBJECT_MAPPER.writeValueAsBytes(args[i]);
                args[i] = OBJECT_MAPPER.readValue(argBytes, clazz);
            }
        }
        return classType.cast(rpcRequest);
    }


    private <T> T handleResponse(RpcResponse rpcResponse, Class<T> classType) throws IOException {
        // 处理响应数据
        byte[] dataBytes = OBJECT_MAPPER.writeValueAsBytes(rpcResponse.getData());
        rpcResponse.setData(OBJECT_MAPPER.readValue(dataBytes, rpcResponse.getDataType()));
        return classType.cast(rpcResponse);

    }
}
