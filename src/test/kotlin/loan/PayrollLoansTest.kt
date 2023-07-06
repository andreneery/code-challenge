package loan

import customer.Customer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PayrollLoansTest {

    @Test
    fun `verifyLoan it returns true when customer income is more than 5000,00`() {
        val customer = buildCustomer(income = 6000.0)
        val subject = GuaranteedLoans()
        val result = subject.verifyLoan(customer)
        Assertions.assertTrue(result)
    }

    @Test
    fun `evaluate should return a Loan with type Payroll`() {
        val customer = buildCustomer(income = 6000.0)
        val expectedLoan = Loan(LoanType.GUARANTEED)

        val subject = GuaranteedLoans()
        val result = subject.evaluate(customer)

        assertEquals(expectedLoan, result)
    }

    private fun buildCustomer(income: Double) :Customer {
        return Customer(
            name = "Zézinho",
            cpf = "345.768.764-90",
            age = 45,
            location = "BA",
            income = income
        )
    }
}
