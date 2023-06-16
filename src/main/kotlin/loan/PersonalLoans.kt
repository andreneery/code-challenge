package loan

import customer.Customer


class PersonalLoans: GetLoansOption {

    override fun verifyLoan(customer: Customer): Boolean {
        return true
    }

    override fun evaluate(customer: Customer): Loan {
        val taxes = 4.0
        return Loan(LoanType.PERSONAL, taxes)
    }
}
