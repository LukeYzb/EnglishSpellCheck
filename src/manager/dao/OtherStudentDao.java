package manager.dao;

import manager.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentDao{
    //        创建学生数组
    private static ArrayList<Student> students=new ArrayList<>();

    static {
        Student student1=new Student("1","Luke","22","1998-2-26");
        students.add(student1);
    }

    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public Student[] findAllStudent() {
        Student[] students1=new Student[students.size()];
        for (int i = 0; i < students1.length; i++) {
            students1[i]=students.get(i);
        }
        return students1;
    }

    public void deleteStudentById(String delId) {
//        查找ID在容器中的索引位置
        int index=getIndex(delId);
//        将该位置用null覆盖
        students.remove(index);
    }

    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i < students.size(); i++) {
            Student student=students.get(i);
            if(student!=null&&student.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student newstudent) {
//        查找ID所在索引位置
        int index=getIndex(updateId);
//        该索引位置替换
        students.set(index,newstudent);
    }
}
