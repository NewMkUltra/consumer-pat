package br.com.alelo.consumer.consumerpat.infra;

import br.com.alelo.consumer.consumerpat.domain.entity.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ConsumerRepositoryTest {

    @Autowired
    private ConsumerRepository consumerRepository;

    @BeforeEach
    void setUp() {
        consumerRepository.deleteAll();
        Consumer consumer1 = new Consumer();
        consumer1.setId(1);
        consumer1.setFoodCardNumber(123456);
        consumer1.setFoodCardBalance(100.0);
        consumer1.setFuelCardNumber(654321);
        consumer1.setFuelCardBalance(50.0);
        consumer1.setDrugstoreCardBalance(75.0);
        consumerRepository.save(consumer1);

        Consumer consumer2 = new Consumer();
        consumer2.setId(2);
        consumer2.setFoodCardNumber(234567);
        consumer2.setFoodCardBalance(200.0);
        consumer2.setFuelCardNumber(765432);
        consumer2.setFuelCardBalance(100.0);
        consumer2.setDrugstoreCardBalance(150.0);
        consumerRepository.save(consumer2);
    }


    @Test
    void testGetAllConsumersList() {
        List<Consumer> consumers = consumerRepository.findAll();
        assertNotNull(consumers);
        assertEquals(2, consumers.size());
    }

    @Test
    void testFindByDrugstoreNumber() {
        Consumer consumer = consumerRepository.findByDrugstoreNumber(222333);
        assertNull(consumer);
    }
}