package jp.org.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.org.web.entity.LoginEntity;


@Repository
public interface LoginDao extends JpaRepository<LoginEntity, String> {

//	@PersistenceContext
//	EntityManager entityManager;
	
//	public void getLoginData() {
//		LoginEntity entity = entityManager.find(LoginEntity.class, "abc");
//		System.out.println("entity loginId  -> " + entity.getLoginId());
//		System.out.println("entity password -> " + entity.getPassword());
//	}

}
