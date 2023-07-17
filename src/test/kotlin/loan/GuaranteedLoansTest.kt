package loan

import customer.Customer
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GuaranteedLoansTest {

    @Test
    fun `verifyLoan it returns true when customer income is less 5000,00`() {
        val location = "MG"
        val income = 4000.00
        val customer = buildCustomer(location, income)
        val subject = GuaranteedLoans()
        val result = subject.verifyLoan(customer)
        Assertions.assertTrue(result)
    }

    @Test
    fun `verifyLoan it returns true when customer location is SP and income is more than 5000,00`() {
        val location = "SP"
        val income = 4000.00
        val customer = buildCustomer(location, income)
        val subject = GuaranteedLoans()
        val result = subject.verifyLoan(customer)
        Assertions.assertTrue(result)
    }

    @Test
    fun `verifyLoan it returns false when customer income is more than 5000,00 and location is not SP`() {
        val location = "RJ"
        val income = 7000.00
        val customer = buildCustomer(location, income)
        val subject = GuaranteedLoans()
        val result = subject.verifyLoan(customer)
        Assertions.assertFalse(result)
    }

    @Test
    fun `evaluate should return a Loan with type Guaranteed when localtion is SP`() {
        val customer = buildCustomer(location = "SP", income = 7000.0)
        val expectedLoan = Loan(LoanType.GUARANTEED)

        val subject = GuaranteedLoans()
        val result = subject.evaluate(customer)

        assertEquals(expectedLoan, result)
    }

    @Test
    fun `evaluate should return a Loan with type Guaranteed when localtion is not SP and income is less 5000,0`() {
        val customer = buildCustomer(location = "RS", income = 4500.0)
        val expectedLoan = Loan(LoanType.GUARANTEED)

        val subject = GuaranteedLoans()
        val result = subject.evaluate(customer)

        assertEquals(expectedLoan, result)
    }

    private fun buildCustomer(location: String, income: Double) :Customer {
        return Customer(
            name = "Zézinho",
            cpf = "345.768.764-90",
            age = 45,
            location = location,
            income = income
        )
    }
}
