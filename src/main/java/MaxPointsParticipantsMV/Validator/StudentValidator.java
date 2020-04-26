package MaxPointsParticipantsMV.Validator;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Service.ServiceStudent;

public class StudentValidator implements Validator<Student> {
    @Override
    public String validate(Student st) {
        String m = new String();
        m = "";
        if (st.getID() == null || st.getID().equals("") || !st.getID().matches("[0-9]+"))
            m = m + "\nID invalid";
        if (st.getGrupa() < 111 || st.getGrupa() > 937 || st.getGrupa() % 100 / 10 < 1 || st.getGrupa() % 100 / 10 > 3 || st.getGrupa() % 10 < 1 || st.getGrupa() % 10 > 7)
            m = m + "\nGrupa invalida";
        if (st.getMail() == null || st.getMail().equals("") || !st.getMail().contains("@") || !st.getMail().contains("."))
            m = m + "\nEmail invalid";
        if(st.getNume() == null || st.getNume().equals("") || !st.getNume().matches("[A-Za-z ,.'-]+"))
            m=m+"\nNume invalid";
        if(st.getProfesor() == null || st.getProfesor().equals("") || !st.getProfesor().matches("[A-Za-z ,.'-]+"))
            m=m+"\nNume profesor invalid";
        return m;
    }
}
