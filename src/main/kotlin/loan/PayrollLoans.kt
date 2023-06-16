package loan

import customer.Customer

class PayrollLoans: GetLoansOption {

    override fun verifyLoan(customer: Customer): Boolean {
        return customer.income > 5000.0
    }

    override fun evaluate(customer: Customer): Loan {
        val taxes = 2.0
        return Loan(LoanType.PAYROLL, taxes)
    }
}
