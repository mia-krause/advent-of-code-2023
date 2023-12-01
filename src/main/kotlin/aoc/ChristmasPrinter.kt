package aoc

object ChristmasPrinter {
    private const val YELLOW = "\u001b[33m"
    private const val BRIGHT_YELLOW = "\u001b[93m"
    private const val RED = "\u001b[31m"
    private const val BRIGHT_RED = "\u001b[91m"
    private const val GREEN = "\u001b[32m"
    private const val BRIGHT_GREEN = "\u001b[92m"
    private const val RESET = "\u001b[0m"
    private const val BORING_VERTICAL_BORDER = "$RED║$RESET"
    private const val BORING_EDGE_TOP_LEFT = "$RED╔$RESET"
    private const val BORING_EDGE_TOP_RIGHT = "$RED╗$RESET"
    private const val BORING_EDGE_BOTTOM_LEFT = "$RED╚$RESET"
    private const val BORING_EDGE_BOTTOM_RIGHT = "$RED╝$RESET"
    private const val BORING_SECTION_NODE_LEFT = "$RED╠$RESET"
    private const val BORING_SECTION_NODE_RIGHT = "$RED╣$RESET"
    private const val SPARKLE = "$RED˗${YELLOW}ˏ${BRIGHT_YELLOW}ˋ✰´${YELLOW}ˎ$RED˗$RESET"
    private val boringHorizontalBorder = RED + ("═".repeat(17)) + RESET
    private val christmasBorder = "$RESET*$RED~$BRIGHT_GREEN*$RESET~$BRIGHT_RED*$GREEN~$RESET".repeat(3)

    private val asciiHeaders = listOf(
        """$BORING_VERTICAL_BORDER       ⡠⠖⠋⠉$RED⠙⣷⣶⡤$RESET⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀ ⠀⠀$BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER    $RED⢀⣾⣷⣦⡀$RESET⠀⠀$RED⢸⣿⣷$RESET⠀⠀⠉$RED⣷⣶⡤$RESET⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀   $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER    $RED⣸⠿⠿⢿⣷⡤$RESET⢤$RED⣸⣿⡿$RESET⠀⠀⠀$RED⢹⣿⡇$RESET⠀⠀$RED⠙⣷⣶$RESET⠤⣄⣀⠀⠀⠀   ⠀ ⠀$BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER    ⠇⠀⠀⠀⢸$RED⣀$RESET⠀⠀⠈⠙⠒⠢$RED⢤⣿⣿⡇$RESET⠀⠀⠀$RED⣿⣿⡆$RESET⠀⠀$RED⢹⣿⡖$RESET⠤⢤⡀   $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER    ⠸⡀⠀$RED⣠⣾⣿⠏$RESET⠓⠲⡀⠀⠀⠀⠀⠈⠉⠓⠢⠤$RED⣿⣿⠃$RESET⠀⠀$RED⢀⣿⣿$RESET⠀⠀⢱   $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER    ⠀⠑$RED⢾⣿⣿⡟$RESET⠀⠀  ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠒⠢$RED⠼⣿⣿$RESET⠀⢀⠆   $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER      ⠀⠀$RED⠉⠛⠦$RESET⠤⣀⠌⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  $RED⠈$RESET⠉⠉⠀     $BORING_VERTICAL_BORDER""",
        """$BORING_VERTICAL_BORDER                      $BRIGHT_YELLOW*                      $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                     $BRIGHT_GREEN/'\                     $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                    $BRIGHT_GREEN/$RED°$BRIGHT_GREEN.$BRIGHT_YELLOW'$BRIGHT_GREEN\                    $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                   $BRIGHT_GREEN/.$BRIGHT_YELLOW'$BRIGHT_GREEN▹.$RED°$BRIGHT_GREEN\                   $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                  $BRIGHT_GREEN´⎺⎺$YELLOW⌊_⌋$BRIGHT_GREEN⎺⎺`                  $BORING_VERTICAL_BORDER""",
        """$BORING_VERTICAL_BORDER                   $GREEN.......                  $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                $GREEN.::::${BRIGHT_YELLOW}o$GREEN::::::.               $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER               $GREEN.:::´´   ``:${BRIGHT_YELLOW}o$GREEN:.              $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER               $GREEN:${BRIGHT_YELLOW}o$GREEN.:.     ..:::              $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                $GREEN`:$RED(_>( )<_)$GREEN::´              $BORING_VERTICAL_BORDER 
$BORING_VERTICAL_BORDER                 $GREEN`''$RED// \\$GREEN''´                $BORING_VERTICAL_BORDER
$BORING_VERTICAL_BORDER                   $RED/´   `\$RESET                  $BORING_VERTICAL_BORDER"""
    )

    fun printExample(result: Any) {
        val paddedResult = result.toString().padEnd(32, ' ')
        println("$BORING_VERTICAL_BORDER${GREEN}Example$RESET: ✅ $paddedResult$BORING_VERTICAL_BORDER")
    }

    fun printActualPuzzleSolution(result: Any) {
        val paddedResult = result.toString().padEnd(27, ' ')
        println("$BORING_VERTICAL_BORDER${GREEN}Actual solution$RESET: $paddedResult$BORING_VERTICAL_BORDER")
    }

    fun printPartHeader(partNo: Int) =
        println("$BORING_VERTICAL_BORDER$christmasBorder$BRIGHT_GREEN Part $partNo $RESET$christmasBorder$BORING_VERTICAL_BORDER")

    fun printDayHeader(dayNo: Int) {
        val paddedDay = dayNo.toString().padStart(2, '0')
        println("$BORING_SECTION_NODE_LEFT$boringHorizontalBorder$BRIGHT_YELLOW*$RESET Day $paddedDay $BRIGHT_YELLOW*$boringHorizontalBorder$BORING_SECTION_NODE_RIGHT$RESET")

    }

    fun printChristmasAsciiArt() = println(asciiHeaders[(0..2).random()] +"\n" + BORING_VERTICAL_BORDER +" ".repeat(44) +  BORING_VERTICAL_BORDER)

    fun printClosingBorder() =
        println(BORING_EDGE_BOTTOM_LEFT + RED + "═".repeat(44) + BORING_EDGE_BOTTOM_RIGHT)

    fun printTopBorder() =
        println(BORING_EDGE_TOP_LEFT + RED + "═".repeat(44) + BORING_EDGE_TOP_RIGHT)
}