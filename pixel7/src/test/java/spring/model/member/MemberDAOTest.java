package spring.model.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.member 
 * 파일명          : MemberDAOTest.java , 2017. 3. 13. 오전 11:36:54
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
public class MemberDAOTest {
	private static BeanFactory beans;
	private static MemberDAO mdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resourec = new ClassPathResource("junit/pixel7.xml");
		beans = new XmlBeanFactory(resourec);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mdao = (MemberDAO) beans.getBean("mdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testCreate() throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setId("2");
		dto.setPassword("2");
		dto.setEmail("email");
		dto.setGrade("normal");
		dto.setInterests("d");
		dto.setProfile("d");
		dto.setPhoto("d");
		dto.setBgphoto("d");
		assertTrue(mdao.create(dto));
	}

	@Test
	@Ignore
	public void testList() throws Exception {
		Map map = new HashMap();
		map.put("col", "");
		map.put("word", "");
		map.put("sno", "");
		map.put("eno", "");
		assertNotNull(mdao.list(map));
	}

	@Test
	@Ignore
	public void testRead() throws Exception {

		assertNotNull(mdao.read("1"));
	}

	@Test
	@Ignore
	public void testUpdate() throws Exception {
		MemberDTO dto = (MemberDTO) mdao.read("1");
		dto.setPhoto("1");
		assertTrue(mdao.update(dto));
	}

	@Test
	@Ignore
	public void testDelete() throws Exception {
		assertTrue(mdao.delete("2"));
	}

	@Test
	@Ignore
	public void testTotal() throws Exception {
		Map map = new HashMap();
		map.put("col", "");
		map.put("word", "");

		assertEquals(mdao.total(map), 6);
	}

	@Test
	@Ignore
	public void testUpdatePw() {
		assertTrue(mdao.updatePw("1", "2"));
	}

	@Test
	@Ignore
	public void testPasswdCheck() {
		assertTrue(mdao.passwdCheck("1", "2"));
	}

	@Test
	@Ignore
	public void testUpdateGd() {
		assertTrue(mdao.updateGd("1", "normal"));
	}

	@Test
	@Ignore
	public void testPhotoName() {
		assertNotNull(mdao.photoName("1"));

	}
	
	@Test
	@Ignore
	public void testStatDate(){
		Map map =new HashMap();
		MemberDTO dto =(MemberDTO)mdao.statDate(map);
		System.out.println("d"+dto.getSignup());
		assertNotNull(dto.getSignup());

	}
	@Test
	@Ignore
	public void testGetgrade(){
		assertEquals(mdao.getGrade("vip"), "vip");
	}
}
