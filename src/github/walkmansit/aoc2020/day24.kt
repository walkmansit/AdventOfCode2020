package github.walkmansit.aoc2020

object Day24 {

    private val input = """
        nwesesesesewswenwswsesesenesenwnesenwse
        nwnenwnwnenenwnenwnenewnwenenwwnenesesenw
        neneswnenwenwseeneweswsenesewnenenee
        senwewnwnenenwnwnwwesenenwswnenwwnwnw
        swseseeseswseseeswseneseswsesesenwsesew
        weeneeneswsewnwnesweseneswenwneswne
        swseseswswneswswsesewswswseswse
        swswseeswswwswnweenewswswesenwswwse
        swswswswsweswseeswseseseseeswwsewnw
        eneeseenenweeneenenee
        eesesenwsesweeseeese
        neenenenewnenenenenenwnenenenwnwne
        nenenwnwnwnenwnenwnwswnenesenenwnw
        neneweweneneenenenenesewneeneenee
        nwweswswewneenenwneneneeswneneneswne
        eeseeneseesesesewneswseeeseese
        swseswsenwswnewswseswswswseswswse
        senenenwnwnenwnwnwewnwwnwswnenenwnwnwenw
        senwnenenwnwnenwnwwnwswnwnwnenwnwenenwnw
        neweseneswswnwswnwswseneseenwseeswee
        esesweeneeneswsenwsweeeeseeseee
        nenenwewseswseseswsewseneewwwnww
        neeswswenwnewnwnwwswwwneswswnwwwnwnw
        wwweswwwwwwswwwwww
        eeseenweenwseneeeeeeweeenee
        eeeeesenenenwesweeeswenwswseswee
        neswenenesenenenewnwenesweneneeswne
        swswswenwswwswswswswswwwswweswnwsww
        seseswseseseeswneeeeesewesesenenw
        swwswwwswwwswwswsweneswwwsesww
        eneeswenweewenwseeeseeeseswwnw
        swnenwswswswseseswswswwseswswswswswswsw
        seeseseeseeeesesesenwsenwseweseese
        swswswswnwnesweswewseseneswswwnenwsw
        eewnenweneswwseeeeneneeeeeene
        esenweswwnwnwnwnwnwnwnwnwnwnwnwnwwnw
        seeeeeseeneeswweeeeeeneenw
        weneswswenenenenwneswneswneneneesene
        wnwsesesenwnwnenwnwnesweneenwseswwsw
        sewsesesesesesesesewsenesesesesesenesese
        swswswwnwswswwweswswswnewwseswsww
        nwneneswnwnwnenenenwsenenwnwnenwwnene
        neenwenenwsweseeswsesweeseseswneswene
        eneeenewewneeneeneweneeesee
        nwnwwwnwnewsenwsenw
        sesesewswswwneneneeseeewswnwswnwsenw
        sewwswwnwwewwwneswswswwwneew
        nwsenwwnenenenesenwsenenenenenenenenenwne
        sewsewnesenwsenesenwsesweswswsesenenw
        eseeeeeeeenweeeeseesee
        eseenwseesweswenweseenweeeeswee
        neseseseswwneswsesesesewseseseswse
        sesweewseseeesenwseeeseeswsweneenw
        wnwneseeeseseeseenwwenwseseesese
        enwneswnwneneneneneneneenenwnenwwnene
        wnwneneneneneneewnwwnenweneesw
        nwnenenenwnenenwenenwneneseswnewnenene
        nwwsenwnwnenwnenwnenwneneneenwnwsenenww
        wwwsewwnwwwnewwneswwewww
        swseswwswseswswswswsenwseneeneewsenwsw
        nwnesenenwenwnwnwnenwnwnwneswnwnwnenene
        seeeweswnenenwsenewenenwewneseee
        nwwnwneseswsesweenweswsese
        seeseseswsesenesesesenesewseseseeese
        swwswneswwnwswneswwewsesewswswsww
        seswneswswseswswseseswnwswswswswseswew
        wwwwwswwewseswwwwwswwnenesw
        nwnwwsenwnenwnwnwnwneenwnwnwnwnenwnww
        nwnwneswwswseswswnwnwenwnenesenenenwswenw
        neneneneeneeseneneneeneneneswnwnenee
        neeeswswnweenwsweseneeseswnwnewe
        neswesenwneneneenenweeneene
        swseeneewnwseeeenwesenweseseeswnw
        eweneeneseeneneneneeeseeeneewene
        eeneneewneneeeswneneeneeenwsenenew
        nwnwswsweswswnenwswseswswswsweswswnesw
        neeeeseeeswewenenwswnene
        nwenwnwenwswnwnwwnwswnwnwneswnwneswswese
        neswseweeneneeeseenwwnenesenenwnee
        wswwseewwwewweewwswnewwwsww
        swswswwswswwwswswswswswnweeswswswsw
        enenenenenenenenenenwnenenwsenenenewnw
        seseswseseseeswseneseseseseseneseesee
        neewneeweeeeeneese
        enewneseeweneneeneneewenesenene
        enwswneeswnwswsewenwwnesewneswseswe
        senwswnwnenwnwwnenwnwswnwnwnwnwnwnwnwnwe
        sewswneswswswseseseseswswseneswseswswsw
        nwnenwwsewneneswnweenwnwnenwnwnwsenene
        eswwewswswnwswsw
        wwwwwwwwswsenw
        nwnwnwnwnwnwnwwwnwnwwnwnwwnwnenwsese
        seswnewnenwnweswnwsesenwseeseesesewnw
        neneseneeswneneneswwsenwnw
        nwnwnwnewnwnesenwnwnenwnwswnwneseenwnw
        wwneneeneswneneeewwnesesenenenese
        eseeswswsesenwneeewswnenwnwnewnw
        nwnesesenewwwswnwewsenwwsewnwwww
        eneeenewneneeneneneneswnenwewnesee
        neneenewenenenenew
        nwsenweewnwwwwenwnwswnwnenwswnwnwse
        seseeeeeeswwsenwseeseeseseeese
        wwwnwwwwwwwewewwwwwww
        swswseseneseswswsewseseseswenwneseseswsw
        seswsesesenweseeseswwseseneswsesesesese
        swswseswswswswswswswswswnwswswseswsw
        nweeneewneeseseesenwsenwseweswnwnw
        eeeeeseseeeeewsweenweeeese
        nwesesesesenenewwwneeeeweeee
        eenenwneneeswewneeeeneenee
        seseseswseswseswsenwseeswsesenwseseswne
        eseseseswseeneseeseseewnwswsesenese
        nwnenwnwseewsenwenewsenwsweswswenenee
        wsenwnwwnwwnwneeenwnwne
        seswswswswseneneseseswswswswswswswwnesww
        wswseswnwsweswseseswesesenwswseseseswsw
        sewweseseneseneswsesesenesesesesesese
        nwwnwneewwewwwwnwwwwwswwwswsw
        nwsweswwneeeeeenwseeenwnwswswesw
        wwwwwwsenwwnewwnwwwenwwwew
        swneneneswneneswenenwnwnewnwnwsenenenwnene
        eswnweseweseeseenwsene
        esewewneneneneseneneneneneneneneewwne
        eneeeenesenwnenwseneneenenenweesw
        nwnwnwseenwnweswnwnwnwnenewnwnwnwswenw
        neenenesewsewneeswseseenwweeeesw
        eewneeeneeesweeeeeeenenee
        nenenenenenwwsenenenenenenenwswneneneene
        nwwwwswwwnewwwwwwnwwww
        enwswseswenesenwenwseseeswesesenewse
        swesweneeenwenenweeneneesweeee
        wnwnwnesenwnwwsenewswnwwnwsenwseneswse
        neseswseneenwsweneswwnwsenwnesewsenwsw
        swswswseseneswweenwswswsesenewseswnesenw
        weseseeseseswseseseneeeesesewnese
        seeneswnewsesewnwwwwnw
        sewseeseeeeesewneeese
        seseseenwewsesewneseeeeesweenw
        ewswwwswswwswwwswswswsw
        nwnwwwsenewswnwwwenwsenwnenwnwnwnw
        esenwseseweeneneneswwsewsesewneese
        wnwnwswnenwnewwenenesewnenenwnesenesene
        wnwnenwwnwnwnwnwnwnwswnwnwnwnwwnenwnwse
        eewnesenwsesesweeneeewesweeesee
        swenwesweseenwseeseseseenenwesee
        nwnwneswnwenwwnwnwnenenwnwnweneswsenw
        swwwewwnewseewswwswnewwwww
        swwwswewwwsewwsewnwwswwwwnww
        wsenwewnwwsewwwnwsewnwnwwsenwnwnw
        neswswnenenwneneneenewneneneswnwsw
        wwwswwwwnwewwwsewwwwwwwnw
        seseseswseswswnweswwswswswnwsesesesesee
        nwneneenesenenenwwnwneneswnwnwnenenenwnw
        neeenwneeneesweenweeeesw
        eweeeeeeeeeeeeneswneeeswe
        wseewesesesesesesesesewseenesesesesee
        eeeeeseeeeweeee
        wsewneseeewseswnewnenenwnenewnesenw
        wswenwnwnwnwwnwnwnwwewnwwnwwnww
        wwwwwwnewwwsewwwswwneseww
        wwwwewwwwwwnw
        nwnwnenenwnwnwseenwwsenwenwnwwwnw
        seeswswsewnewnwwsweswwswnwswswnwnw
        eweseseneeseese
        sweeeeeswenenesweseeeeseneee
        wnwswewnenewsewwnewwwswwsww
        nweenwwwneswnwsenwsewewnwwnwnwww
        eswneeneneneneeeneeneeneneeeswne
        eeseseneeeeeeeweeneeeswee
        enweeseneswnenwnwnwswswswnw
        swseseseseseeseeneeese
        swswswswswswswswwseswswswswswseeneswnwsesw
        senwseenwwsweswseseswse
        wnwwnwwnwnwnwwsenwnwnwnewnwnwnwsenwnwse
        seseenwesesenwseseseseseseseseseseswswsw
        nesewnenenwnwneneswneneswsenwnenwnenw
        eswnwweenweseeneeswneeeeeee
        seesweneewenenweswseseweseneswsenwse
        wsesesesenesesesesesesesesesesese
        neneneneenenenenenewneneneneneneswne
        eseseeseeseeenweeeswseesenwse
        neneseeeeweseewwseseeenweseee
        senewnwwwswwewnwwnwwsewenewse
        seseseeweseseseneseeeseweseseseee
        wswseswseenwwswneswswnwswsww
        nwnwnwnwwswnwnwnwnwenenwenwnwnwnwne
        sewnwsenweswswswneenwwsenewnwnewnwnw
        swseeseseswseneswwsesewwwswnenesesese
        eeeneneesweeeeeeneee
        nwnweswnwnwenwnwnwnwnwswnwsenwnwnwsenw
        swswswswnwenwswswswswweswswesw
        nenwnwneswnwneswnenwnenenenwnwnenenenene
        wneneneneneneneneseswneneesenewnenwe
        enwsenenweneeswswsesesweseseseseswsese
        swwseseseeseewnesewnewswseseswseswse
        enwneeneneswneneneenenenene
        eswweeeeseeneeeeeesesenweee
        nenwsenwnwnenwneswnwnwnwnwenwnwnenwnenw
        esenwswwnwnwenwsenwnwseseenwswnwwew
        nwswnewwwnwswnwwnenwnenwswnwwwwnwnw
        eeweseeseseeeeeeesesesewese
        nwseeeeenwseeseeeeseeeseeeew
        senenwswnweswnwwwwwnwnenwwseswwnwe
        ewswnwnewewsenwswseneswswswswseswsw
        nwseswnenwwenwwswsesenwnwneewwnwse
        seeneseseneweseseseeseseswseseseese
        wwsewwswswwswswneswweswswswswwsww
        swswswsweswswswswswnwwswswsesesweswsw
        seeeeweweeweeeseneenewene
        nwseseesewseesewnwneewseesesenenwee
        swewwnwnwswswwwweswswswswswneswe
        eeneeeneneneneeweneneenesenenenew
        swsewwwsewnewwwnwwwwwwnewww
        seneswwweswswswwsweswswswswswwswswwnw
        seneseseseswsesesewsesesesesw
        seswswseswswwewswswswswseswswswswnenw
        eseseseesesenenweseesweseeewseseese
        swesenenwswnesesenwwwnwse
        nenewswnenenenenenesenenenenenenenenesw
        senwneseneeneenenw
        wseseseeseseeseseseeseseseeenesewe
        neeeneweenenee
        nwsenenwnenwneeneeeneneneneeswnesene
        nwswseeneseenwswnweseneswswnweesesese
        nwseseseswsesesesewseeesesesese
        eswenesewnenwnwwwnwnwnwneswesenwswsene
        sewswwswwswswwswwswswwwneneswnwsww
        nenwswenenenenesesesenwwneswnenenewew
        senenwswseswsewwsewseseseneeswneswswsw
        nwwwnwswswseswseswswwnwweswwwew
        eswswswswseseseswswseswswnwswsweswwswse
        nenesenenewnenenwnenenenesenenenenenenesw
        wnwnwnwwwwwewwwswwwnewnwsenwsw
        enwnewnwneswewnewwswwneeseswesew
        nwnwnenenwsenwewnenwnenenenwnenwnwnwnwsw
        nesenewneenwnwnwnwnwneneneswneswnewnee
        ewenewswwsewenwwsenenwwswnwsenwnw
        nesenwsenwseseeswswnwese
        wnwsenwnwsenwnwswwnwwnenwnwseswnwnwne
        newnenwneneenwesenesenenwseseweswswe
        senwsesesenwsweseswswsenwnesesesww
        sweswseswswwseseseswswsesesenwneseseswnw
        nwwenwnwnwsenwnweswnwswnwwswnwnwnenw
        enesenenwsewesewsweeneeeeweeee
        nwnwnwnwwnwnwnwnwnwwwewnwenwnwnwnw
        wseswseseswneeseeseenwseenwseswnwse
        seesenwnwwwewseswswnwnwnwe
        sewwwwwwwweswwswwwwnewww
        neneeswnenwneneswsenweneswneseswseeww
        nwnwswenwnwnwnwnwneseswnwsweneswenwnwsw
        wwwswwneswwwwwnewswww
        senwnwnenwenenenenwnwnewswnwnwnwesw
        wswwwwnwswwswwewswnweswswwswew
        swseseseswseseswswseseswsesesesenesenwse
        nwwnenenenwswsweneenenenenesweneeene
        wwnwswwswwswewwwsewwwswswswe
        ewwnwwnenesweseenwswswseeswwneenww
        eseswsesenwwnwseseseseseseseseswesesesw
        wwwwwsewwwwnenwsewnwnenwwwww
        nenenenwneneeneswnenenenenwwnenwneenw
        seeeeeeeswwseeeeeweneeeenw
        senweeneeneswwneeneesweeeswenenesw
        nwwnenwnwnwenwnenwnwnwswswnwnwnwenwse
        sesenwseseseeseseseseseseese
        swswneswsewseseswseswseswseswseeswsewse
        seseeseseseeeesesesesewee
        seneneeswnenenenenenenenwsenwnenenwnenenew
        eeeneeneneweeewneeneneneeseene
        swneneneneeneneneenenenenwneenewnene
        seswnwseswnwnewneswswnesenewswwwswswsw
        enweseeweewewesweeenw
        wwwswewneswwwsesewwwnwwswswww
        nwwwswwneswwsewswse
        swwneseswswnewwswnewwwwse
        nwwnwwwnwewwnwswwwwnwwnwwewnw
        seseseswneseswseeseswswseswseswwesesenwsw
        nweseseseseseseswewseseswsesesesesesese
        seseswesesenwseenwsenwseseseseseseseswse
        swsenwwnwnwnwnwneswewnenwnweweeswne
        eeeenweeeweeeeeeeeesee
        nwwwwswnewswewwenwnwwwewswwnw
        nwnwnwnwwnwswenwnwnwnwnwnwnwnwnwnwnw
        nwwsewewnesewswewnwswwnwwneewse
        wnwnwwnwwwnwwnwnewwswwswwwne
        enenesweeeeeeneenweeneeneeesw
        neeeenweneeneneneneeeeeswsweee
        sweswwewseswwwseneneswsewnwwsww
        neesesenweweseneseeesesewseeseenwe
        sweeeneeeswnene
        nwwwswwnwseeweswwwnw
        ewswswswwwwneswswnwswswwswswswwww
        neewseenwneeswseeneweneweenwesw
        seneweseeseseseewseseswweeeese
        eneswswswnwswwwswswswswswswswswneswsw
        sewswswswswnwswseswswswswnewswwwsww
        wwsesenenwnewwwsenw
        swnewweswwenenwneseenenenenenenewne
        nwwnwnwnwswnwnenwwwnwnwnw
        sesesesenwseswnwseseseseseeseswswswswse
        swnwswenenwswswneweswwsewsw
        nwnwnwnwnenenewewnenenenesenwnwswnwnw
        seseswsewswswsenwseseesesenenwesenesww
        neneeneeseeeewwwneeenweeeswe
        enenwewwswswsenewswsenwewseeneenee
        nwwenwswwwnwwnwnwwnwwwwewenwww
        sweswnwswesenwsweswseswswnwnwswsweswnwsw
        seseseneseseweseewseseswsesewsesese
        eweneeneeeeeeseeeeeeeeesw
        ewwwnwwwwswwwswswwwwwswwnesw
        swnwnenwnwnwwnwnewnwswnwenwnwnwsenwnw
        swneeswseseneswwnesesenwsesesenwswnww
        seswneseseesesewseseene
        wnwwsewnenwnwwsesesenwnwsesesewwwne
        eswswwwswseswewwswwswnwswswwwnw
        enwnwnenenwnwnwswnwnenwnenwnwswnwnw
        newsesenwnenenwnwenwnewnwwnwnwswnwnwnwnw
        swneneenesenwwsenwnewnesesenenenwnenw
        neneenwnwswswswweeeeeeeenenee
        swswseswnwswswswenwswsesenwswseswnewswse
        newnenwnenewsenewnesenewneesenwnene
        neseseseseswsesewseswneseseswsesesesese
        ewseeeeseeesesesesenwseeeswse
        wseeeseeeseseesewseenwswseneeee
        neseneseswswsesenesewswsesenewsesesenwse
        swneneneneneenwneeswneneneeneneneswne
        eenewnenenesweeenenenenene
        nenenesenenenwneeneeneewseeeene
        nwsenenwnenewnwnwnwnwnwnenwnenwnwsenenenw
        swnwenwnwwnwnwnwswswewnwnwnwnenwnwnwnww
        wwswnwwewwwwsewnwwwww
        wseseswnenewwwwwswwwsw
        swswwswswwnewswwwseeswwwswwswsw
        enesesewewsesweeeseeseseseseesese
        nwwnewenwnenwnwnweneswnwneswnenwneenw
        eweeeeeseeeweweneeeesesese
        wswswswswswswnwseswneswswswswwwswsww
        swsenwnwwnwseseseswweeneenwnesenwnee
        neeswneneneneewneneneneneneneneneene
        nwnewnwnwnwwnwnenwwswnwnwnwwsenwsenwnenw
        nwnwnwnwnwnwnwnwsenwnwnwnw
        nwnewnwswwwswneewsewnewwswwwww
        eeswwesesesenwseeeeeeseeenwe
        nenwneswswenwsweneeswneneneneneeswnenw
        neneseeneneesewneswnenenwnw
        nwnwwwenwenwnwnwwnwnwnwnwwnwswnwnwnw
        seseseswswseswsenwswnenwseswwweseswnese
        wwewwwseswwswsenwwnwweswnwnee
        neenwnwseeneewwneneenenenesewseenese
        nwwswswenesewwwwswwswenwneswnewse
        seswwnenwnwnenwwneeswsewewsewsesw
        eseeseseeeesweneee
        eenesesweeeeenwswnwneenenwswnenene
        seneseseeeseeswswseswsenwsenwnwsesesese
        seseseseseeeeseseeenw
        wnwwwweewwwwwswnewwswwww
        swswnewnwswseswswswswswwwswswswswwsw
        nwnwenwnwnwnwewnwnwnwnwnwnwnwswnwnwnw
        seswswswseseseswseswswnwneseneswswseswne
        swseswseswswswsewseswsesenenwsesenwseseese
        swswsweseswneneswwnewswswswswswswswnew
        nwwnwnwnwswnwnwnwnwsenwnwneeeswnwnwnenw
        wneneneneseneneew
        weeeseweneenewseesesewesesesese
        swnweswswseeseswswswseswswswswnwseswew
        eneseenweeeswneeeenweswneeee
        neneenewneweneneeneseneneswneenenwnene
        nesenewneneneeseswneneeneenenwenewnw
        neneneweeneneewneeneeneneneene
        senenewnesewwwwswswneswwneswsenwse
        eenweneseeswnenweswnwsee
        nwnwnwsenwnwnwnenwneneneswnwew
        sweswneseenwesweeswnwewseneneneeenw
        swnwneswwswseswswswswseswseseswswsesw
        nwnwnwnwnewnwnwnwsewewsenw
        swseseseseswseswswswsenwse
        nenwnwesenwnwsenwwnwsenwneswneeneswnw
        ewwwewnwwsewnw
        nwwnwwnwnwswwnwnwnwnwwnenw
        wneeneneneenwswswwneneeneneenesene
        nenwnenwnenwnwnenwnwneesenwnenenenwwnew
        eenewnenwswwseeenwsenwweneneswne
        nwnwnenenwnwwnwnwnwnwswnwswsenw
        eeseneenenenenwwseswneneewneenenenee
        nenwnenewnwswnenewnwseswneenwnenesene
        wnwswwnwwenwenwnwwnwswnwnwnwnwnwnww
        neeneneenesewneseenenewnwenwswenese
        nwewneeswnwnwseseneswneneswnenwswnwnw
        nwnesesewseswsewsewnenenesesenewsesese
        seneseswswswswswsenwseseseswseswswswsee
        nwwswnwsewwwnewsewnwewesewnwnwnw
        eswwenwnenwnwnenwswnwnwnwnwsenenwwne
        senweesenwwsewseeneeeenesewseee
        nenwnenwnwnwswnwswnenwnenweeswnenwnenene
        wnwnwwewsewnewwswwwnwnwwnwwwww
        nwwnwswnwnwwnwnenwnwswseewnwnwnwnwe
        nenwnenenenwnwnwnenwnenenweenenenwwnesw
        wnwnenweseneswwswnwneeseswnenenwswwe
        eeeweeeeeeweeeseeee
        wwwswwnwwnweswweneswnenwwwnwww
        swswwswswseswswswsweseswswseneswswse
        seswnwewswwwwswwsewnwneswswewww
        seswwwwnewwnwwewwnewwwwww
        seneswnenwsweewnwnwenwswswswnesenew
        eswnweeesweeseneeeeeeeeeee
        wnwswswswswwswswswswwswwwewewsww
        nwnwnenwnwnweeswsenweesewswswnwnwswnw
        seswwnwsewwwwswsenenw
        wwswwwwswswseswwwwewswwswnww
        seswseseswseseswseseseswswseseswswnw
        swnesewwnwwneswne
        wswswsesweswswswseswwswswsweswswnwnwe
        seenwsenweseseseesesewseseseseesese
        esenwnwnwneswnwnenwwsenwnenwwsenenww
        eeeeeneseswseseeseenwseeesw
        swseseeneseneseeswwnwese
        eeeenweswseeeesee
        seseswweenwswnewwwwnew
        wswswswnwswswwswswswseneneswseseseeswse
        nwswwnwsewewswwswwwenenwwnwww
        seneseweseseeneesesesesesenweseseswse
        nwnenwnwnwnwsewwenwnenwsenesenwnwnenwne
        senwenewsesesewnwwseeweseswsesesenwe
        wenwewnwnwnwwnwewnwwwnwwwwnw
        seeeeseseeseseesenwseenweesesese
        swswswwnwswwwwswnewswswwwswswwew
        nenwnenenwnwnwsenenwneneneswnwnwnwsesene
        wnewswsenesewswwwswnwwswswnewwseew
        wsesenwenwseswsenwwseeseenesenenwwnw
        senewewswwswwewwwwnewswwwswsw
        swneenwseweseeenwweseseeesenwnwse
    """.trimIndent()

