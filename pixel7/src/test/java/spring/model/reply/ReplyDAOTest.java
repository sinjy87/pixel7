package spring.model.reply;

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

public class ReplyDAOTest {

	private static BeanFactory beans;
	private static ReplyDAO rdao;
	
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
		
		rdao = (ReplyDAO)beans.getBean("rdao");
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * ��� ����
	 */
	@Test @Ignore
	public void testCreate() {
		ReplyDTO dto = new ReplyDTO();
		dto.setId("vip");
		dto.setReply_content("��� �׽�Ʈ");
		
		assertTrue(rdao.create(dto));
		
	}

	/**
	 * ��� ����
	 */
	@Test @Ignore
	public void testUpdate() throws Exception {
		ReplyDTO dto = new ReplyDTO();
		dto.setReply_num(3);
		dto.setId("vip");
		dto.setReply_content("��� ������Ʈ �׽�Ʈ");
		
		assertTrue(rdao.update(dto));
		
	}
	
	/**
	 * ��� ����
	 */
	@Test @Ignore
	public void testDelete() throws Exception {
		assertTrue(rdao.delete(6));
	}

	/**
	 * ����� ��� ����
	 */
	@Test @Ignore
	public void testRcreate() throws Exception {
		ReplyDTO rdto = (ReplyDTO)rdao.read(3);
		ReplyDTO dto = new ReplyDTO();
		dto.setId("vip");
		dto.setReply_content("�亯 �׽�Ʈ ����3");
		dto.setReply_grpno(rdto.getReply_grpno());
		Map map = new HashMap();
		map.put("reply_grpno", rdto.getReply_grpno());
		map.put("reply_ansnum", dto.getReply_ansnum());
		rdao.upAnsnum(map);
		assertTrue(rdao.rcreate(dto));
	}

	@Test @Ignore
	public void testList() {
		fail("Not yet implemented");
	}

	/**
	 * ��� ����
	 */
	@Test @Ignore
	public void testRead() throws Exception {
		ReplyDTO dto = (ReplyDTO) rdao.read(3);
		assertNotNull(dto);
	}

	@Test @Ignore
	public void testTotal() {
		fail("Not yet implemented");
	}

}
