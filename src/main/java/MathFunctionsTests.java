import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathFunctionsTests {

    // Propriedade 1: O dobro de um número é sempre maior ou igual ao próprio número
    @Property
    void double_of_a_number_is_always_greater_or_equal_to_itself(@ForAll int number) {
        int result = MathFunctions.multiplyByTwo(number);
        assertTrue(result >= number);
    }

    // Propriedade 2: Se um número for par, seu dobro também será par
    @Property
    void if_a_number_is_even_its_double_is_also_even(@ForAll("evenNumbers") int number) {
        int result = MathFunctions.multiplyByTwo(number);
        assertTrue(result % 2 == 0);
    }

    // Gerador de dados customizado para números pares
    @Provide
    Arbitrary<Integer> evenNumbers() {
        return Arbitraries.integers().filter(i -> i % 2 == 0);
    }
}