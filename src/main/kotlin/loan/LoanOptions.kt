package loan

import customer.Customer

class LoanOptions(private val customer: Customer) {
    private val loanStrategies = listOf(
        PayrollLoans(),
        GuaranteedLoans(),
        PersonalLoans()
    )

    fun evaluateLoanOptions(): List<Loan> {
        var loans = mutableListOf<Loan>()
        for (strategy in loanStrategies) {
            if (strategy.verifyLoan(customer)) {
                val loan = strategy.evaluate(customer)
                loans.add(loan)
            }
        }
        return loans
    }
}
