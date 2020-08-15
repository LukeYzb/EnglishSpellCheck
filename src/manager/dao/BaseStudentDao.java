package manager.dao;

import manager.domain.Student;

public interface BaseStudentDao {
    public abstract boolean addStudent(Student student);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String delId);

    public abstract int getIndex(String id);

    public abstract void updateStudent(String updateId, Student newstudent);
}
