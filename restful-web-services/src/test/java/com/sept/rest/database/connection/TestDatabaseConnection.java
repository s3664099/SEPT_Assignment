package com.sept.rest.database.connection;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDatabaseConnection {
	private static TestDatabase tdb;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tdb = new TestDatabase();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		tdb.closeConnection();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Get Students")
	void test1() {
		ResultSet results = tdb.getStudents();
		
		assertNotNull(results);
	}
	@Test
	@DisplayName("Get wall")
	void test2() {
		ResultSet results = tdb.getPosts(3689650);
		
		boolean hasResults = false;
		try {
			hasResults = results.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(hasResults);
	}
	@Test
	@DisplayName("Get invalid wall")
	void test3() {
		ResultSet results = tdb.getPosts(3689650);
		
		assertNull(results);
	}
	@Test
	@DisplayName("Get comments")
	void test4() {
		ResultSet results = tdb.getWallComments(1);
		
		assertNotNull(results);
	}
	@Test
	@DisplayName("Get no comments")
	void test5() {
		ResultSet results = tdb.getWallComments(5);
		boolean hasResults = false;
		try {
			hasResults = results.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(hasResults);
	}
	@Test
	@DisplayName("Get Invalid comments")
	void test6() {
		ResultSet results = tdb.getWallComments(99);
		
		assertNull(results);
	}
}
