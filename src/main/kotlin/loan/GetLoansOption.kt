package loan

import customer.Customer

interface GetLoansOption {

    fun evaluate(customer: Customer): Loan

    fun verifyLoan(customer: Customer): Boolean {
        return true
    }
}
