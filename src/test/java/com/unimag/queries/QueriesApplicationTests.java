package com.unimag.queries;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.unimag.queries.entityTest.PersonaEntityTest;
import com.unimag.queries.repositoryTest.PersonaRepositoryTest;

@RunWith(value = Suite.class)
@SuiteClasses({PersonaEntityTest.class, PersonaRepositoryTest.class})
@SpringBootTest
public class QueriesApplicationTests {

}
