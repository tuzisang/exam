package com.gzpowernode.test;

import com.gzpowernode.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author tzsang
 * @create 2022-04-22 9:12
 */
public class ConnectionTest {
    @Test
    public void testConnection(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        JDBCUtils.close(connection);
    }
}
