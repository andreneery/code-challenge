package loan

import customer.Customer

class LoanOptions(
    private val customer: Customer
) {

    fun evaluateLoanOptions(): List<Loan> {
        val loans = mutableListOf<Loan>()
        if (customer.income <= 3000) {
            loans.add(Loan(LoanType.PERSONAL, 4.0))
        } else if (customer.income < 5000) {
            loans.add(Loan(LoanType.PERSONAL, 4.0))
            if (customer.location == "SP" && customer.age < 30) {
                loans.add(Loan(LoanType.GUARANTEED, 3.0))
            }
        } else {
            loans.add(Loan(LoanType.PERSONAL, 4.0))
            loans.add(Loan(LoanType.GUARANTEED, 3.0))
            if (customer.location == "SP" && customer.age < 30) {
                loans.add(Loan(LoanType.CONSIGNMENT, 2.0))
            }
        }
        return loans
    }
}
