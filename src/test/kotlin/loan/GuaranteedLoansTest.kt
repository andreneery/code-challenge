package loan

import customer.Customer
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GuaranteedLoansTest {

    @Test
    fun `verifyLoan it returns true when customer income is more than 5000,00`() {
        val customer = buildCustomer()
        val subject = GuaranteedLoans()
        val result = subject.verifyLoan(customer)
        Assertions.assertTrue(result)
    }

    @Test
    fun `evaluate should return a Loan with type Guaranteed`() {
        val customer = buildCustomer()
        val expectedLoan = Loan(LoanType.GUARANTEED)

        val subject = GuaranteedLoans()
        val result = subject.evaluate(customer)

        assertEquals(expectedLoan, result)
    }

    private fun buildCustomer() :Customer {
        return Customer(
            name = "Zézinho",
            cpf = "345.768.764-90",
            age = 45,
            location = "São Paulo",
            income = 6000.0
        )
    }
}
