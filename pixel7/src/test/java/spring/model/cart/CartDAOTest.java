package spring.model.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
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

public class CartDAOTest {
	
	private static BeanFactory beans;
	private static CartDAO cdao;
	
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
		cdao = (CartDAO)beans.getBean("cdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testDelete() throws Exception{
		assertTrue(cdao.delete(1));
	}
	
	@Test
	@Ignore
	public void testCreate() throws Exception{
		CartDTO dto = new CartDTO();
		dto.setImg_num(1);
		dto.setId("vip");
		
		assertTrue(cdao.create(dto));
	}
	
	@Test
	@Ignore
	public void testRead() throws Exception{
		CartDTO dto = (CartDTO)cdao.read(2);
		
		assertNotNull(dto);
	}
	
	@Test
	@Ignore
	public void testTotal() throws Exception{
		Map map = new HashMap();
		
		assertEquals(cdao.total(map), 4);
	}
	
	@Test
	public void testList() throws Exception{
		Map map = new HashMap();
		
		assertNotNull(cdao.list(map));
	}

}
