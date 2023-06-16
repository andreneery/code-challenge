package loan

data class Loan(
    val type: LoanType,
    val taxes: Double
)
enum class LoanType {
    PERSONAL,
    GUARANTEED,
    PAYROLL
}

