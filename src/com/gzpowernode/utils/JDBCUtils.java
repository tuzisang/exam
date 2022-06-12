package com.gzpowernode.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author tzsang
 * @Description
 * @create 2022-04-08 19:26
 */
public class JDBCUtils {
    private static DruidDataSource dataSource;

    static {
        Properties prop = new Properties();
        // 获取配置文件的输入流
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            // 读取配置文件的流
            prop.load(resourceAsStream);
            // 创建 数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null，说明获取连接失败
     */
    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接，返回数据库连接池
     */
    public static void close(Connection conn){

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
