package com.cx.springboot.config.druid;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class DruidConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DruidConfiguration.class);

    private static final String DB_PREFIX = "spring.datasource";

    @Bean
    public ServletRegistrationBean druidServlet() {
        log.info("init Druid Servlet Configuration(初始化druid配置)");

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "admin");
        initParameters.put("resetEnable", "false");
        initParameters.put("allow", "127.0.0.1"); //IP白名单(没有配置或者为空,则允许所有访问)
//        initParameters.put("deny","192.168.20.38"); //IP黑名单(存在共同时mdeny优先于allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


//    @ConfigurationProperties(prefix = DB_PREFIX)
//    class IDataSourceProperties {
//        private String url;
//        private String username;
//        private String password;
//        private String driverClassName;
//        private int initialSize;
//        private int minIdle;
//        private int maxActive;
//        private int maxWait;
//        private int timeBetweenEvictionRunsMillis;
//        private int minEvictableIdleTimeMillis;
//        private String validationQuery;
//        private boolean testWhileIdle;
//        private boolean testOnBorrow;
//        private boolean testOnReturn;
//        private boolean poolPreparedStatements;
//        private int maxPoolPreparedStatementPerConnectionSize;
//        private String filters;
//        private String connectionProperties;
//
//
//        @Bean
//        @Primary
//        public DataSource dataSource() {
//            DruidDataSource datasource = new DruidDataSource();
//            datasource.setUrl(url);
//            datasource.setUsername(username);
//            datasource.setPassword(password);
//            datasource.setDriverClassName(driverClassName);
//
//            //configuration
//            datasource.setInitialSize(initialSize);
//            datasource.setMinIdle(minIdle);
//            datasource.setMaxActive(maxActive);
//            datasource.setMaxWait(maxWait);
//            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//            datasource.setValidationQuery(validationQuery);
//            datasource.setTestWhileIdle(testWhileIdle);
//            datasource.setTestOnBorrow(testOnBorrow);
//            datasource.setTestOnReturn(testOnReturn);
//            datasource.setPoolPreparedStatements(poolPreparedStatements);
//            datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//            try {
//                datasource.setFilters(filters);
//            } catch (SQLException e) {
//                System.err.println("druid configuration initialization filter: " + e);
//            }
//            datasource.setConnectionProperties(connectionProperties);
//            return datasource;
//        }
//
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getDriverClassName() {
//            return driverClassName;
//        }
//
//        public void setDriverClassName(String driverClassName) {
//            this.driverClassName = driverClassName;
//        }
//
//        public int getInitialSize() {
//            return initialSize;
//        }
//
//        public void setInitialSize(int initialSize) {
//            this.initialSize = initialSize;
//        }
//
//        public int getMinIdle() {
//            return minIdle;
//        }
//
//        public void setMinIdle(int minIdle) {
//            this.minIdle = minIdle;
//        }
//
//        public int getMaxActive() {
//            return maxActive;
//        }
//
//        public void setMaxActive(int maxActive) {
//            this.maxActive = maxActive;
//        }
//
//        public int getMaxWait() {
//            return maxWait;
//        }
//
//        public void setMaxWait(int maxWait) {
//            this.maxWait = maxWait;
//        }
//
//        public int getTimeBetweenEvictionRunsMillis() {
//            return timeBetweenEvictionRunsMillis;
//        }
//
//        public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
//            this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
//        }
//
//        public int getMinEvictableIdleTimeMillis() {
//            return minEvictableIdleTimeMillis;
//        }
//
//        public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
//            this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
//        }
//
//        public String getValidationQuery() {
//            return validationQuery;
//        }
//
//        public void setValidationQuery(String validationQuery) {
//            this.validationQuery = validationQuery;
//        }
//
//        public boolean isTestWhileIdle() {
//            return testWhileIdle;
//        }
//
//        public void setTestWhileIdle(boolean testWhileIdle) {
//            this.testWhileIdle = testWhileIdle;
//        }
//
//        public boolean isTestOnBorrow() {
//            return testOnBorrow;
//        }
//
//        public void setTestOnBorrow(boolean testOnBorrow) {
//            this.testOnBorrow = testOnBorrow;
//        }
//
//        public boolean isTestOnReturn() {
//            return testOnReturn;
//        }
//
//        public void setTestOnReturn(boolean testOnReturn) {
//            this.testOnReturn = testOnReturn;
//        }
//
//        public boolean isPoolPreparedStatements() {
//            return poolPreparedStatements;
//        }
//
//        public void setPoolPreparedStatements(boolean poolPreparedStatements) {
//            this.poolPreparedStatements = poolPreparedStatements;
//        }
//
//        public int getMaxPoolPreparedStatementPerConnectionSize() {
//            return maxPoolPreparedStatementPerConnectionSize;
//        }
//
//        public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
//            this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
//        }
//
//        public String getFilters() {
//            return filters;
//        }
//
//        public void setFilters(String filters) {
//            this.filters = filters;
//        }
//
//        public String getConnectionProperties() {
//            return connectionProperties;
//        }
//
//        public void setConnectionProperties(String connectionProperties) {
//            this.connectionProperties = connectionProperties;
//        }
//    }

}
