package spring.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import spring.model.pixel7.MemberResearchDAO;
import spring.model.pixel7.MemberResearchDTO;
import spring.model.pixel7.ResearchDTO;

public class MemberResearchDAOTest {

	
	private static MemberResearchDAO dao;
	private static BeanFactory beans;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource = new ClassPathResource("pixel7.xml");
		beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = (MemberResearchDAO) beans.getBean("mredao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testCreate() throws Exception {
		MemberResearchDTO dto = new MemberResearchDTO();
		dto.setId("king");
		dto.setResearchitem_num(2);
		
		assertTrue(dao.create(dto));
	}

	@Test @Ignore
	public void testList() throws Exception {
	
	}

	@Test 
	public void testRead() throws Exception {
		int pk = 1;
		MemberResearchDTO dto = (MemberResearchDTO) dao.read(pk);

		System.out.println(dto.getResearchitem_num());
	}

	@Test @Ignore
	public void testUpdate() throws Exception {

	}

	@Test @Ignore
	public void testDelete() throws Exception {

	}

	@Test @Ignore
	public void testTotal() throws Exception {

	}
	
	
	
	
	
	
	

}
