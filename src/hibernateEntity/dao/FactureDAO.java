package hibernateEntity.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.util.HibernateUtil;

import hibernateEntity.Facture;
import hibernateEntity.Ligne;
import hibernateEntity.Porteur;
import hibernateEntity.base.BaseFactureDAO;
import hibernateEntity.base.BaseFacture;
import hibernateEntity.base.BaseLigne;
import hibernateEntity.base.BasePorteur;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is the object class that relates to the facture table.
 * Any customizations belong here.
 */
public class FactureDAO extends BaseFactureDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	private void insertFacture(Facture facture,boolean uniqueInsert) throws Exception{
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
				this.sessionFactory.getCurrentSession().getTransaction().begin();}
			
//			this.sessionFactory.getCurrentSession().persist(facture);
////			this.sessionFactory.getCurrentSession().flush();
			
//			facture.setLigne((Ligne) this.sessionFactory.getCurrentSession().load(Ligne.class, facture.getLigne().getId()));
//			Ligne ligne = facture.getLigne();
//			ligne.setNumeroLigne("+2120");
//			ligne.setId(null);
//			facture.setLigne(ligne);
			
//			this.sessionFactory.getCurrentSession().delete((BaseLigne) facture.getLigne()); 
//			this.sessionFactory.getCurrentSession().getTransaction().commit();
//			if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
//				this.sessionFactory.getCurrentSession().getTransaction().begin();}
			
			this.sessionFactory.getCurrentSession().save((BaseFacture) facture);
			if(uniqueInsert)
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception e){
			this.sessionFactory.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	
	public void insertListFacture(List<Facture> listFacture) throws Exception{
		    for(int i = 0; i < listFacture.size(); i++){
		    	
		    	this.insertFacture(listFacture.get(i),false);
		  }
		    this.sessionFactory.getCurrentSession().getTransaction().commit();
//		    this.sessionFactory.getCurrentSession().flush();
	}

	public List<Facture> findByNumero(Ligne ligne) {


		try {
			if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
				Transaction transaction = this.sessionFactory.getCurrentSession().getTransaction();
				Transaction tx =this.sessionFactory.getCurrentSession().beginTransaction();}
				return (List<Facture>) this.sessionFactory.getCurrentSession().createCriteria(BaseFacture.class).add(Restrictions.eq(Facture.PROP_LIGNE, ligne)).list();
//						this.sessionFactory.getCurrentSession().close();
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
		
	}

	public List<Facture> findByMoisAnnee(String mois, String annee) {
		try {
			if(!this.sessionFactory.getCurrentSession().getTransaction().isActive()){
				Transaction transaction = this.sessionFactory.getCurrentSession().getTransaction();
				Transaction tx =this.sessionFactory.getCurrentSession().beginTransaction();}
				return (List<Facture>) this.sessionFactory.getCurrentSession().createCriteria(BaseFacture.class).add(Restrictions.eq(Facture.PROP_MOIS, mois)).add(Restrictions.eq(Facture.PROP_ANNEE, annee)).list();
//						this.sessionFactory.getCurrentSession().close();
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	
	
	
	
}