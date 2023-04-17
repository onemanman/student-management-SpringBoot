package com.galaxy.studentmanagement.repository;

import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static org.jooq.impl.DSL.jsonbTable;
import static org.jooq.impl.DSL.table;
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    String name = "Student3.name";
    private final DSLContext dsl;

    public StudentRepositoryImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Student> getAll() {
    return dsl.select().from(table("Student3")).fetch().into(Student.class);
    }

    @Override
    public Student findById(int stt) {
        return dsl.select().from(table("Student3")).where(DSL.field("stt").eq(stt)).fetchOneInto(Student.class);
    }

    @Override
    public Student create(StudentDTO studentDTO) {
        int stt = Objects.requireNonNull(dsl.insertInto(table("Student3"))
                        .set(DSL.field("name"), studentDTO.getName())
                        .set(DSL.field("age"), studentDTO.getAge())
                        .set(DSL.field("gender"), studentDTO.getGender())
                        .set(DSL.field("math"), studentDTO.getMath())
                        .set(DSL.field("biology"), studentDTO.getBiology())
                        .set(DSL.field("literature"), studentDTO.getLiterature())
                        .returningResult(DSL.field("stt"))
                        .fetchOne())
                .into(Integer.class);
        return findById(stt);
    }

    @Override
    public void deleteById(int stt) {
        dsl.deleteFrom(table("Student3")).where(DSL.field("stt").eq(stt)).execute();

    }


}
