package manager.service;

import manager.dao.TeacherDao;
import manager.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao=new TeacherDao();
    public boolean addTeacher(Teacher teacher) {
//        老师对象交给TeacherDao库管
//        TeacherDao teacherDao=new TeacherDao();
//库管来找老师是否存在
        return teacherDao.addTeacher(teacher);
    }

    public boolean isExists(String id) {
//        TeacherDao teacherDao=new TeacherDao();
        Teacher[] teachers=teacherDao.findAllTeacher();
//        假设id不存在
        boolean exists=false;
//        遍历数组
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                exists=true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
//        用TeacherDao获取老师数组
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        boolean flag=false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher teacher=allTeacher[i];
            if(teacher!=null){
                flag=true;
                break;
            }
        }
        if(flag==true){
            return allTeacher;
        }else {
            return null;
        }
    }

    public void deleteTeacherById(String delId) {
        teacherDao.deleteTeacherById(delId);
    }

    public void updateTeacher(String updateId, Teacher newteacher) {
        teacherDao.updateTeacher(updateId,newteacher);
    }
}
