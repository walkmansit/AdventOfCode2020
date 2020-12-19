package main.days

object Day19 {

    private val input = """
        60: 117 7 | 89 13
        38: 7 45 | 13 32
        77: 7 51 | 13 48
        23: 72 13 | 27 7
        61: 105 7 | 7 13
        103: 7 121 | 13 112
        76: 88 13 | 124 7
        28: 61 13 | 27 7
        24: 7 17 | 13 33
        115: 128 13 | 126 7
        82: 13 73 | 7 64
        107: 130 13 | 1 7
        49: 59 7 | 100 13
        131: 86 7 | 87 13
        53: 7 105 | 13 13
        27: 105 105
        21: 7 13 | 13 7
        84: 7 26 | 13 32
        62: 90 13 | 94 7
        18: 93 13
        65: 75 13 | 40 7
        39: 13 93 | 7 95
        6: 7 38 | 13 25
        64: 99 7
        73: 7 93 | 13 32
        101: 13 81 | 7 19
        116: 13 39 | 7 122
        55: 13 32 | 7 53
        48: 13 91 | 7 61
        93: 13 13
        108: 7 7 | 13 105
        94: 13 91 | 7 32
        118: 13 79 | 7 57
        41: 7 21 | 13 32
        113: 7 61 | 13 26
        74: 7 53 | 13 93
        52: 55 13 | 70 7
        5: 108 13 | 27 7
        30: 14 7 | 50 13
        7: "a"
        50: 13 23 | 7 111
        32: 13 7 | 13 13
        92: 114 13 | 125 7
        89: 108 7 | 72 13
        9: 7 28 | 13 127
        35: 7 131 | 13 47
        86: 26 13 | 108 7
        67: 7 44 | 13 69
        44: 7 80 | 13 22
        46: 7 67 | 13 35
        111: 32 7 | 72 13
        11: 42 31
        112: 13 91 | 7 2
        99: 7 7
        81: 72 7 | 26 13
        123: 37 13 | 20 7
        45: 7 13 | 13 13
        56: 119 13 | 112 7
        63: 13 61 | 7 95
        57: 7 9 | 13 83
        3: 13 106 | 7 43
        97: 84 13 | 73 7
        85: 13 93 | 7 108
        117: 7 53 | 13 21
        47: 16 7 | 54 13
        71: 129 7 | 63 13
        95: 13 13 | 7 7
        37: 26 13
        2: 7 13 | 13 105
        72: 7 13 | 7 7
        43: 85 13 | 16 7
        4: 130 7 | 25 13
        69: 7 22 | 13 80
        68: 93 7 | 32 13
        22: 45 13 | 53 7
        78: 13 2 | 7 27
        14: 28 13 | 119 7
        17: 13 60 | 7 6
        129: 91 7 | 32 13
        87: 26 7
        79: 58 7 | 107 13
        130: 13 72 | 7 91
        90: 7 45 | 13 2
        8: 42
        114: 13 30 | 7 34
        66: 61 7 | 93 13
        128: 7 108 | 13 72
        31: 13 36 | 7 15
        127: 13 108 | 7 32
        110: 73 13 | 29 7
        58: 7 113 | 13 48
        120: 7 56 | 13 97
        19: 13 53 | 7 2
        83: 13 78 | 7 74
        34: 7 110 | 13 4
        75: 7 102 | 13 52
        25: 13 72 | 7 95
        16: 7 72 | 13 21
        100: 13 82 | 7 116
        42: 13 92 | 7 10
        119: 13 2 | 7 95
        88: 71 13 | 101 7
        126: 13 72 | 7 61
        33: 96 13 | 123 7
        1: 61 7 | 53 13
        96: 55 7 | 41 13
        102: 7 104 | 13 87
        98: 91 13 | 91 7
        104: 26 13 | 32 7
        51: 7 95 | 13 26
        125: 13 120 | 7 3
        91: 13 7
        13: "b"
        10: 65 7 | 46 13
        105: 13 | 7
        59: 13 115 | 7 77
        106: 5 13 | 66 7
        80: 72 13 | 53 7
        20: 93 7 | 61 13
        15: 118 7 | 76 13
        70: 91 13 | 93 7
        29: 13 26 | 7 21
        122: 7 26 | 13 72
        124: 12 13 | 109 7
        26: 7 13
        121: 91 7
        36: 13 49 | 7 24
        12: 68 13 | 98 7
        109: 18 7 | 23 13
        54: 13 108 | 7 61
        0: 8 11
        40: 7 103 | 13 62

        abbabbaabaaaabbaabaabbbbabaaaabb
        abbababaabbbbbbaababaaababaabbbb
        bbabbbabbabbaaaaaaabbbbbaabaababbbababbaaabbabaa
        abaabbaaabbbbabbbabbaaaabbaababb
        bbaaaaabbbbbbaabbabbbabaaabaabba
        bababaabbaabbbbbbbabbbaa
        abbababbababbaabbababababbbbbaaababaaaaaabababaa
        abbbaabbabbbabbabbabbaabaabbaaaa
        abbaaaabbbbabbaaaabababb
        babbaaabaababbababbbbbaaaababbaaababbbaabbbaaaba
        abbbabbbabbbaaaaaabababababbbbaabaaaabbbbabbabbabaaabaaaabababba
        aababbaaabbaabbbaababbbbaabbbabaaaaababb
        aaaaababaababbabbbaabbbaaabaabbabbbaaaaa
        baabaababababbabaabbbbbaabbabaaabbaaaabaaaababbbbabaabbb
        bbaaaaabbababaaaabaaabbabbabbabbbaaabaabbabaabab
        bbbbbabaaaaabbbabbaaaabb
        bbbaaabbabbabbaaaababaab
        bbaaabbbbbbabbababaaaaaa
        abaabbabbbbbbbbabbabbbbabbaaaabaaaaababa
        bbababbaabaaaaabbbaabbaabbabaabbbbbbbbbabbabbbaaabaaaabb
        bbabbbbbbbabbbbbbbaaaaaa
        aabbaabbbaaaaabaabbbbbaabaabbabbaabababb
        bbabbabbaababbabababbbbababbbabaababbbbbabbabbbbbaababba
        bababaabbabbbbaaabbabbab
        bbbbaaabbbbbbabbbbbbbbbabbabbabaabbabbaaabaabaab
        bbabbaabababbaaabaabaaab
        abaaaaaababbabaabaabbbaa
        aabaabaabaaabaabbbabbaaabbbabbbbbabaababbabbbbbb
        bbabaabbbbbbbabababbbababaaababaaababbabbaabbaabbabaabab
        abbbbbaababababaabbaabbbaabbababbbbaaaaa
        bababbbbbbbaabbabbbbbbbaabaaabaaaabbaaba
        babaaababbaaaaabbbaaaaabaaababababbabbbb
        baaabbbbbabaaabbaaabaabababbabbaaaabaaaabbaabababababbaa
        baabbaaababbaaabbabbaaabbbaaaabaabaaaaaa
        bbbabbaabbaabbababbaaaabbbbabbbabbaabaab
        aababaaaabaabbababbaaabbbaababbaabbbbaaa
        baaaabaabbaabbbaaaababbbaaaaabaabbbaaaba
        abbbaabababbbbbabbabbabaababbbba
        babaabbabbabbaabaaababbbaabbbbababbbabbbaabbbbaabbaabaab
        aabaabaaabbababaabbaabbbbaabbbaaabbabbbb
        bbaabbababbaaabbabbbaaaaabaaaaabbbabbbbababaababbaaababb
        baaaaaabaabaabbaabbbbabbaabbabbbaabaaaabababbaaaaaabaaab
        babbaaaaaaabaaabbbaabbabababbaba
        aaaabbabbbbabbaabbaabbab
        aababaaababbababaabbbbabbbabaaaababbbbab
        abbaaaabaaabaaaaaabaaaaa
        aaabaaabaababbbbaabababb
        aabbbaaabababbbbabbaaabbaabaaaabbbaababa
        babaaababbabaaababbabaabbabbaaaa
        bbabbabbbbbbbabbbbabaaab
        bbabbbabaababbabababbaabaaabaaabaabaaaba
        aaabaaababbababaabaaabbababbbbab
        abbbababbbabbbabbbbaabbbababbbaaabbabbbbabbaaaaa
        abbaababbbbaabbbaabbaaaa
        bbabbaabbaabbbbbaabaabba
        abbaabbbaabbbaaababaabbabaaabbbbbabaaaaaaabbbbbb
        bbabbbbaaabbaaaabbbaaaabaaaaaaaabbbbaaaa
        babaabbababbaabbabbbbabbbabbbabaabbaababbababbbbabbbaaab
        babbbbaaabbbbbbbabbabbab
        babababababbaababaabaaaa
        bbabababbababaaaaaabaabb
        aaabaaaabbbbbabbaabbaaaa
        abbbabaabbabbbbaabaaaaba
        aaabaaabaaaabbababababaa
        bbabbaababbbababbbababaa
        aaabaaabbabababaabaababbaababababaababbbabbabbbabababbaa
        bbbaabbbabbbbbbbaaabaabb
        abaabbaabbbbbaaaaaaaaabbbbbaaaabaaababaa
        bbbabbbbaababaaabaabbaab
        aababababaabbabbbbbabababbbabbba
        bbbaabbbbaaaaaaaabaabbbabbaaabbbabbaabbabbbabbbababbbbab
        aaaaaababbaaaaaababbaabb
        bbbabbbbbbbaabbbbbaaaaabbaababbabbabaaab
        abbabaabaababbababaabbbabbababbaaabbaabaaabbbbbbbbababaabaaaabbb
        aabaabbaabbabbbabbaaaabbababaaba
        bababaaabaabababbaabababbaaabaabbbbbbaaaabaabaabbaaaabbbabbbaaab
        aababbbbbabbaabbbaabbaab
        bbaabbbabaaaabaaaabbabbbbbaabbbbababaabbaabaabbaabababba
        abbbaaaaabaabbabbbabaabbabaabbab
        bbaaaaababaaaaabbbbaaaab
        babbaaaabbaaabbbaabababbabbaabbbbbbaaaaaaaabbaaabaababbaaabaabaabbaaaaabaabaabba
        babaaabaabbbabbabbbbbbbabbbbbbab
        abaababbbbaaabababbaaaabbabaabbaaaabbbba
        babababababaaababbbbbababbbabbabaaabbbbbaaabaaaaabbabaaa
        bbaaaaabbbbaababbbabbaabbbaababa
        babababaabbbbbbabbabaaaa
        ababaaaaababbbaaabbbaababbababaa
        aaaabbbaaabbbaaaabbbbbbabaaaaababaaababb
        abbbababbbaaaaabbbbbbaaababaaaaabaaaababbaababbb
        aaaababbbaaabaaabbbbaaba
        bbbaabababbbabbabaaaaababbaabbbbaababbbbabbaabaaabbaabaabaaaabba
        abbbbbbbbbbaaaaabaabaaaabababbababababab
        babbbbbaabbbaabbabbbbbbaaabaababaaabaaaabbbaababaaaaaababbabaaba
        babbabbbbbaaabbbbbbabbabbbaaaaaa
        aababbaaaaaaababbbabbabaaababbaa
        babbaababbbbbabaaaaaaaababaaabbabbabbbbb
        bbbbbaaabbbabbababaaabbaaabbbaaaabaabaaaaaaababa
        aaaaabbbbbaaaaababbbbbaabbaabbabbbbaaaaaaaababbabaaababbabaaabab
        bbbababbaabaaaabbbaabbbababbaaabababbbabbbbbabbaabaaabbb
        bbabbaaabaaababababaaabbbbaaaaabbbbbaabbababbbbbabaabaab
        aabaababaababbaaabaaaaababaabbaaaabbbbbb
        babbbababbbabaabbaaaabba
        bbababbabbbababbababaaaabaaaaababaabababbbbbabbabababbba
        babbbbaabaaabaabbbaaaaba
        baaabaabbbbaabbbabaaabab
        abbaaabbbbbabbbbbababbba
        abbaaaabaaababbbabbbbbbbaababaaaaaaabaab
        baaaababbbbabaabbbabbaabbbaabbabbabaabbb
        abbabbaabbbaaabbaababaaabbbbbabbbabaaaaaaabaaaaa
        aabbbaaabbbbbbaabbababbaabbabaabbbaaaabb
        aaabaaaaaaabaaaaaabbbaab
        abbabbaaaabbabababaabbaabbbbababababbbab
        aaabaababbbbbbaaabbbaabaabbabaaababbbbab
        abbababbbbaaabbbaabbbbba
        bbababbaababaaaabbbbaaabbbabbababbbaabaa
        bbabaaaabbbbaaaabbbbabaa
        abaabbaababbbbbaabbbabaaababbbaaababaabb
        abbabaabaababbbaaabbbabbabbbababbbbbaabb
        bbbababbabbababababbbaaa
        baaaabaaabbbbabababaababbabbabba
        babbababbaaabaabbaaaabaaabbbaaaabbaababbabbabbabbbbabaaa
        ababbbaababaabbabbabbababbbbbaaabaabbbbaaababaababababaababbbaab
        aabaaaabaabbababaababbaaabababaaaaabbaaa
        abbbbbbabbabbabbababbbab
        babbaaaabbbbbabbbabbababaaaabbaa
        bbbbbbaaaabaabbbbaaaabba
        ababbbbbabbabaabbabababaaabaaababaabbbbbbbbabbaaabaaaabb
        aaaabbabbaabbabbaababaaaaaabbaaa
        abbabbbbbaabbaabababbaaa
        abaababbaabaaaabababbbbb
        baaabababbaabaaaaababaaaababaaba
        aabaabababbbbbaaaabababb
        aabaabaaaaabbbbbbabaaaaaabbaabbbaaaababaaabababb
        bbbbbabbabbbabaaababbaaaaaabbaaaaaabbbba
        bbaaaaababaabbbaabbaabbbabbbabbb
        abaaaaabbabbaababbbaabbaaaaaabbaabbbbaaa
        bbaabbaaabbbababbabbbaaa
        abaabaaaababbbaabbbbbaaaabbbbbbaabbbbbaabbabbaaa
        bbbbbbbaababaabbbabbbbbaaaababbbbbbbbabbabbabbbbaabbbbbb
        bbaabbbaabaababbaaaaabba
        abbaababbbaabbabbbbaabaaabbbbbabaaaabbaabaababbb
        baabbbabaababbbaaababbabbabbbbaaaabbaaaabaaabbabbabbabbabaaabaaabbababbb
        bbbabaabbabbbbaababbbbaaaabaaabb
        bbabbaabbabbababbbbabbaaaaaaaabbaabaaaaaaabbbbba
        bbbbbaabbabbaaaababbaaaaabbbbabbbbabaaba
        baaababbbabaababbbbaabbbababbaab
        baabbbbababaaaaaabababaa
        abaabbbabbaabbbbabaabbbabbaaababbbbbabaa
        bbbbbbbaabaabbbaababbbab
        bbaaaaabbaabababbaaaaaaabababbbababbbbab
        aabbaabbbbabbabaababbbab
        babbabbaaabbbbababbbbbaabbaaabaabbbbabba
        bbabbabaaabbaaabababbbbabaababbb
        ababbbbabbbbbaabbbbabbbbaabbbabbbabbbbab
        bbaabaaababbbabaaabbabaa
        abbaaabbbbaabbbbabbababaabbbabbbaaaababa
        bbbabbabbbbbababaaabbbba
        aabbababbaaaababbbbababbbababaabbaaaaaaababbabaaababbbabaabbbbbb
        aaabaaababaabbbabaaaababbababbaa
        bbbaaabbabaabbaabababaabaaabaabb
        aabbbaaaaaabbabbbbaaabbaaaababaaaabbbaaa
        bbbaabbabbabbaaababbbbba
        bbabababbbababaababaaaababaaaaabaaabbbbbbabbbabbabbabbab
        aabaababbbbbbbbabbabbabaaababaaabaaaaababaaaaabbbaabbaba
        aaababbbabbabaaaabaabaabbbbbbbbbaaaaabababaaaabaaabbbbbaabbbbbabbabaaaaa
        baaaabaababbaaabbabaaabbabbaabba
        abbbbabbbbbbbabbbaabbbab
        bbbbbabbbbbbbabbbaabbbbbbbbbbbbabaabbabaaaaaaaaa
        bbabaabbaabbbbabbabbaabaabaaaaab
        bbabaabbbbbbbababbbbbbbb
        bbabbaaababbabbaaaabaababbabababbaaabaabaabaabbabbaaaaababbbabaaabbbabbbabbaabaa
        abbbabbabbbbbabaaaabababaabababaaabaababbaabbbbbbaaabaaa
        baaaabaabbbaaabbabbaaaab
        bababbaabbbabaaaabbaabaabaaabbbbabaaaaabbbaaabbb
        bbbabaabbbaaabaabbabababaabbabababbaaaaabbbbabbabaabbaba
        abaaaabbbabbbabaaababbababbbbaabbaabbbbbbbbabbba
        bbabbabaabbbbbbaabaaabbabaabbbbbbbaababaaabaabbaababbabb
        baaabbbbbabaaabaaaaaababbaaabbbabaabbababaaabaaabaabbaab
        abbbbbaabbbbbbbaaabbbbabaabaabba
        aaabbbabbabbbabaaaaabaab
        bbababbabaabbabbbbaaaababbbbbabbababbaba
        bbabababaabaabaaaabaabaaaababbbabbabaaaa
        bbaaaabbbabbabbbbabbaaaaaabbbbbaabbaaaabbaaaaabb
        bbbbbbbabaaaaaaabbbaaababbabbbaaaaaaaaabababbbbabbabbaaaababbbbabbaabbba
        bbbaaabbabbababbbbaaaabababaabaa
        abaaaaabbaaaababbbaaaaababbbaaab
        abaabbaaabbaaabbbbbabbaababbbbabbbbaaaaa
        bababaaabbbbababbbabbaab
        babbabbabaabababbabbaabbaaaababa
        abbbbbbbaaabaaabaaabbbabbabbaababbbbababbabaabbabaabbaab
        bbbbaabbbaaaabaababaaabaaaaabbbaabababbbbaaabaaa
        abbbaabbabaaabbaabbaabbbabbabbbbbabbbbabbabbbaababbaaaba
        abaabbabbaabbbaaabbbaababaaabaababbaabababababbaabbaaaaaabbabbaababbabaababababbaaaabbab
        ababbbaaabaaabbaaabbbaaaaababbbaabbabbba
        bbbbbabbbaabbbbbaaabaaaaaabaabaabaaabbbbaaabbbbaabbbbaba
        baaaabaaabbbbbbbaababaab
        aaabababbaaababababbbaab
        abbbabbaaabaabaaaabaabbbbbbabaababaaabbbaaabbaaa
        aaabbabbaababaaaaabaabbbbbababaaabaaaabaabbbbbbb
        bababaabbaabaaaaabaabaaa
        baababaabbaaabababaaaaaaabbabbbbbabbbaab
        bbaabbaabbabbababaabbabbbbabbabbabbbbabaaaaabbaa
        bbaabbbabbaaabbbaabbaaababbbbbbababbaaabbbbaaaaabaabaaabaaaaaababaaabbab
        aaababbaabaabbbabbbaaaaaababbbaabaabbaba
        ababbbbaaaabbbababbbbbaababbbababaabbbbbbaabbabbbbabaaabbaaaabbabbbaabaabbbababababbbbbb
        bbbaaabbabaabbbabbabbbbb
        abaabbababaabbababaabbabaaaaaabbaababaabbbabaaab
        bbbabbaaabbbaababaaaabaabbaabaaaaabbbbaaaaaabaaa
        aababaaaaaabbbbbabbbbaabbbaababababaaaab
        bbbababbaabbaabbabbaabbbbabbabbbaababbbaaabbbbbabbbbaaba
        aabbabbbbaaaaaaaabbbbabbaabaababbaaabababbbabbba
        abaababbabaaaaababababba
        bbaabbaabaabababbaabaabb
        babbabababbbbbbabbbbbbbb
        babbabababbbbabbaabbbbaa
        bbbaababbaaaabaaaaaabbbb
        bbabbbababbaaabbbaaaabba
        abaaaaabbbabbababbbbabbb
        bbabaaaaaababbaabbbbbabbaaabaabbbaababbaabaaaaababaaaaaaababbabbbbbbbabaababbaab
        aababbabbabaaabbabbababbabbaabba
        aaabaaabbaaabababababababbaaaababbaabaab
        abbbbaabaaabbababbbababbaaabaabb
        bbaaabbbbbabbbabaabbbaba
        abbbbbbababbabababbbbbaabbbaabbbabbbaabb
        aaaabbabbbaaababbaababaaaaaaaaababababababbbbbab
        baaabbabbbabbaabbbaabababbbababbaaaabaabbbbaaabbbabbabab
        abbbbbaabbbaabababbaaabbababbbabaaabbabb
        baaabbbababbababbbbbaabbaaaaaabbabbabbba
        bbababbbaabbbbaababbbaab
        babaaaaaabbababbbabababb
        bababbbbbbaabbbaaabbbbabbabaaababbaaabbbabbbbbbaabababba
        babbbababbaaababbbbbbaaabaabaabbaaaaabba
        aabbababbbbaaabbbabaabab
        aababaaabaaababaaababbabaaabbbbabbaababb
        aaaaabbbaabbaaabbbbaabbabbbbabaa
        baaaabaabaaabaabaabbaaababaaaaaa
        ababbbaaaabababaabbabbaababaaabaabbbbaba
        bbbabbaaabaaaaabbbbbbbbb
        bbababbabbaaaababbbbbbaaabaaababbaababba
        abaabbabbbbbbaaaaaabbababaaaabaababbabaaaababbba
        baaababaabbbbbaaabbaaabbaabbaaaaabababaa
        baaaaaaaaabababaaaabaababaabbbbbaababbaababbabaa
        bbbababbaababbababaababbaaabaaabaabaaaaa
        baabbbbabbabbaabbaabbbaa
        bbbabaaaaaabbaaaaabaaaaaaabaaabb
        aababbbbbaabbaabaaabbaaabbababbbbbbabaaa
        bbbbbbbabbabbaaaabbaababbaabbbbbbabaaaaabbbbbbbbbabaaaababaaaaba
        abbbbbbabbbbababaaaaaaabaaabbaabbaabaaaa
        bbabbbabbbbabaababbabbaabbbabaaaaaaaabba
        aaabbbababaabbaababbaabbbaabaaabbbbbaaba
        bababaababaabbaabbbabbbbbaabbbbabbbaaaaa
        aaaaabbbbbbbaaabbaaabbbaaabbbbbbababbaba
        aababbabaababbabbabaaabbbaaaabaaaaaaabbaababbbab
        aabaaaababbbabaabbbbababaabaaaba
        baaaaabaabbbababbbabbabaaabaaaaa
        bababbbbbbbabbabbaabbbbabbabababbbbbaaaa
        aaababbbaaaaabbbbbabbbabbbabababaaabaaaabbbbaaabbaaabbaabaabbbaa
        abbbbbbbaabbabaaaabaabaaabbbaaaabbbaaaaababababbaabbaaabaaaaaabaaaabbbabbbbbbaaababaaabbbbbaaabb
        bababbbbbabbaababbabaabbbabbaabbabbabbbb
        abbbaaaabbabababbbbabbababbaabaa
        baabababbbbbbaaaaaaaaaaa
        bbbaabbaaaaaabbbbbaabbaababbbaab
        aabaaaabaaabaaaaaababbbbbbbaaaba
        abbbaababaabababbbabbabbaaaaaaabaaaaaaaabbabbbaa
        abbbbaaabbabaaababababbb
        abbaababbbbbaabbbabaaaab
        babbaaaabbaaabbbbbbbaaabbabaabaabaaaabbb
        bbbbbaababaababbaabaaaba
        baaabbbabaaabbbababbbabb
        aababaaabbbaababbababaabbbbbabbabaabaabb
        bbbaaabbabbabbaabaabaaba
        babaaabbbabbaabbbabaaabababababbabababbb
        bbabbabbbabababababaabbb
        baabababbabbbabbaaaabaabaabbbbba
        abaababbaaababababaababbbbbaaaab
        bbbababbaabbababaabaaaab
        abaaabbabbbbaabbabbbbaba
        baabbaaabababaabaababbababaaaabbbabbabaa
        baaabaaaaaabbbaaabaababaaaaabaab
        bbbbbbaabbaaabaaaabaababaabaaaabbabbaabbbaaabaaa
        aabababababaaabbabaabbabbbaabbbbbbbbabbaabbbaaab
        babbbbbaabaabbbabbabbabbaabaababbaaabaabbabaabaaabaaabbbabababbb
        babbbbbbbbbbabaaaaabbaabbaabaaababbbabbb
        bbabaabbaabaabababaabbaaabbabbaababbbabb
        aababbbbaaabaaaabaaabbab
        bbababbabbbbaabbbaaababb
        aaaaaabbbbbaabbaabaaaaabbabaaabaaababbabababbaaabbaababb
        ababaaababbbbbaaabaaabaa
        bababaababaabbaabbababbaaabaabbaabababaa
        baaaababbabbaabbbabbbbaabaabbaba
        bbbabbabababaaaabaaaabba
        bbabaabbababbaaaaababbba
        baaaababaaabaaaababaaaaabababbba
        bbbababbabbbabbaaaababababbaaabaabaaaaba
        bbaaabaababababaaabbaaabbaabaabb
        babbbbbaabbaaabbbbbaababbabbbaaaaabbaaaa
        ababbaaabaaaabaaaaaabbbaabaaabbb
        aaabbababbbabbaabaaaababbbaaaaabbabbaaaaaabbabbbabbabaabbaaaaaabbbbbbbbb
        aaabbbabbabbaaaabbabbaaaabaabaaa
        bababaabaababaaabaabbaab
        bbabbbabaaabababbbbbbaaabbbbabaa
        bbbaaabbbbaabaaabbbabbabababbaababbaabaa
        bbbbabbabaaaaabbbbabbbbaaabaabbbabbbbaaaabbaababbbbaabbabbaaabbb
        aaaabbababbbbbaaabbaabbbabbbbaaa
        aaababbbabbaabbbaaabaabaaabbbbba
        abaababbbaaabbbabaaaabbabbaabbaabaaaabbbbbbbaaababbaaababbbaabaabbbbabbabbbbbbbbbabbbaab
        abbbbbbbabbbabbaabbabbab
        abbbaabbaaabaabaaabbabbbaabbaabbbaabaaaaabbabaabababaaba
        bbbbbabbbaabbabbbbbbbbbabaabbaba
        abbabbaabababbbbbbbbaaba
        baaaabaababbaaabbbbaaaaa
        bbaabbababaaabbaabbaababbbbaabbbbababbababaabaaa
        babaabbabbabbbabbbaaaaabbbbbaabababbbbab
        aabbbbababbaababbabbaaaaaabbbaaababaaababaaabbbaabbabbab
        babbababbaaabababbbbbaaabbabaabaaaabbaaa
        aabbaaabaabbaaabaabbababbaaabbaababaabaa
        aaaaaaabbbbbbaabababaabb
        baaabbbbaabaaaabbbaabbabababaaba
        bababaaabbbbaaababbabbaaabaababaaaabbaab
        baaababaababaaaaaabbabaa
        bbbabbabbabbabbbaaaaaaba
        baaabaabaaaaaabbababaaaaababababbaabbbaa
        abaabbaababbabbbaabaabaaaaabaabbbbbabbba
        bbabbbbabaabababbbababaa
        ababbaaaabaaabbabbababbababbabababbbbaababbabaabaababbbabbabbbaabaaaabbb
        babbbbaabbbabbaabaaaabbbbbbbaaaaabbbbbab
        aaaaaabbbababbbbbabbbaabababbbababaababb
        baaabbbbaabaababababbabbabbbaaabaaaabababbbaaabaabbabababaabaabaababbbbaaabaaabbabbbbaaa
        bbabbaababbababbbbaaaaababbabbbb
        abbbbaabbbaabbbbabbbabbabaaababababbaabbbbbbaaaaaaaababa
        aabbabbbbbabbaabaabbbaaaababaaaaabaabbbaaaabbaaabaababba
        abbababaabbbabbaabbbaaab
        abbababababbababaabaaabb
        aaabbabaaaaaaabbaabbbbbbbabbbabb
        aabbbbbaaaaabbbbabbbbaaaabbaabaaabaabbbaaaabaaaabbbbbbab
        abaabbabbbaabbaababbbababbaaabaabbbbaabbbaabaabbaaaabbaaaabaaaba
        aabbaabbaaaaaaabaaaabaab
        abaabbaabbbababbabbbbaabaaaabbbaabbbabaaabbbbbab
        baabbbbabbabbbbaaaaaaabbbabbaaaaaabaabba
        baabababaaabbbbbbababaaaabbbabbaaabbbbbbabaabbbb
        abaababbbbbbbaaaabbababbaabbbbbb
        ababaaaaaaabbabaabbbbbbabbbabbaaaaabbbbbbababbba
        abbbaabbaaaaaaababaabaaa
        bbbabbabbabaaabaababbbbaaabbbbbbabaabbbb
        bbabbabbbabbbbbabbbaabbaaaababbbabbaaaba
        bababbbaababaabaababaabbbaaabababbbbaaaaaaaaaaaaaaabaabbabbbabbababbbbab
        aababaaaaabbaabbaabaaabb
        bababaabbaaaaaaaaaaaababbabaaaab
        baabbbbbaabaabaaaabaabbbbbabbaabbaabaaaa
        bbbaababaabbaaabbbbbabaa
        aababbbbabbaaaababababbababaabbbaabbbbbaaaabbaabbabbabab
        aaaaabbbbbabbaabababbbbabbabaaba
        aababaaaabaaabbaaabbbaab
        baabbaaabbabbaaaaababbabbaaaabaabbbabbbbaabbbbbabababbab
        baaababababaabbaaaaabbaa
        aababbaabbaaaababbaaabaaaabbbaab
        abbababbbababbbbbabaabbb
        bbbabbbbbabbbbbaaaabbbbbaabbaababaaaabbb
        aabaabbbaaaaababbababbab
        abaaaaabbabbaabbababaaabbaaaaababbaaaabb
        bbabbaaababbaaaaabababababbbbaaaabababaabaabbaab
        aaabbabaabbbaabbbaaabbbababaaaabaaabbaaa
        baabababbabbababbabbbababaaaaaabaaaababa
        bbabaababaaaaaabbbbaaaaabbbaaaaaabbbbaababaababa
        bbaaaababaaabbbbaababaaaabbbababaaaabbbaababababbabbbbbbbabbbbbb
        bbbbbababbabbabbbbbaaabbbabbabbbbabaabab
        babbbbbababaabbabbbbbaaabbabbaabbbbbabababbbbbbbbababbaabaaabbab
        aabbbbaabaaaabbbbbaababbbababbaabbaababb
        abbababaaaaaaabbaababaaaabaaabaa
        abbbbaabaababbbbaabaaaababbbaabbbaabababbbbaaaab
        abbbbbbabababaababaabbbabaaabaaa
        ababaaabbabaabbaaababbbbbbabaaaa
        bbbbaabbaaaaabbbbaabbaba
        babababaaababbabbbabbabaaabababb
        ababbbbabababbbbabbabbab
        abaabbabaabbaaababbaabbbbbbbbaab
        ababaaabaaabaaaaaaabbaaa
        ababbaaaaabbaaabbabaabab
        bbbabbabbbbbaabbaaaaababbbaababbabaaabab
        ababaabaababbabbbbbbabbbabbbaabaaaaaaaabbaabbbab
        aabbbbabbaabbbbbaabaaaababbababaaaabbabbaabaaaaa
        bbabababbabaaabaaabbabba
        bbbbaaabbbbaabbbabbabbaabbbbabbbbaaabbab
        aaaabbabbbbabbbbbbbbabbb
        ababbbbabbabababaababaaaabaabbbaabbaaaaa
        bbabbbbababbaabbbaabbabbbabbbabaaabababb
        babbbbbabbbbaaabaabbabba
        ababbaaabaaabaabababaabb
        aaaaaabbaabbabababbbaabaababaabb
        abbabababbaabbabbbaaaaaa
        abbbaababababaaabbabaaaa
        aaaabbbabababababaaaabaaaabaabaaaabbbabb
        bbaaaaabbbbababbbaabbbbbaababbaaaaaaaabaaabbbaba
        aaababbbabbaaabbbbbbabaa
        bbaaabbbbabbaabbabababaa
        abbababbabbbbaababbbbbbaabbbaabaaaabaabaababaaaaaaaaabba
        baaaabaaabbbbbbaabaabbbb
        bbaabaaaaabaababababbaabaaaabbaaabaabaab
        babbbbbababaaababbaababb
        aaaaababbbbababbabbbbbab
        bbabbaaabbbbbaaabbabaabbabbbaabbaabbbaaa
        abbbbbbabaabbabbaababbaabaaabbaa
        aababaaaaabaabaabababaaabbabababbbbabbaaabbaaababbbbbbbb
        baaabbbbbaabababbbbbbaaabbbbbaab
        bbabbababaabbbbbbaaaaaaaabbbbaabaaaabbabbabbbababbaaabba
        bbbaaabbabaababbaababbaababaaaab
        abbbbbabbaabbbaababbbbaababaabbbababaabaaaaaaaab
        bbbabaabaaaaababbbbbabbb
        bababaaabaaaaababbaaabbaaabbabbbbbbaabaaabbababbbaabaaaabbababba
        baabababbbaaabbbbbbbbbab
        bababaaabaaababaabaaaaaaaaaaabbaaabbaabb
        abbbaaaabbababbaabbabaaa
        abaababbaabbabbbbbabbabaaabbaabbbaaaaabaabababab
        bababaaabbaaabaaaaaabbbbaaababbabbabbababbbbabaaabbabbaaabbabbaaabbaaaababbbaabb
        abaaaaababaababbbaaabbbabaaaaaaabbaabbbbbaabbaba
        aababbbbababaaabbbabbbbb
        abbbbbaaabbbaababbabaaaa
        aaabbbbbaaaaabbbbbaaaaabaaabbabaaabababb
        bbaabbaabbaabbaabababaaa
        baaababababbababbaabbaba
        bbbabbabababbbaaaaaabaaa
        baabbbbbbbbbbaabbbabbbbaaabbaabbabbbababaaabbaaa
        baabbaaabbabbbabbbbbbababbbbabaa
        bbbbaabbabbbaaabbbabaaabaabaaaaa
        babbabbbaaabaaabbaaaabababaaabbb
        babbbabaaababaababaababbbabaaaabbaaababaaabbaababbaaaabbbaababbb
        aabbababaabbababababbbbabaabaabb
    """.trimIndent()

