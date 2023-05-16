package loan

import customer.Customer

class LoanOptions(
    private val customer: Customer
) {

    fun evaluateLoanOptions(): List<Loan> {
        val loans = mutableListOf<Loan>()

        if (customer.income <= 3000) {
            loans.add(
                Loan(
                    type = LoanType.PERSONAL,
                    taxes = 4.0
                )
            )
            if (customer.age < 30 && customer.location == "SP") {
                loans.add(
                    Loan(
                        type = LoanType.GUARANTEED,
                        taxes = 3.0
                    )
                )
            }
        } else if (customer.income < 5000) {
            loans.add(
                Loan(
                    type = LoanType.PERSONAL, taxes = 4.0
                )
            )
            if (customer.location == "SP") {
                loans.add(
                    Loan(
                        type = LoanType.GUARANTEED,
                        taxes = 3.0
                    )
                )
            }
        } else {
            loans.add(
                Loan(
                    type = LoanType.PERSONAL,
                    taxes = 4.0
                )
            )
            loans.add(
                Loan(
                    type = LoanType.CONSIGNMENT,
                    taxes = 2.0
                )
            )
            if (customer.age < 30) {
                 loans.add(Loan(
                    type = LoanType.GUARANTEED,
                    taxes = 2.0))
            }
        }
        return loans
    }
}
