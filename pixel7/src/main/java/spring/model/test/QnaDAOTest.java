package spring.model.test;

import static org.junit.Assert.*;

import java.util.HashMap;
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

import spring.model.pixel7.QnaDAO;
import spring.model.pixel7.QnaDTO;

public class QnaDAOTest {
	
	private static BeanFactory beans;
	private static QnaDAO dao;

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
		dao = (QnaDAO)beans.getBean("qdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void testCreate() throws Exception {
		
		QnaDTO dto = new QnaDTO();
		
		
		dto.setId("king");
		dto.setQna_content("King Question23");
		dto.setQna_title("king title");
		dto.setQna_filename("king qna_filename");
		dto.setQna_check(0);
//		assertTrue(dao.create(dto));
		assertTrue(dao.create(dto));
		
	}
	@Test @Ignore
	public void testList() throws Exception {
		Map map = new HashMap();
		map.put("col", "qna_title");
		map.put("word", "1");
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<QnaDTO> list = dao.list(map);
		assertEquals(list.size(), 1);
	}
	
	@Test @Ignore
	public void testread() throws Exception{
		int pk = 1;
		QnaDTO dto = (QnaDTO) dao.read(pk);
		assertEquals(dto.getId(), "king");
		assertEquals(dto.getQna_num(), 1);
		assertEquals(dto.getQna_title(), "testTitle");
		assertEquals(dto.getQna_filename(), "testFilename");
		assertEquals(dto.getQna_content(), "testContent");
	}
	
	@Test @Ignore
	public void testupdate() throws Exception{
		QnaDTO dto = (QnaDTO) dao.read(2);
		
		dto.setQna_content("content변경");
		dto.setQna_filename("filename 변경");
		dto.setQna_title("title 변경");
		
		assertTrue(dao.update(dto));
	}
	
	@Test @Ignore
	public void testdelete() throws Exception{
		int pk = 3;
		assertTrue(dao.delete(pk));
	}
	
	@Test @Ignore
	public void testtotal() throws Exception{
		Map map = new HashMap();
		map.put("col", "qna_title");
		map.put("word", "1");
		
		assertEquals(dao.total(map), 1);
		
		
		
	}
}
