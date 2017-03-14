package spring.model.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

public class NoticeDAOTest {
	private static BeanFactory beans;
	private static NoticeDAO ndao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource = new ClassPathResource("junit/pixel7.xml");
		beans = new XmlBeanFactory(resource);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ndao = (NoticeDAO) beans.getBean("ndao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 	@Ignore
	public void testCreate() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		
		dto.setId("king");
		dto.setNotice_labeldate("2016-01-01");
		dto.setNotice_label("what?");
		dto.setNotice_title("제목");
		dto.setNotice_content("content");
		        
		assertTrue(ndao.create(dto));

	}

	@Test
	public void testList() throws Exception {
		Map map = new HashMap();
		map.put("col", "정동진");
		map.put("word", "31");
		map.put("sno", 1);
		map.put("eno", 5);
		List<NoticeDTO> list = ndao.list(map);
		assertEquals(list.size(), 5);
	}

	@Test
	@Ignore
	public void testRead() throws Exception {
		ndao.upViewcnt(10);
		assertNotNull(ndao.read(2));
	}

	@Test
	@Ignore
	public void testUpdate() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_no(2);
		dto.setNotice_label("ddd");
		dto.setNotice_labeldate("123");
		dto.setNotice_title("asdqwe");
		dto.setNotice_content("asdq");
		assertTrue(ndao.update(dto));

	}

	@Test
	@Ignore
	public void testDelete() throws Exception {
		assertTrue(ndao.delete(4));

	}

	@Test @Ignore
	public void testTotal() throws Exception {
		Map map = new HashMap();
		map.put("col", "");
		map.put("word", "");
		assertNotNull(ndao.total(map));
	}

}
