package loan

import customer.Customer

class GuaranteedLoans() : GetLoansOption {

    override fun verifyLoan(customer: Customer): Boolean {
        return (customer.age < 30 && customer.location == "SP") || (customer.income > 3000.0 || customer.income < 5000.0)
    }
    override fun evaluate(customer: Customer): Loan {
        val taxes = 3.0
        return Loan(LoanType.GUARANTEED, taxes)
    }
}
