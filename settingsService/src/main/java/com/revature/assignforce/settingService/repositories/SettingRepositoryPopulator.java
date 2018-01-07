package com.revature.assignforce.settingsService.repositories;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.assignforce.settingService.domain.Setting;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.init.Jackson2ResourceReader;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SettingRepositoryPopulator
	implements ApplicationListener< ContextRefreshedEvent>,
			   ApplicationContextAware {
	private final Jackson2ResourceReader resourceReader;
	private final Resource sourceData;

	private ApplicationContext applicationContext;

	public SettingRepositoryPopulator() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		resourceReader = new Jackson2ResourceReader( mapper);
		sourceData = new ClassPathResource( "settings.json");
	}

	@Override
	public void setApplicationContext( ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void onApplicationEvent( ContextRefreshedEvent event) {
		if( event.getApplicationContext().equals( applicationContext)) {
			CrudRepository settingsRepository = BeanFactoryUtils.beanOfTypeIncludingAncestors( applicationContext, CrudRepository.class);

			if( settingsRepository != null && settingsRepository.count() == 0) {
				populate( settingsRepository);
			}
		}
	}

	@SuppressWarnings( "unchecked")
	public void populate( CrudRepository repository) {
		Object entity = getEntityFromResource( sourceData);
		if( entity instanceof Collection) {
			for( Setting settings : ( Collection< Setting>) entity) {
				if( settings != null) {
					repository.save(settings);
				}
			}
		} else {
			repository.save( entity);
		}
	}

	private Object getEntityFromResource( Resource resource) {
		try {
			return resourceReader.readFrom( resource,
					this.getClass().getClassLoader());
		} catch( Exception e) {
			throw new RuntimeException( e);
		}
	}
}
