package loan

import customer.Customer

class PersonalLoans(): GetLoansOption {

    override fun evaluate(customer: Customer): List<Loan> {
        return listOf(Loan(LoanType.PERSONAL, 4.0))
    }
}
