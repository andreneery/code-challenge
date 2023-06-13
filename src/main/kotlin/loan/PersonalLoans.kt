package loan

import customer.Customer


class PersonalLoans(): GetLoansOption {

    override fun verifyLoan(customer: Customer): Boolean {
        return customer.income < 3000.0
    }

    override fun evaluate(customer: Customer): Loan {
        val taxes = 3.0
        return Loan(LoanType.PERSONAL, taxes)
    }
}
