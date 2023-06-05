package loan

import customer.Customer

class ConsignmentLoans(): GetLoansOption {

    override fun evaluate(customer: Customer): List<Loan> {
        return listOf(Loan(LoanType.CONSIGNMENT, 2.0))
    }
}
