package dao;

import java.util.List;

import model.StudentWash;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentWash entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.StudentWash
 * @author MyEclipse Persistence Tools
 */

public class StudentWashDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StudentWashDAO.class);
	// property constants
	public static final String DANNUM = "dannum";
	public static final String ZHAONUM = "zhaonum";

	public void save(StudentWash transientInstance) {
		log.debug("saving StudentWash instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentWash persistentInstance) {
		log.debug("deleting StudentWash instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentWash findById(java.lang.Integer id) {
		log.debug("getting StudentWash instance with id: " + id);
		try {
			StudentWash instance = (StudentWash) getSession().get(
					"dao.StudentWash", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentWash instance) {
		log.debug("finding StudentWash instance by example");
		try {
			List results = getSession().createCriteria("dao.StudentWash")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding StudentWash instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StudentWash as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDannum(Object dannum) {
		return findByProperty(DANNUM, dannum);
	}

	public List findByZhaonum(Object zhaonum) {
		return findByProperty(ZHAONUM, zhaonum);
	}

	public List findAll() {
		log.debug("finding all StudentWash instances");
		try {
			String queryString = "from StudentWash";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentWash merge(StudentWash detachedInstance) {
		log.debug("merging StudentWash instance");
		try {
			StudentWash result = (StudentWash) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentWash instance) {
		log.debug("attaching dirty StudentWash instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentWash instance) {
		log.debug("attaching clean StudentWash instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}