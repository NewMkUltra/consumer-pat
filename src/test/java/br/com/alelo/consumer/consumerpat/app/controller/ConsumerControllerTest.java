//package br.com.alelo.consumer.consumerpat.app.controller;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ConsumerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private ConsumerService consumerService;
//
//    @InjectMocks
//    private ConsumerController consumerController;
//
//    private ConsumerDTO consumerDTO;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(consumerController).build();
//
//        // Configuração de um ConsumerDTO para o teste
//        consumerDTO = new ConsumerDTO();
//        consumerDTO.setId(1);
//        consumerDTO.setFoodCardNumber(123456);
//        // Configure outros campos conforme necessário
//    }
//
//    @Test
//    void testListAllConsumers() throws Exception {
//        // Configuração do comportamento do mock
//        when(consumerService.getAllConsumers()).thenReturn(Arrays.asList(consumerDTO));
//
//        // Execução da requisição e verificação do resultado
//        mockMvc.perform(get("/consumer/consumerList"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].foodCardNumber").value(123456));
//    }
//}

