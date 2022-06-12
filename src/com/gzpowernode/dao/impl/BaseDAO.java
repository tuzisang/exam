package com.gzpowernode.dao.impl;

import com.gzpowernode.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tzsang
 * @create 2022-04-22 9:14
 */
public abstract class BaseDAO {
    // 使用 dbUtils 操作数据库
    private QueryRunner runner = new QueryRunner();

    /**
     * update()方法 用来执行Insert/Update/Delete语句
     *
     * @param sql  执行的sql语句
     * @param args
     * @return 如果返回-1，说明执行失败 <br/> 返回其他，说明影响的行数
     */
    public int update(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return -1;
    }

    /**
     * queryForOne()方法 返回查询语句的一条数据
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回类型的泛型
     * @return 如果返回 null，则说明没有数据
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return runner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * queryForList()方法 返回查询语句的多个数据
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @param <T>  返回类型的泛型
     * @return 如果返回null，则说明没有数据
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return runner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;

    }

    /**
     * queryForSingleValue()方法，返回一行一列的数据
     * @param sql 执行的sql
     * @param args sql对应的参数值
     * @return 返回null,说明没有数据
     */
    public Object queryForSingleValue(String sql, Object ... args){
        Connection conn = JDBCUtils.getConnection();

        try {
            return runner.query(conn, sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
}
