object PiconotParser extends RegexParsers {

  // for parsing comments
  override protected val whiteSpace = """(\s|#.*)+""".r

  // parsing interface
  def apply(s: String): ParseResult[List[Rule]] = parseAll(program, s)

  def program: Parser[List[Rule]] = rule *

  def rule: Parser[Rule] =
    state ~ ":" ~ pattern ~ "please, move" ~ direction ~ state ~ "(˵° ͜ʖ ͡°˵)" | "thank you! :)" ^^ {
      case stateNow ~ ":" ~ surroundings ~ "please, move" ~ moveDirection ~ newState ~ "(˵° ͜ʖ ͡°˵)" | "thank you! :)" =>
        Rule(stateNow, surroundings, moveDirection, newState)
    }

  def state: Parser[State] =
    val sLength = _.length()
    val numStr = _.drop(sLength - 1)
    val regex = """\d""".r
    regex.pattern.matcher(numStr).matches ^^ {
        State(numStr) 
    }  
  
  def direction: Parser[MoveDirection] =
    (("up" ^^^ North)
      | ("right" ^^^ East)
      | ("left" ^^^ West)
      | ("down" ^^^ South)
      | ("North" ^^^ North)
      | ("East" ^^^ East)
      | ("West" ^^^ West)
      | ("South" ^^^ South)
      | ("N" ^^^ North)
      | ("E" ^^^ East)
      | ("W" ^^^ West)
      | ("S" ^^^ South)
      | ("X" ^^^ StayHere)
      | failure("expected up/North/N or some variation"))

  def pattern: Parser[Surroundings] =
    ndirection ~ edirection ~ wdirection ~ sdirection ^^ { case n ~ e ~ w ~ s =>
      Surroundings(n, e, w, s)
    }

  def ndirection: Parser[RelativeDescription] =
    (("N" ^^^ Blocked)
      | odirection
      | failure("expected N, or *, or x"))

  def edirection: Parser[RelativeDescription] =
    (("E" ^^^ Blocked)
      | odirection
      | failure("expected E, or *, or x"))

  def wdirection: Parser[RelativeDescription] =
    (("W" ^^^ Blocked)
      | odirection
      | failure("expected W, or *, or x"))

  def sdirection: Parser[RelativeDescription] =
    (("S" ^^^ Blocked)
      | odirection
      | failure("expected S, or *, or x"))

  def odirection: Parser[RelativeDescription] =
    (("*" ^^^ Anything)
      | ("x" ^^^ Open))
}