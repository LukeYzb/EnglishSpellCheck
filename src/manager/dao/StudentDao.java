package manager.dao;

import manager.domain.Student;

public class StudentDao implements BaseStudentDao{
    //        创建学生数组
    private static Student[] students=new Student[2];

    static {
        Student student1=new Student("1","Luke","22","1998-2-26");
        students[0]=student1;
    }
@Override
    public boolean addStudent(Student student) {

//        添加学生到数组，判断学生是否存在
        int index=-1;
        for (int i = 0; i < students.length; i++) {
            Student student1=students[i];
//            如果ID不存在，用index记录ID
            if(student1==null){
                index=i;
                break;
            }
        }
        if(index==-1){//装满了
            return false;
        }else {//没装满，正常添加
            students[index]=student;
            return true;
        }
    }
@Override
    public Student[] findAllStudent() {
        return students;
    }

    public void deleteStudentById(String delId) {
//        查找ID在容器中的索引位置
        int index=getIndex(delId);
//        将该位置用null覆盖
        students[index]=null;
    }

    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i < students.length; i++) {
            Student student=students[i];
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
        students[index]=newstudent;
    }
}
