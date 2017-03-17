package spring.model.i_order;

import static org.junit.Assert.*;

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

public class I_orderDAOTest {
	private static BeanFactory beans;
	private static I_orderDAO idao;
	

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
		idao = (I_orderDAO)beans.getBean("idao");
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
		assertTrue(idao.delete(1));
	}
	
	@Test
	@Ignore
	public void testUpdate() throws Exception{
		I_orderDTO dto = new I_orderDTO();
		dto.setI_order_num(3);
		dto.setI_order_information("주문완료");
		
		assertTrue(idao.update(dto));
	}
	
	@Test
	@Ignore
	public void testRead() throws Exception{
		I_orderDTO dto = (I_orderDTO) idao.read(1);
		
		//assertNull(dto);
	}
	
	@Test
	@Ignore
	public void testCreate() throws Exception{
		I_orderDTO dto = new I_orderDTO();
		dto.setImg_num(1);
		dto.setId("normal");
		dto.setI_order_total(120);
		dto.setI_order_mileage(6);
		dto.setI_order_information("-");
		
		assertTrue(idao.create(dto));
	}
	
	@Test
	@Ignore
	public void testTotal() throws Exception{
		Map map = new HashMap();
		
		//assertNotNull(idao.total(map));
		assertEquals(idao.total(map), 3);
	}
	
	@Test

	public void testList() throws Exception{
		Map map = new HashMap();
		
		assertNotNull(idao.list(map));
	}
	
}
