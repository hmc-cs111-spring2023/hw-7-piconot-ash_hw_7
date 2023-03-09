package piconot.politeExternal

import scala.util.parsing.combinator._

import picolib.semantics._


object PiconotParser extends RegexParsers {
  override protected val whiteSpace = """(\s|#.*)+""".r

  def apply(s: String): ParseResult[List[Rule]] = parseAll(program, s)

  def program: Parser[List[Rule]] = rule *

  def rule: Parser[Rule] =
    bothstate ~ ":" ~ pattern ~ "please, move" ~ dir ~ bothstate ~ "(˵° ͜ʖ ͡°˵)" | "thank you! :)" ^^ {
      case stateNow ~ ":" ~ surroundings ~ "please, move" ~ singleDir ~ newState ~ "(˵° ͜ʖ ͡°˵)" | "thank you! :)" =>
        Rule(stateNow, surroundings, singleDir, newState)
    }

  def bothstate: Parser[State] = "^[^0-9]*$".r ~ """\d""".r ^^ {
    case letters ~ digit => 
      State(digit)
  }
  
  def dir: Parser[SingleDir] =
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
   
  //pattern is essentially the same as the usual implementation
  def pattern: Parser[Surroundings] = ndir ~ edir ~ wdir ~ sdir ^^ { 
    case n ~ e ~ w ~ s =>
      Surroundings(n, e, w, s)
    }

  def ndir: Parser[RelativeDescription] =
    (("N" ^^^ Blocked)
      | odirection
      | failure("expected N, or *, or x"))

  def edir: Parser[RelativeDescription] =
    (("E" ^^^ Blocked)
      | odirection
      | failure("expected E, or *, or x"))

  def wdir: Parser[RelativeDescription] =
    (("W" ^^^ Blocked)
      | odirection
      | failure("expected W, or *, or x"))

  def sdir: Parser[RelativeDescription] =
    (("S" ^^^ Blocked)
      | odirection
      | failure("expected S, or *, or x"))

  def odirection: Parser[RelativeDescription] =
    (("*" ^^^ Anything)
      | ("x" ^^^ Open))
}