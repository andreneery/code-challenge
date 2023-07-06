package loan

data class Loan(
    val type: LoanType,
    val taxes: Double = getTaxes(type)
)
enum class LoanType {
    PERSONAL,
    GUARANTEED,
    PAYROLL
}

fun getTaxes(type: LoanType): Double {
    return when (type) {
        LoanType.PERSONAL -> 4.0
        LoanType.GUARANTEED -> 3.0
        LoanType.PAYROLL -> 2.0
    }
}
