package manager.dao;

import manager.domain.Teacher;

public class TeacherDao {
    //        创建老师数组
    private static Teacher[] teachers=new Teacher[2];
    public boolean addTeacher(Teacher teacher) {

//        添加老师到数组，判断老师是否存在
        int index=-1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher1=teachers[i];
//            如果ID不存在，用index记录ID
            if(teacher1==null){
                index=i;
                break;
            }
        }
        if(index==-1){//装满了
            return false;
        }else {//没装满，正常添加
            teachers[index]=teacher;
            return true;
        }
    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }

    public void deleteTeacherById(String delId) {
//        查找ID在容器中的索引位置
        int index=getIndex(delId);
//        将该位置用null覆盖
        teachers[index]=null;
    }

    public static int getIndex(String id) {
        int index=-1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String updateId, Teacher newteacher) {
//        查找ID所在索引位置
        int index=getIndex(updateId);
//        该索引位置替换
        teachers[index]=newteacher;
    }
}