    interface Component {

        val id : Int

        fun isTerminal() : Boolean
    }

    class Terminal(val value:Char, override val id: Int) : Component {
        override fun isTerminal() = true
    }

    class Reference(val pairs:List<Pair<Component,Component?>>, override val id: Int) : Component {
        override fun isTerminal() = false
    }

    fun getResult() : Int {

        val parts = input.split("\n\n")
        val rules = parts[0].split("\n").toTypedArray()

        val strings = parts[1].split("\n").toTypedArray()

        fun mapToPair(rule : String) : Pair<Int,String> {
            val parts = rule.split(": ")
            return parts[0].toInt() to parts[1]
        }

        val sortedArray = rules.map { mapToPair(it) }.sortedBy { it.first }.map { it.second }.toTypedArray()

        fun getComponent(idx : Int) : Component {

            val strRule = sortedArray[idx]

            if (strRule.length == 3 && strRule[0] == '"') {
                return Terminal(strRule[1],idx)
            }
            else {
                val parts = strRule.split(" | ")

                val list: MutableList<Pair<Component, Component?>> = mutableListOf()

                for (part in parts) {
                    val terminals = part.split(" ")
                    //if (terminals.size > 2) println(" > 2 terminals")
                    val first = getComponent(terminals[0].toInt())
                    val second = if (terminals.size == 1) null else getComponent(terminals[1].toInt())
                    list.add(first to second)
                }
                return Reference(list.toList(),idx)
            }
        }

        val component = getComponent(0)

        return strings.asSequence().map { isValidComponent(component,0,it).first }.filter { it }.count()
    }

    private fun isValidComponent(component: Component, idx: Int, str:String ) : Pair<Boolean,Int> {

        if (component is Terminal){
            if (idx >= str.length)
                return false to idx

            return (str[idx] == component.value) to idx + 1
        }
        else{
            val compRef = component as Reference
            for (pair in compRef.pairs){

                var (v,i) = isValidComponent(pair.first,idx,str)
                if (v) {
                    if (pair.second != null) {

                        val (n, m) = isValidComponent(pair.second!!, i, str)
                        if (n)
                            return (if (component.id!=0) true else (m == str.length)) to m
                    }
                    else
                        return (if (component.id!=0) true else (i == str.length)) to i
                }
            }

            return false to idx
        }
    }




    fun getResultAdvanced() : Int {
        return 0
    }
}