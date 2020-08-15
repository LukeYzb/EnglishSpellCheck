package manager.factory;

import manager.dao.BaseStudentDao;
import manager.dao.OtherStudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
    }
}
