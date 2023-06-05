package loan

import customer.Customer

class LoanOptions(
    private val customer: Customer
) {
    private val getLoans = listOf(
        ConsignmentLoans(),
        GuaranteedLoans(),
        PersonalLoans()
    )

    fun evaluateLoanOptions(): List<Loan> {
        val loans = mutableListOf<Loan>()

        this.getLoans.forEach { loansModality: GetLoansOption ->
            loans.addAll(loansModality.evaluate(customer))
        }

        return loans
    }
}
