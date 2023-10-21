// package com.example.hospital;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatchers;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;
// import com.example.hospital.model.Patient;
// import com.example.hospital.service.PatientService;
// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.when;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// public class HttpRequestUser {

//     @Autowired
//     private WebApplicationContext webApplicationContext;
//     private MockMvc mockMvc;

//     @MockBean
//     private PatientService userService;

//     @BeforeEach
//     public void setup() {
//         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

//         List<Patient> patient = new ArrayList<>();
//         patient.add(new Patient(1, "John Doe", true));
//         patient.add(new Patient(2, "Jane Smith", false));

//         when(userService.getAll()).thenReturn(patient);
//         when(userService.getById(ArgumentMatchers.eq(1))).thenReturn(Optional.of(patient.get(0)));
//         when(userService.getById(ArgumentMatchers.eq(2))).thenReturn(Optional.of(patient.get(1)));

//     }

//     @Test
//     public void testGetUserById() throws Exception {
//         int userId = 1; // Replace with a valid user ID

//         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/hospital/patients/{id}", userId))
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andReturn();

//         if (result.getResponse().getStatus() == HttpStatus.OK.value()) {
//             // User found
//             mockMvc.perform(MockMvcRequestBuilders.get("/api/hospital/patients/{id}", userId))
//                     .andExpect(MockMvcResultMatchers.status().isOk())
//                     .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userId))
//                     .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"));
//         } else {
//             // check this not working
//             mockMvc.perform(MockMvcRequestBuilders.get("/api/hospital/patients/{id}", userId))
//                     .andExpect(MockMvcResultMatchers.status().isNotFound())
//                     .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Patient not found"));
//         }
//     }

//     @Test
//     public void testGetAllUsers() throws Exception {

//         mockMvc.perform(MockMvcRequestBuilders.get("/api/hospital/patients"))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType("application/json"));

//     }

//     @Test
//     public void postUser() throws Exception {
//         Patient testUser = new Patient(1, "John Doe", true);
//         String requestBody = "{ \"id\": 1, \"name\": \"John Doe\", \"active\": true }";

//         doNothing().when(userService).save(testUser);

//         mockMvc.perform(MockMvcRequestBuilders.post("/api/hospital/newPatient")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(requestBody))
//                 .andExpect(MockMvcResultMatchers.status().isCreated());
//     }
//     // todo put and delete test
//     // @Test
//     // public void putUser() throws Exception {

//     //     int userId = 1;
//     //     String requestBody = "{ \"id\":\"" + userId +  "\"name\": \"updated1\", \"active\": null }";

//     //     MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/api/hospital/updatePatient/{id}", + userId)
//     //             .contentType(MediaType.APPLICATION_JSON_VALUE)
//     //             .accept(MediaType.APPLICATION_JSON)
//     //             .characterEncoding("UTF-8")
//     //             .content(requestBody);
//     //     this.mockMvc.perform(builder)
//     //             .andExpect(MockMvcResultMatchers.status()
//     //                     .isOk())
//     //             .andExpect(MockMvcResultMatchers.content()
//     //                     .string("Patient created successfully"))
//     //             .andDo(MockMvcResultHandlers.print());
//     // }


// }
