import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    // Cria um objeto mock para a interface PaymentProcessor
    @Mock
    private PaymentProcessor paymentProcessor;

    // Injeta o mock no OrderService
    @InjectMocks
    private OrderService orderService;

    @Test
    void should_confirm_order_when_payment_is_approved() {
        // Cenário de Teste: Pagamento Aprovado
        // Configura o mock para retornar 'true' quando o método processPayment for chamado com qualquer valor
        when(paymentProcessor.processPayment(100.0)).thenReturn(true);

        // Executa o método a ser testado
        boolean isOrderConfirmed = orderService.processOrder(100.0);

        // Verifica a saída: o pedido deve ser confirmado
        assertTrue(isOrderConfirmed);
    }

    @Test
    void should_reject_order_when_payment_is_denied() {
        // Cenário de Teste: Pagamento Recusado
        // Configura o mock para retornar 'false' quando o método processPayment for chamado com qualquer valor
        when(paymentProcessor.processPayment(50.0)).thenReturn(false);

        // Executa o método a ser testado
        boolean isOrderConfirmed = orderService.processOrder(50.0);

        // Verifica a saída: o pedido deve ser recusado
        assertFalse(isOrderConfirmed);
    }
}