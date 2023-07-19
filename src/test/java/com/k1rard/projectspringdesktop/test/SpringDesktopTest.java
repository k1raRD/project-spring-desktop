/**
 * 
 */
package com.k1rard.projectspringdesktop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.Socket;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.k1rard.projectspringdesktop.dao.DisqueraDAO;
import com.k1rard.projectspringdesktop.dao.impl.DisqueraDAOImpl;

/**
 * @author k1rard
 * Clase de prueba unitaria que permite realizar pruebas con el framework Spring.
 */
class SpringDesktopTest {

	@Test
	void testContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertNotNull(context);
		
		DisqueraDAO disqueraDAO = (DisqueraDAO) context.getBean("disqueraDAO");
		assertNotNull(disqueraDAO);
		
		DisqueraDAO disqueraDAONuevo = (DisqueraDAO) context.getBean("disqueraDAO");
		
		DisqueraDAO disqueraDAOSinSpring = new DisqueraDAOImpl();
		DisqueraDAO disqueraDAOSinSpringNuevo = new DisqueraDAOImpl();
		
		System.out.println("Contexto cargado con exito");
		System.out.println(disqueraDAO);
		System.out.println(disqueraDAONuevo);
		System.out.println(disqueraDAOSinSpring);
		System.out.println(disqueraDAOSinSpringNuevo);
		
		// :::::::::::::: PROPERTIES :::::::::::::
		
		Properties properties =  (Properties) context.getBean("properties");
		String username = (String) properties.get("spring.username");
		System.out.println("The username is: " + username);
	}

}
