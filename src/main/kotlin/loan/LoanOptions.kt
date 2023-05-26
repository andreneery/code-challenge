package loan

import customer.Customer

class LoanOptions(
    private val customer: Customer
) {

    fun evaluateLoanOptions(): List<Loan> {
        val loans = mutableListOf<Loan>()
        val personal = Loan(LoanType.PERSONAL, 4.0)
        val guaranteed = Loan(LoanType.GUARANTEED, 3.0)
        val consignment = Loan(LoanType.CONSIGNMENT, 2.0)

        if (customer.income <= 3000) {
            loans.add(personal)
            if (customer.age < 30 && customer.location == "SP") {
                loans.add(guaranteed)
            }
        } else if (customer.income < 5000) {
            loans.add(personal)
            if (customer.location == "SP") {
                loans.add(guaranteed)
            }
        } else {
            loans.add(personal)
            loans.add(consignment)
            if (customer.age < 30) {
                loans.add(guaranteed.copy(taxes = 2.0))
            }
        }

        return loans
    }
}
