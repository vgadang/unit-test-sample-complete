package com.aol.demo.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aol.demo.model.CpsProfile;
import com.aol.demo.utils.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CpsDaoIntegrationTestConfig.class})
@ActiveProfiles("integrationtesting")
public class CpsDaoIntegrationTest {

    @Autowired
	private CpsDao cpsDao;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCpsProfile() {
		final CpsProfile cpsData = cpsDao.getCpsData("sptester1800");
		logger.debug("CpsData: {}", JsonUtils.toJsonStringNonNull(cpsData));
		assertNotNull(cpsData);
	}
		
}
