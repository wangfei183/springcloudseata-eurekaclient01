//package com.example.springcloudseataeurekaclient01.configdb;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//import com.baomidou.mybatisplus.core.MybatisConfiguration;
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import io.seata.rm.datasource.DataSourceProxy;
//
//import org.apache.ibatis.logging.stdout.StdOutImpl;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.type.JdbcType;
//import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }
//
//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSource(DataSource druidDataSource){
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy)throws Exception{
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//
//        // 配置mybatis-plus的分页
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        Interceptor[] plugins = {paginationInterceptor};
//        sqlSessionFactoryBean.setPlugins(plugins);
//
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:/mapper/*.xml"));
//        // 配置spring的本地事务
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//
//        // 配置mybatis-plus的逻辑删除
//        sqlSessionFactoryBean.setGlobalConfig(new GlobalConfig().setSqlInjector(new LogicSqlInjector()));
//
//        // 配置mybatis-plus的log打印
//        MybatisConfiguration cfg = new MybatisConfiguration();
//        cfg.setJdbcTypeForNull(JdbcType.NULL);
//        cfg.setMapUnderscoreToCamelCase(true);
//        cfg.setCacheEnabled(false);
//        cfg.setLogImpl(StdOutImpl.class);
//        sqlSessionFactoryBean.setConfiguration(cfg);
//
//        return sqlSessionFactoryBean.getObject();
//    }
//}
