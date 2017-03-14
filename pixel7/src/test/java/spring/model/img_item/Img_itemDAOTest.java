package spring.model.img_item;

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

public class Img_itemDAOTest {
	
	private static BeanFactory beans;
	private static Img_itemDAO itemdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathResource resource = new ClassPathResource("junit/pixel7.xml");
		beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		itemdao = (Img_itemDAO)beans.getBean("itemdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testCreate() throws Exception  {
		Img_itemDTO dto = new Img_itemDTO();
		dto.setImg_photo("jack.jpg");
		dto.setImg_content("jack");
		dto.setImg_ban(0);
		dto.setImg_price("120");
		dto.setImg_category("dog");
		dto.setId("normal");
		
		assertTrue(itemdao.create(dto));
	}

	@Test @Ignore
	public void testList() throws Exception {
		Map map = new HashMap();
		List list = itemdao.list(map);
		assertEquals(list.size(), 2);
	}

	@Test 
	public void testRead() throws Exception {
		Img_itemDTO dto = itemdao.read(1);
		assertNotNull(dto);
	}

	@Test @Ignore
	public void testUpdate() throws Exception {
		Img_itemDTO dto = new Img_itemDTO();
		dto.setImg_num(1);
		dto.setImg_content("pyramid hade");
		
		assertTrue(itemdao.update(dto));
	}

	@Test @Ignore
	public void testDelete() throws Exception {
		int img_num = 2;
		assertTrue(itemdao.delete(img_num));
	}

	@Test @Ignore
	public void testTotal() {
		fail("Not yet implemented");
	}

}
