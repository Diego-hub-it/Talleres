import scala.util.{Try, Success, Failure}

//Ejercicio 1
def convertToCelsius(fahrenheit: Double): Option[Double] = {
  if (fahrenheit < -459.67) None
  else Some((fahrenheit - 32) * 5 / 9)
}

println(convertToCelsius(32))
println(convertToCelsius(212))
println(convertToCelsius(-500))

//Ejercicio 2
def safeAccess(list: List[Int], index: Int): Try[Int] = {
  Try(list(index)).recoverWith {
    case _: IndexOutOfBoundsException => Failure(new IndexOutOfBoundsException(s"Índice inválido: $index"))
  }
}

println(safeAccess(List(1, 2, 3, 4, 5), 2))
println(safeAccess(List(1, 2, 3, 4, 5), 5))
println(safeAccess(List(1, 2, 3), -1))
println(safeAccess(List(), 0))
