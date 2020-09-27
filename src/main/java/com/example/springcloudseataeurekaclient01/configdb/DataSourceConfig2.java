//package com.example.springcloudseataeurekaclient01.configdb;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.baomidou.mybatisplus.core.MybatisConfiguration;
//import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.type.JdbcType;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Auther: 王飞
// * @Date: 2020/09/25/10:34
// * @Description:
// */
//public class DataSourceConfig2 {
//
//    /**
//     * 配置代理数据源
//     * @author thomashe
//     *
//     */
//
//
//        @Bean
//        @ConfigurationProperties(prefix = "spring.datasource")
//        public DataSource druidDataSource() {
//            DruidDataSource druidDataSource = new DruidDataSource();
//            return druidDataSource;
//        }
//
//        @Primary
//        @Bean("dataSource")
//        public DataSourceProxy dataSource(DataSource druidDataSource) {
//            return new DataSourceProxy(druidDataSource);
//        }
//
//        @Bean
//        public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
//            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//            sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//            sqlSessionFactoryBean.setTypeAliasesPackage("com.example.springcloudseataeurekaclient01.bean");
//
//            MybatisConfiguration configuration = new MybatisConfiguration();
//            configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//            configuration.setJdbcTypeForNull(JdbcType.NULL);
//            sqlSessionFactoryBean.setConfiguration(configuration);
//            sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//            return sqlSessionFactoryBean.getObject();
//        }
//
//
//
//}
