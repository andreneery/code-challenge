package loan

import customer.Customer

interface GetLoansOption {

    fun evaluate(customer: Customer): List<Loan>
}
