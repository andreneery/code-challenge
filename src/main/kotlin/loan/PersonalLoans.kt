package loan

import customer.Customer


class PersonalLoans: GetLoansOption {

    override fun verifyLoan(customer: Customer): Boolean {
        return true
    }

    override fun evaluate(customer: Customer): Loan {
        return Loan(LoanType.PERSONAL)
    }
}
