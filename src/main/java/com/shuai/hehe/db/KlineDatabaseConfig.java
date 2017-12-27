package com.shuai.hehe.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * k线数据库配置
 */
@Configuration
@MapperScan(value = "com.shuai.hehe.api.klinemapper", sqlSessionFactoryRef = "klineSqlSessionFactory")
public class KlineDatabaseConfig {
    @Bean(name = "klineDataSource")
    @ConfigurationProperties(prefix = "spring.klinedb.datasource")
    public DataSource klineDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "klineSqlSessionFactory")
    public SqlSessionFactory klineSqlSessionFactory(
            @Qualifier("klineDataSource") DataSource db1DataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(db1DataSource);
//        sqlSessionFactoryBean.setMapperLocations(
//                applicationContext.getResources("classpath:mapper/kline/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "klineSqlSessionTemplate")
    public SqlSessionTemplate klineSqlSessionTemplate(
            SqlSessionFactory klineSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(klineSqlSessionFactory);
    }
}
