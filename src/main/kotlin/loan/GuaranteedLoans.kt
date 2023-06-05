package loan

import customer.Customer

class GuaranteedLoans() : GetLoansOption {
    override fun evaluate(customer: Customer): List<Loan> {
        return listOf(Loan(LoanType.GUARANTEED, 3.0))
    }
}
