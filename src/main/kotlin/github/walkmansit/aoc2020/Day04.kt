package github.walkmansit.aoc2020

class Day04(val input: List<String>) : DayAoc<Int, Int> {

    data class Passport private constructor(val data: Map<String, String>) {

        private val validateMap = mapOf(
            "byr" to ::validateBirthYear,
            "iyr" to ::validateIssueYear,
            "eyr" to ::validateExpirationYear,
            "hgt" to ::validateHeight,
            "hcl" to ::validateHairColor,
            "ecl" to ::validateEyeColor,
            "pid" to ::validatePassportId
        )

        fun isValidKeysOnly(): Boolean {
            for ((k, _) in validateMap)
                if (!data.containsKey(k))
                    return false

            return true
        }

        fun isValid(): Boolean {

            for ((k, v) in validateMap)
                if (!data.containsKey(k) || !v.invoke(data[k]!!))
                    return false

            return true
        }

        private fun validateStringToNumbersByLenghtAndDiapason(
            value: String,
            lenght: Int,
            from: Int,
            to: Int
        ): Boolean {
            if (value.length == lenght) {
                val parsed = value.toIntOrNull()
                return parsed != null && parsed in from..to
            }

            return false
        }

        private fun validateBirthYear(value: String): Boolean {
            return validateStringToNumbersByLenghtAndDiapason(value, 4, 1920, 2002)
        }

        private fun validateIssueYear(value: String): Boolean {
            return validateStringToNumbersByLenghtAndDiapason(value, 4, 2010, 2020)
        }

        private fun validateExpirationYear(value: String): Boolean {
            return validateStringToNumbersByLenghtAndDiapason(value, 4, 2020, 2030)
        }

        private fun validateHeight(value: String): Boolean {
            val number = value.substring(0, value.length - 2).toIntOrNull()

            if (number != null) {
                val suffix = value.substring(value.length - 2, value.length)

                // If cm, the number must be at least 150 and at most 193.
                if (suffix == "cm") {
                    return number in 150..193
                }

                // If in, the number must be at least 59 and at most 76.
                if (suffix == "in") {
                    return number in 59..76
                }
            }

            return false
        }

        private fun validateHairColor(value: String): Boolean {
            return value.matches(color_regex)
        }

        private fun validateEyeColor(value: String): Boolean {
            return value.matches(eye_color_regex)
        }

        private fun validatePassportId(value: String): Boolean {
            return value.matches(passport_id_regex)
        }

        companion object {

            fun fromInput(passport: String): Passport {
                val data = mutableMapOf<String, String>()

                val pairs = passport.split(' ', '\n')
                pairs.forEach {
                    val keyValue = it.split(':')
                    data[keyValue[0]] = keyValue[1]
                }

                return Passport(data)
            }

            private val color_regex = Regex("^#[0-9a-f]{6}$")
            private val eye_color_regex = Regex("^(amb|blu|brn|gry|grn|hzl|oth)$")
            private val passport_id_regex = Regex("^[0-9]{9}$")
        }
    }

    override fun getResultPartOne(): Int {
        return input.map { Passport.fromInput(it) }.count { it.isValidKeysOnly() }
    }

    override fun getResultPartTwo(): Int {
        return input.map { Passport.fromInput(it) }.count { it.isValid() }
    }
}
