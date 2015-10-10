package dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import config.DaoConfig;
import domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by john on 15-9-29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  {DaoConfig.class,TestDaoConfiguration.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class StudentDaoIntergrationTest {
    @Autowired
    public ApplicationContext context;
    @Autowired
    public StudentDao studentDao;
    @Qualifier("student2")
    @Autowired
    public Student student2;

    @Qualifier("student1")
    @Autowired
    public Student student1;

    @Test
    @DatabaseSetup("dao/beforeSave.xml")
    public void testFindAll() {
        List<Student> students = studentDao.findAll();
        assertThat(students.size(), is(1));
    }
}
