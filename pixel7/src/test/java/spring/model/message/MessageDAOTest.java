package spring.model.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Iterator;
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
/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.message 
 * 파일명          : MessageDAOTest.java , 2017. 3. 15. 오후 12:00:00
 * 작성자          : 정내용
 * 작성자 email    : content_j@naver.com
 * 수정내용
 * ----------------------------------------------
 * 수정 이력
 * ---------------------------------------------- 
 * 수정일      수정자  연락처
 *   
 * 수정내용
 *
 * ----------------------------------------------
 * 
 *</pre>
 */
public class MessageDAOTest {
	
	private static BeanFactory beans;
	private static MessageDAO msdao;
	

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
		msdao= (MessageDAO)beans.getBean("msdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test@Ignore
	public void testCreate() throws Exception {
		MessageDTO dto = new MessageDTO();
		dto.setId("king");
		dto.setMessage_content("J_test");
		dto.setMessage_id("vip");
		assertTrue(msdao.create(dto));
	}

	@Test
	@Ignore
	public void testList() throws Exception {
		Map map =new HashMap();
		map.put("col", "id");
		map.put("word", "king");
		map.put("sno", 1);
		map.put("eno", 5);
		assertNotNull(msdao.list(map));
	
	}

	@Test
	@Ignore
	public void testRead() throws Exception {
		MessageDTO dto=(MessageDTO)msdao.read(1);
		assertEquals(dto.getId(),"king" );
	}

	@Test@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test@Ignore
	public void testDelete() throws Exception {
		assertTrue(msdao.delete(1));
	}

	@Test
	public void testTotal() throws Exception {
		Map map =new HashMap();
		map.put("col", "id");
		map.put("word", "king");
		map.put("sno", 1);
		map.put("eno", 5);
		assertEquals(msdao.total(map),1);
	}

}
