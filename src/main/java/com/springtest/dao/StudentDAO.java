package com.springtest.dao;

import com.springtest.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO
{
    //@Autowired
    JdbcTemplate template;

    // setter injection
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int saveRecord(Student student){
        System.out.println(student.getName() +", "+student.getAddress()+", "+student.getCourse());
        String sql="insert into student_mvc(name,course,address) values('"+student.getName()+"','"+student.getCourse()+"','"+student.getAddress()+"')";
        return template.update(sql);
    }

    public int delete(int id){
        String sql="delete from student_mvc where id="+id+"";
        return template.update(sql);
    }
    public Student getStudentById(int id){
        String sql="select * from student_mvc where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
    }

    public List<Student> getStudents(){
        return template.query("select * from student_mvc",new RowMapper<Student>(){
            public Student mapRow(ResultSet rs, int row) throws SQLException {
                Student e=new Student();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setCourse(rs.getString(3));
                e.setAddress(rs.getString(4));
                return e;
            }
        });
    }
}
