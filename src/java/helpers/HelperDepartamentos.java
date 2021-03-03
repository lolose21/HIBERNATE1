package helpers;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Dept;
import pojos.HibernateUtil;

public class HelperDepartamentos {

    Session session;

    public HelperDepartamentos() {
        this.session
                = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Dept> getDepartamentos() {
        // siempre que realizamos consultas hql ,debemos
        //hacerlo mediante una transaccion
        this.session.beginTransaction();
        String hql = "from Dept as dept";
        //las consultas de seleccion se resuelven con objetos query
        Query q = this.session.createQuery(hql);
        //esto automaticamente ya tiene la coleccion
        //de la consulta hql creada(list<Dept>)
        return q.list();

    }

}
