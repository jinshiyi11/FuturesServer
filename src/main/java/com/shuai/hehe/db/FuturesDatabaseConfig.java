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
 * 期货数据库配置
 */
@Configuration
@MapperScan(value = "com.shuai.hehe.api.mapper", sqlSessionFactoryRef = "futuresSqlSessionFactory")
public class FuturesDatabaseConfig {
    @Bean(name = "futuresDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.futuresdb.datasource")
    public DataSource futuresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "futuresSqlSessionFactory")
    @Primary
    public SqlSessionFactory futuresSqlSessionFactory(
            @Qualifier("futuresDataSource") DataSource db1DataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(db1DataSource);
        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:mapper/futures/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "futuresSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate futuresSqlSessionTemplate(
            SqlSessionFactory futuresSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(futuresSqlSessionFactory);
    }
}
