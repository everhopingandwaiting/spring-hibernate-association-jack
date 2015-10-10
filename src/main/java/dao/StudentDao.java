package dao;

import domain.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by john on 15-9-28.
 */
@Transactional
public class StudentDao {
    private HibernateTemplate template;

    public StudentDao(HibernateTemplate template) {
        this.template = template;
    }

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;

    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) template.find("from Student");

    }

    public void save(Student student) {
        template.save(student);
    }

    public void delete(Student student
    ) {
        template.delete(student);
    }
    public  void  update(Student student) {
        template.update(student);
    }
}
