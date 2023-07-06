package loan

import customer.Customer

class LoanOptions(
    private val customer: Customer
) {
    private val getLoans = listOf(
        PayrollLoans(),
        GuaranteedLoans(),
        PersonalLoans()
    )

    fun evaluateLoanOptions(): List<Loan> {
        val loans = mutableListOf<Loan>()

        this.getLoans.forEach { loansModality: Loanable ->
            loans.addAll(listOf(loansModality.evaluate(customer)))
        }

        return loans
    }
}