    private val monster = """
        1                  # 1
        1#    ##    ##    ###1
        1 #  #  #  #  #  #   1
    """.trimIndent()

    class Floor {

        private val deltaForSideMap = mapOf(
                "e" to Pair(1,0),
                "se" to Pair(0,1),
                "sw" to Pair(-1,1),
                "w" to Pair(-1,0),
                "nw" to Pair(0,-1),
                "ne" to Pair(1,-1)
        )

        private var tilesSet:MutableSet<Pair<Int,Int>> = mutableSetOf()

        fun addRoute(route: String) {

            fun getDirectionsFromRoute(route: String) = sequence {
                var i = 0

                do {
                    val candidate = route[i]
                    if (candidate != 'n' && candidate != 's' )
                        yield(candidate.toString())
                    else {
                        yield(candidate.toString()+route[++i])

                    }
                    i++

                }
                while (i != route.length)
            }

            var current = 0 to 0

            for (direction in getDirectionsFromRoute(route)){
                val delta = deltaForSideMap[direction]!!
                current = current.first+delta.first to current.second+delta.second
                //val tile = addOrCreateTile(current.first+delta.first to current.second+delta.second)
                //tile.inverse()
                //current = tile.coords
            }

            if (!tilesSet.contains(current)){
                tilesSet.add(current)
            }
            else
                tilesSet.remove(current)
        }

