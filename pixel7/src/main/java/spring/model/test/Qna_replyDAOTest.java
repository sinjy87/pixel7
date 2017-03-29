package spring.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import spring.model.pixel7.Qna_replyDAO;
import spring.model.pixel7.Qna_replyDTO;

public class Qna_replyDAOTest {

	private static BeanFactory beans;
	private static Qna_replyDAO dao;
	
	
	
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
		dao = (Qna_replyDAO)beans.getBean("qrdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testCreate() throws Exception {
		
		Qna_replyDTO dto = new Qna_replyDTO();
		
		dto.setId("king");
		dto.setQna_rcontent("rcontent");
		dto.setQna_num(1);
		
		assertTrue(dao.create(dto));

	}

	@Test @Ignore
	public void testList() throws Exception {
		Map map = new HashMap();
		int pk = 1;
		Qna_replyDTO dto = (Qna_replyDTO) dao.read(pk);
		List<Qna_replyDTO> list = dao.list(map);
		assertNotNull(list.size());
				
	}

	@Test  @Ignore
	public void testUpdate() throws Exception {
		int pk = 2;
		Qna_replyDTO dto = (Qna_replyDTO) dao.read(pk);
		dto.setQna_rcontent("123");
		dto.setQna_rnum(2);
		assertTrue(dao.update(dto));
		
	}

	@Test @Ignore
	public void testDelete() throws Exception {
		int pk = 1;
		assertTrue(dao.delete(pk));
	}

}
