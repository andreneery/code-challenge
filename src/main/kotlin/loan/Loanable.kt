package loan

import customer.Customer

interface Loanable {

    fun evaluate(customer: Customer): Loan

    fun verifyLoan(customer: Customer): Boolean {
        return true
    }
}
