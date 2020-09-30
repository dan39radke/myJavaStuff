package com.radke.farmersmarketapp.models;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class ORMConfig {

    @Value("${connection.driver_class}")
    private String driver;
    @Value("${connection.url}")
    private String url;
    @Value("${connection.username}")
    private String username;
    @Value("${connection.password}")
    private String password;
    @Value("${hibernate.db.dialect}")
    private String dialect;

    /***
     * Spring bean  to create the dataSource with credentials for hibernate to connect to the DB
     * @return the configured DataSource that can connect to the DB
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    /***
     * Creates a sessionFactory for the provided DataSource and sets the hibernate properties including:
     * dialect, hbm2ddl.auto, showSQL, and formatSQL
     * @param ds the provided DataSource that can connect to the desired DB
     * @return sfBean that is a SessionFactory for hibernate to use
     */
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource ds) {
        LocalSessionFactoryBean sfBean = new LocalSessionFactoryBean();
        sfBean.setDataSource(ds);
        sfBean.setPackagesToScan("com.radke.farmersmarketapp.models");
        sfBean.setHibernateProperties(getProps());
        return sfBean;
    }

    /***
     * Allows Hibernate to manage the transactions
     * @param sf the SessionFactory object that hibernate will manage
     * @return the HibernateTransactionManager object that was created
     */
    @Bean
    HibernateTransactionManager hibernateTransactionManager(SessionFactory sf) {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sf);
        return manager;
    }

    /***
     * defines the properties that are desired and required for our Hibernate
     * @return the properties object with all the properties desired to be included for Hibernate
     */
    private Properties getProps() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", dialect);
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        return props;
    }

}
