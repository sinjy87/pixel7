package spring.model.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import spring.model.pixel7.ResearchItemDAO;
import spring.model.pixel7.ResearchItemDTO;

public class ResearchItemDAOTest {
	
	private static ResearchItemDAO dao;
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
		dao = (ResearchItemDAO) beans.getBean("reidao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testCreate() throws Exception {
		ResearchItemDTO dto1 = new ResearchItemDTO();
		dto1.setResearch_num(1);
		dto1.setResearchitem_content("°ËÁ¤»ö");
		
		ResearchItemDTO dto2 = new ResearchItemDTO();
		dto2.setResearch_num(1);
		dto2.setResearchitem_content("Èò»ö");
		
		ResearchItemDTO dto3 = new ResearchItemDTO();
		dto3.setResearch_num(1);
		dto3.setResearchitem_content("ÆÄ¶û»ö");
		
		ResearchItemDTO dto4 = new ResearchItemDTO();
		dto4.setResearch_num(1);
		dto4.setResearchitem_content("»¡°£»ö");
		
		
		assertTrue(dao.create(dto1));
		assertTrue(dao.create(dto2));
		assertTrue(dao.create(dto3));
		assertTrue(dao.create(dto4));
		

	}

	@Test @Ignore
	public void testList() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testRead() throws Exception {
		int pk = 1;
		ResearchItemDTO dto = (ResearchItemDTO) dao.read(pk);
		System.out.println(dto.getResearchitem_content());
		
	}

	@Test @Ignore
	public void testUpdate() throws Exception {
		int pk = 1;
		ResearchItemDTO dto = (ResearchItemDTO) dao.read(pk);
		dto.setResearchitem_content("black");
		assertTrue(dao.update(dto));
	}

	@Test 
	public void testDelete() throws Exception {
		int pk = 1;
		assertTrue(dao.delete(pk));
	}

	@Test @Ignore
	public void testTotal() {
		fail("Not yet implemented");
	}

}
