package entite.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.util.HibernateUtil;

import entite.base.BaseLigneDAO;
import entite.Ligne;
import entite.base.BaseLigne;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is the object class that relates to the ligne table.
 * Any customizations belong here.
 */
public class LigneDAO extends BaseLigneDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
public List<Ligne> findAll(){
	
		
		try {
			if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
				Transaction transaction = this.sessionFactory.getCurrentSession().getTransaction();
				Transaction tx =this.sessionFactory.getCurrentSession().beginTransaction();
				}
				Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(BaseLigne.class);
				return crit.list();
				
	
		}catch (Exception e){
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
				return null;
			}
		}
			
	
	}

public List<Ligne> search(Ligne ligne) throws Exception {
	try{
	if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
		Transaction transaction = this.sessionFactory.getCurrentSession().getTransaction();
		Transaction tx =this.sessionFactory.getCurrentSession().beginTransaction();}
	return this.sessionFactory.getCurrentSession().createCriteria(BaseLigne.class).add(Restrictions.like(Ligne.PROP_NUMERO, "%"+ligne.getNumero()+"%")).list();
}catch (Exception e){
	throw e;
//	return null;
}
}
public Ligne findByNumero(String numeroLigne){
	
	try {
		if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
			Transaction transaction = this.sessionFactory.getCurrentSession().getTransaction();
			Transaction tx =this.sessionFactory.getCurrentSession().beginTransaction();}
		
			Ligne ligne = (Ligne) this.sessionFactory.getCurrentSession().createCriteria(BaseLigne.class).add(Restrictions.eq(Ligne.PROP_NUMERO, numeroLigne)).uniqueResult();
//					this.sessionFactory.getCurrentSession().close();
			return  ligne;
	}catch (Exception e){
		System.out.println(e);
		return null;
	}
		

}

public void insertLigne(Ligne ligne,boolean uniqueInsert) throws Exception{
	try {
		
//		sessionFactory = HibernateUtil.getSessionFactory();
		
//		ligne.setId(-1);
		if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
			this.sessionFactory.getCurrentSession().getTransaction().begin();}
		this.sessionFactory.getCurrentSession().save((BaseLigne) ligne);
		if(uniqueInsert)
		this.sessionFactory.getCurrentSession().getTransaction().commit();
//		this.sessionFactory.getCurrentSession().persist(ligne);
//		this.sessionFactory.getCurrentSession().flush();
//		this.sessionFactory.getCurrentSession().close();
	}catch (Exception e){
		this.sessionFactory.getCurrentSession().getTransaction().rollback();
		throw e;
	}
}
public void insertListLigne(List<Ligne> listLigne) throws Exception{
	    for(int i = 0; i < listLigne.size(); i++){
	    	
	    	this.insertLigne(listLigne.get(i),false);
	  }
	    this.sessionFactory.getCurrentSession().getTransaction().commit();
}
	
	

public void update(Ligne ligne){
	try {
		
//		sessionFactory = HibernateUtil.getSessionFactory();
		
//		ligne.setId(-1);
		if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
			this.sessionFactory.getCurrentSession().getTransaction().begin();}
		this.sessionFactory.getCurrentSession().update((BaseLigne) ligne);
		this.sessionFactory.getCurrentSession().getTransaction().commit();
//		this.sessionFactory.getCurrentSession().persist(ligne);
//		this.sessionFactory.getCurrentSession().flush();
//		this.sessionFactory.getCurrentSession().close();
	}catch (Exception e){
		this.sessionFactory.getCurrentSession().getTransaction().rollback();
		throw e;
	}
}
	
}