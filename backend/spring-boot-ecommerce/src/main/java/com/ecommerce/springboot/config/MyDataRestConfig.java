package com.ecommerce.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.ecommerce.springboot.entity.Country;


import com.ecommerce.springboot.entity.State;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;

	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

//    @Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

		// disable HTTP methods for ProductCategory: PUT, POST and DELETE
//        disableHttpMethods(Product.class, config, theUnsupportedActions);
//		disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
		disableHttpMethods(Country.class, config, theUnsupportedActions);
		disableHttpMethods(State.class, config, theUnsupportedActions);

		// call an internal helper method
		exposeIds(config);
	}

	@SuppressWarnings("rawtypes")
	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
			HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration().forDomainType(theClass)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}

	@SuppressWarnings("rawtypes")
	private void exposeIds(RepositoryRestConfiguration config) {

		// expose entity ids
		//

		// - get a list of all entity classes from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		// - create an array of the entity types
		List<Class> entityClasses = new ArrayList<>();

		// - get the entity types for the entities
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}

		// - expose the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
	
	

}
