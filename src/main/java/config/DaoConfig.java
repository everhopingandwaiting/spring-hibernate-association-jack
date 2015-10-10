package config;

import dao.ClassDao;
import dao.CourseDao;
import dao.NumberDao;
import dao.StudentDao;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by john on 15-9-29.
 */
@Configuration
@EnableTransactionManagement
public class DaoConfig {
    @Bean
    public ClassDao classDao() {
        return new ClassDao(hibernateTemplate());
    }

    @Bean
    public CourseDao courseDao() {
        return new CourseDao(hibernateTemplate());
    }

    @Bean
    public NumberDao numberDao() {
        return new NumberDao(hibernateTemplate());
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDao(hibernateTemplate());
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {

        return new HibernateTemplate(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory() {
    return new LocalSessionFactoryBuilder(dataSource()).scanPackages("domain").
            setProperty("hibernate.show_sql", "true")
            .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
            .buildSessionFactory();

}



    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql").build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
