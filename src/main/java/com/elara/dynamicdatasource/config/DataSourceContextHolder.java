package com.elara.dynamicdatasource.config;

/**
 * DataSourceContextHolder 是一个管理当前线程数据源上下文的工具类。
 * 它允许设置、获取和移除与当前线程关联的数据源名称。
 */
public class DataSourceContextHolder {
    // 用于保存每个线程的数据源名称的 ThreadLocal 变量
    private static final ThreadLocal<String> DATASOURCE_HOLDER = new ThreadLocal<>();

    /**
     * 为当前线程设置数据源名称。
     *
     * @param dataSourceName 要设置的数据源名称。
     */
    public static void setDatasource(String dataSourceName) {
        DATASOURCE_HOLDER.set(dataSourceName);
    }

    /**
     * 获取当前线程的数据源名称。
     *
     * @return 当前线程设置的数据源名称，如果未设置则返回 null。
     */
    public static String getDatasource() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 移除当前线程的数据源名称。
     */
    public static void removeDatasource() {
        DATASOURCE_HOLDER.remove();
    }
}