        fun turnOneDay(){

            fun countBlackNeighbors(current:Pair<Int,Int>) : Int {

                var sum = 0

                for (direction in deltaForSideMap.values){
                    val candidate = current.first + direction.first to current.second + direction.second
                    if (tilesSet.contains(candidate))
                        sum++
                }

                return sum
            }

            val blackCountForWhiteTile : MutableMap<Pair<Int,Int>,Int> = mutableMapOf()

            val buffer:MutableSet<Pair<Int,Int>> = mutableSetOf()

            for (blackTile in tilesSet ){

                for (direction in deltaForSideMap.values){
                    val candidate = blackTile.first + direction.first to blackTile.second + direction.second

                    if (!tilesSet.contains(candidate) ) {

                        if (!blackCountForWhiteTile.containsKey(candidate))
                            blackCountForWhiteTile[candidate] = 1
                        else
                            blackCountForWhiteTile[candidate] = blackCountForWhiteTile[candidate]!! + 1
                    }
                }

                val blackNeighbors = countBlackNeighbors(blackTile)

                if (blackNeighbors == 1 || blackNeighbors == 2){
                    buffer.add(blackTile)
                }

            }

            for (whiteForTurn in blackCountForWhiteTile.filterValues { it == 2 }){
                buffer.add(whiteForTurn.key)
            }

            tilesSet = buffer

        }


        fun countBlackTiles() : Int {
            return tilesSet.count()
        }

    }


    fun getResult() : Int {
        val floor = Floor()

        for (route in input.split("\n")){
            floor.addRoute(route)
        }
        return floor.countBlackTiles()
    }

    fun getResultAdvanced() : Int {
        val floor = Floor()

        for (route in input.split("\n")){
            floor.addRoute(route)
        }

        repeat(100){ floor.turnOneDay() }

        return floor.countBlackTiles()
    }
}