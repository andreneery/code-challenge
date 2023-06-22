package loan

import customer.Customer
import io.mockk.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonalLoansTest() {
    @Test
    fun `verifyLoan should always return true`() {
        val customer = mockk<Customer>()
        val subject = PersonalLoans()
        val result = subject.verifyLoan(customer)
        assertTrue(result)
    }

    @Test
    fun `evaluate should return a Loan with type PERSONAL and taxes 4`() {
        val customer = mockk<Customer>()
        val expectedLoan = Loan(LoanType.PERSONAL)

        val subject = PersonalLoans()
        val result = subject.evaluate(customer)

        assertEquals(expectedLoan, result)
    }
}
