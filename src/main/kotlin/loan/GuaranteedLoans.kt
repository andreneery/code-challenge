package loan

import customer.Customer

class GuaranteedLoans : Loanable {

    override fun verifyLoan(customer: Customer): Boolean {
        val minIncome = 3000.0
        val maxIncome = 5000.0

        if (customer.income <= minIncome)
            return customer.age < 30
        else if (customer.income < maxIncome)
            return customer.location == "SP"
        else
            return (customer.age < 30 && customer.location == "SP")
    }
    override fun evaluate(customer: Customer): Loan {
        return Loan(LoanType.GUARANTEED)
    }
}
