package loan

import customer.Customer
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LoanOptionsTest {

    private lateinit var customer: Customer
    private lateinit var loanOptions: LoanOptions

    @BeforeEach
    fun setUp() {
        customer = mockk()
        loanOptions = LoanOptions(customer)
    }

    @Test
    fun `retorna emprestimo pessoal quando o cliente tiver renda menor 3000`() {
        every { customer.income } returns 3000.0
        every { customer.location } returns "MG"
        every { customer.age } returns 55
        val expected = listOf(Loan(LoanType.PERSONAL, 4.0))

        val result = loanOptions.evaluateLoanOptions()

        assertEquals(expected = expected, actual = result)
    }

    @Test
    fun `retorna emprestimo pessoal e garantia, quando o cliente tiver renda de até  3000 e residir em SP `() {
        every { customer.income } returns 3000.0
        every { customer.location } returns "SP"
        every { customer.age } returns 25
        val expected = listOf(
            Loan(LoanType.PERSONAL, 4.0),
            Loan(LoanType.GUARANTEED, 3.0)
        )

        val result = loanOptions.evaluateLoanOptions()

        assertEquals(expected = expected, actual = result)
    }

    @Test
    fun `Irá retornar emprestimo pessoal e garantia, quando o cliente tiver renda entre 3000 e 5000 e morar em SP`() {
        every { customer.income } returns 4000.0
        every { customer.location } returns "SP"
        every { customer.age } returns 55
        val expect = listOf(
            Loan(LoanType.PERSONAL, 4.0),
            Loan(LoanType.GUARANTEED, 3.0)
        )

        val result = loanOptions.evaluateLoanOptions()

        assertEquals(expected = expect, actual = result)
    }

    @Test
    fun `deve retorna emprestimo pessoal e consignado, quando o cliente tiver renda maior que 5000`() {
        every { customer.income } returns 6000.0
        every { customer.location } returns "BA"
        every { customer.age } returns 45
        val expect = listOf(
            Loan(LoanType.PERSONAL, 4.0),
            Loan(LoanType.CONSIGNMENT, 2.0)
        )

        val result = loanOptions.evaluateLoanOptions()

        assertEquals(expected = expect, actual = result)
    }

    @Test
    fun `deve retornar emprestimo pessoal, com garantia e consignado, quando o cliente tiver renda maior que 5000 e menos de 30 anos`() {
        every { customer.income } returns 6000.0
        every { customer.location } returns "BA"
        every { customer.age } returns 29
        val expect = listOf(
            Loan(LoanType.PERSONAL, 4.0),
            Loan(LoanType.CONSIGNMENT, 2.0),
            Loan(LoanType.GUARANTEED, 3.0)
        )

        val result = loanOptions.evaluateLoanOptions()

        assertEquals(expected = expect, actual = result)
    }
}
