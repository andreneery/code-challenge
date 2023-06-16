package loan

import customer.Customer

class GuaranteedLoans() : GetLoansOption {

    override fun verifyLoan(customer: Customer): Boolean {
        val minIncome = 3000.0
        val maxIncome = 5000.0
        return (customer.location == "SP") || (customer.income > minIncome || customer.income < maxIncome)
    }
    override fun evaluate(customer: Customer): Loan {
        val taxes = 3.0
        return Loan(LoanType.GUARANTEED, taxes)
    }
}
