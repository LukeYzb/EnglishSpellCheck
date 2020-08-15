package manager.service;

import manager.dao.BaseStudentDao;
import manager.domain.Student;
import manager.factory.StudentDaoFactory;

public class StudentService {
//    通过学生库管工厂类，获取库管对象
    private BaseStudentDao studentDao=StudentDaoFactory.getStudentDao();
//    private OtherStudentDao studentDao=new OtherStudentDao();
    public boolean addStudent(Student student) {
//        学生对象交给StudentDao库管
//        StudentDao studentDao=new StudentDao();
//库管来找学生是否存在
        return studentDao.addStudent(student);
    }

    public boolean isExists(String id) {
//        StudentDao studentDao=new StudentDao();
        Student[] students=studentDao.findAllStudent();
//        假设id不存在
        boolean exists=false;
//        遍历数组
        for (int i = 0; i < students.length; i++) {
            Student student=students[i];
            if(student!=null&&student.getId().equals(id)){
                exists=true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
//        用StudentDao获取学生数组
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag=false;
        for (int i = 0; i < allStudent.length; i++) {
            Student student=allStudent[i];
            if(student!=null){
                flag=true;
                break;
            }
        }
        if(flag==true){
            return allStudent;
        }else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newstudent) {
        studentDao.updateStudent(updateId,newstudent);
    }
}