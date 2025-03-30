package com.st.plugins;

import com.st.domain.User;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;


/**
 * @author iuuui
 * @time 2024/01/21 1705
 */
@Intercepts({
        @Signature(  // 监听 Executor 接口、方法名为 update 且参数为 MappedStatement.class、Object.class
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}
        )
})
public class ExecutorPlugin implements Interceptor {

    /**
     *  注解 @Signature 可选
     * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
     * ParameterHandler (getParameterObject, setParameters)
     * ResultSetHandler (handleResultSets, handleOutputParameters)
     * StatementHandler (prepare, parameterize, batch, update, query)
     */

    private Properties properties = new Properties();

    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("invoke pre");
        Object returnObject = invocation.proceed();
        System.out.println("invoke after");

        String msg = properties.getProperty("msg");
        System.out.println("properties msg:" + msg);

        return returnObject;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
