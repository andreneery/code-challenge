package loan

import customer.Customer
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
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
    fun `retorna as modalidades de emprestimos de acordo com o cliente`() {
        val customer = mockk<Customer>()
        every { customer.location } returns "SP"
        every { customer.income } returns 2000.0

        val subject = LoanOptions(customer)
        val result = subject.evaluateLoanOptions()

        assertEquals(3, result.size)
        assertEquals(LoanType.PAYROLL, result[0].type)
        assertEquals(LoanType.GUARANTEED, result[1].type)
        assertEquals(LoanType.PERSONAL, result[2].type)
    }
}
