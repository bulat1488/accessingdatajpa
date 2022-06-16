
import com.example.accessingdatajpa.service.ClickOrdersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


class ClickOrdersServiceJdbcTest {

    @Mock
    private ClickOrdersService clickOrdersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    boolean sessionKey;

    @Test
    void deleteOrdersTest() {

        var userId = 1;

        Mockito.when(clickOrdersService.deleteOrders(userId))
                .thenReturn(sessionKey);

        Assertions.assertNotNull(sessionKey);
    }
}

