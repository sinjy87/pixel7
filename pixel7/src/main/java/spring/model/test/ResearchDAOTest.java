package spring.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import spring.model.pixel7.ResearchDAO;
import spring.model.pixel7.ResearchDTO;

public class ResearchDAOTest {

	private static ResearchDAO dao;
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
		dao = (ResearchDAO)beans.getBean("redao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testCreate() throws Exception {
		ResearchDTO dto = new ResearchDTO();
		dto.setResearch_title("좋아하는 음식은?");
		
		assertTrue(dao.create(dto));
	}

	@Test @Ignore
	public void testList() throws Exception {
		
		Map map = new HashMap();
//		assertNotNull(dao.list(map));
		List<ResearchDTO> list = dao.list(map);
		Iterator<ResearchDTO> iter = list.iterator();
		
		System.out.println(list.size());
		
		while(iter.hasNext()){
			ResearchDTO dto = iter.next();
			
			System.out.print(dto.getResearch_num());
			System.out.println("  "+dto.getResearch_title());
		}
	}

	@Test @Ignore
	public void testRead() throws Exception {
		int pk = 1;
		ResearchDTO dto = (ResearchDTO) dao.read(pk);
		assertEquals(dto.getResearch_num(),1);
		assertEquals(dto.getResearch_title(), "무슨 색을 좋아 하시나요?");
	}

	@Test @Ignore
	public void testUpdate() throws Exception {
		int pk = 3;
		ResearchDTO dto = (ResearchDTO) dao.read(pk);
		dto.setResearch_title("이 싸이트는 어떻게 알게 되었나요?");
		assertTrue(dao.update(dto));
	}

	@Test @Ignore
	public void testDelete() throws Exception {
		int pk = 1;
		assertTrue(dao.delete(pk));
	}

	@Test 
	public void testTotal() throws Exception {
		Map map = new HashMap();
		System.out.println(dao.total(map));
	}

}
