package com.test.sourceCode.thread;


import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 数据库链接
 * @author playboy
 * @date 2020-03-09 14:21
 * version 1.0
 */
@Slf4j
public class MySqlConnectiion {
	private final ShareLock lock;

	public MySqlConnectiion(int maxConnectionSize) {
		this.lock = new ShareLock(maxConnectionSize);
	}

	// 对外获取 mysql 链接的接口
	// 这里不用try finally 的结构，获得锁实现底层不会有异常
	// 即使出现未知异常，也无需释放锁
	public Connection getLimitConnection() {
		if (lock.lock()) {
			return getConnection();
		}
		return null;
	}

	public boolean releaseLimitConnectiion() {
		return lock.unlock();
	}

	public static void main(String[] args) {
		log.info("模仿开始获得MySQL链接");
		MySqlConnectiion mySqlConnectiion = new MySqlConnectiion(10);
		log.info("初始化MySQL最多可以获得10个链接");
		for (int i = 0; i < 12; i++) {
			if (null != mySqlConnectiion.getLimitConnection()) {
				log.info("获得第{}个数据库链接成功", i + 1);
			} else {
				log.info("获得第{}个数据库链接失败：数据库连接池已经满了", i + 1);
			}
		}
		log.info("开始释放数据库链接");
		for (int i = 0; i < 12; i++) {
			if (mySqlConnectiion.releaseLimitConnectiion()) {
				log.info("第{}个数据链接释放成功", i + 1);
			} else {
				log.info("第{}个数据库链接释放失败", i + 1);
			}
		}
		log.info("模仿结束");
	}

	private Connection getConnection() {
		return new Connection() {
			@Override
			public Statement createStatement() throws SQLException {
				return null;
			}

			@Override
			public PreparedStatement prepareStatement(String sql) throws SQLException {
				return null;
			}

			@Override
			public CallableStatement prepareCall(String sql) throws SQLException {
				return null;
			}

			@Override
			public String nativeSQL(String sql) throws SQLException {
				return null;
			}

			@Override
			public void setAutoCommit(boolean autoCommit) throws SQLException {

			}

			@Override
			public boolean getAutoCommit() throws SQLException {
				return false;
			}

			@Override
			public void commit() throws SQLException {

			}

			@Override
			public void rollback() throws SQLException {

			}

			@Override
			public void close() throws SQLException {

			}

			@Override
			public boolean isClosed() throws SQLException {
				return false;
			}

			@Override
			public DatabaseMetaData getMetaData() throws SQLException {
				return null;
			}

			@Override
			public void setReadOnly(boolean readOnly) throws SQLException {

			}

			@Override
			public boolean isReadOnly() throws SQLException {
				return false;
			}

			@Override
			public void setCatalog(String catalog) throws SQLException {

			}

			@Override
			public String getCatalog() throws SQLException {
				return null;
			}

			@Override
			public void setTransactionIsolation(int level) throws SQLException {

			}

			@Override
			public int getTransactionIsolation() throws SQLException {
				return 0;
			}

			@Override
			public SQLWarning getWarnings() throws SQLException {
				return null;
			}

			@Override
			public void clearWarnings() throws SQLException {

			}

			@Override
			public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
				return null;
			}

			@Override
			public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
				return null;
			}

			@Override
			public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
				return null;
			}

			@Override
			public Map<String, Class<?>> getTypeMap() throws SQLException {
				return null;
			}

			@Override
			public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

			}

			@Override
			public void setHoldability(int holdability) throws SQLException {

			}

			@Override
			public int getHoldability() throws SQLException {
				return 0;
			}

			@Override
			public Savepoint setSavepoint() throws SQLException {
				return null;
			}

			@Override
			public Savepoint setSavepoint(String name) throws SQLException {
				return null;
			}

			@Override
			public void rollback(Savepoint savepoint) throws SQLException {

			}

			@Override
			public void releaseSavepoint(Savepoint savepoint) throws SQLException {

			}

			@Override
			public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
				return null;
			}

			@Override
			public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
				return null;
			}

			@Override
			public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
				return null;
			}

			@Override
			public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
				return null;
			}

			@Override
			public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
				return null;
			}

			@Override
			public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
				return null;
			}

			@Override
			public Clob createClob() throws SQLException {
				return null;
			}

			@Override
			public Blob createBlob() throws SQLException {
				return null;
			}

			@Override
			public NClob createNClob() throws SQLException {
				return null;
			}

			@Override
			public SQLXML createSQLXML() throws SQLException {
				return null;
			}

			@Override
			public boolean isValid(int timeout) throws SQLException {
				return false;
			}

			@Override
			public void setClientInfo(String name, String value) throws SQLClientInfoException {

			}

			@Override
			public void setClientInfo(Properties properties) throws SQLClientInfoException {

			}

			@Override
			public String getClientInfo(String name) throws SQLException {
				return null;
			}

			@Override
			public Properties getClientInfo() throws SQLException {
				return null;
			}

			@Override
			public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
				return null;
			}

			@Override
			public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
				return null;
			}

			@Override
			public void setSchema(String schema) throws SQLException {

			}

			@Override
			public String getSchema() throws SQLException {
				return null;
			}

			@Override
			public void abort(Executor executor) throws SQLException {

			}

			@Override
			public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

			}

			@Override
			public int getNetworkTimeout() throws SQLException {
				return 0;
			}

			@Override
			public <T> T unwrap(Class<T> iface) throws SQLException {
				return null;
			}

			@Override
			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				return false;
			}
		};
	}

}
