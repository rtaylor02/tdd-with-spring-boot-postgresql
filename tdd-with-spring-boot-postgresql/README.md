# Source
This project is based on course '[Spring Boot: Test-Driven Development](https://www.linkedin.com/learning/spring-boot-test-driven-development/web-testing-with-spring?resume=false&u=89799330)' by Frank P. Moley III on LinkedInLearning.

# Summary
## Unit Test
### Annotations
Class:
- @ExtendWith(MockitoExtension.class)

Field:
- @InjectMocks private CustomerService customerService;
- @Mock private CustomerDao customerDao;

Method:
- @Test

### SUT method calls
- service's methods

### Framework method calls
- when(mock.doesSomething()).thenReturn(expectedMockReturnValue);
- assertThat(actualResult).isEqualTo(expectedResult);

## Service Integration Test
### Annotations
Class:
- @SpringBootTest
- @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

Field:
- @Autowired private CustomerService customerService;

Method:
- @Test

### SUT method calls
- service's methods

### Framework method calls
- assertThat(actualResult).isEqualTo(expectedResult);

## Controller Integration Test
### Annotations
Class:
- @SpringBootTest
- @AutoConfigureMockMvc
- @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

Field:
- @Autowired private MockMvc mockMvc;

Method:
- @Test 

### SUT method calls
- nothing as there is no SUT

### Framework method calls
- mockMvc.perform(get("/customers"))
  .andExpect(status().isOk())
  .andExpect(content().string(containsString("aStringInTheContents")));
