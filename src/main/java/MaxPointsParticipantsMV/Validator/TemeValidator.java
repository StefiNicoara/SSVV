package MaxPointsParticipantsMV.Validator;

import MaxPointsParticipantsMV.Domain.Teme;

public class TemeValidator implements Validator<Teme> {
    @Override
    public String validate(Teme t) {
        String m = "";
        if (t.getID() == null || t.getID()<1)
            m = m + "\nID invalid";
        if(t.getDescriere() == null || t.getDescriere().equals(""))
            m = m + "\nDescription invalid";
        if (t.getDeadline() == null || t.getDeadline()>14 || t.getDeadline()<1)
            m = m + "\nDeadline invalid";
        if(t.getSapt_primire() == null ||t.getSapt_primire()>14 || t.getSapt_primire()<1)
            m=m+"\nSaptamana in care tema a fost primita este invalida";
        if(t.getDeadline() != null && t.getSapt_primire() != null)
        {
            if(t.getDeadline()<t.getSapt_primire())
                m = m + "\nSome date is invalid";
        }
        return m;
    }
}
