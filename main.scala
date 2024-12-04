
@main
def main(): Unit = {
  // Definir la lista de datos como una lista de tuplas
  val datos: List[(Double, Double)] = List(
    (72, 160), (76, 155), (78, 150), (81, 145), (89, 140),
    (95, 135), (108, 130), (115, 125), (120, 120), (130, 115)
  )

  // Calcular las medias de x (peso) e y (tensión sistólica)
  val n = datos.length
  val X = datos.map(_._1).sum / n
  val Y = datos.map(_._2).sum / n

  // Calcular el numerador y los denominadores de la fórmula
  val numerador = datos.map { case (x, y) => (x - X) * (y - Y) }.sum
  val denominadorX = math.sqrt(datos.map { case (x, _) => math.pow(x - X, 2) }.sum)
  val denominadorY = math.sqrt(datos.map { case (_, y) => math.pow(y - Y, 2) }.sum)

  // Calcular el coeficiente de correlación de Pearson
  val r = numerador / (denominadorX * denominadorY)

  // Imprimir resultados
  println(f"El coeficiente de correlación de Pearson es: r = $r%.4f")

  // Interpretación del resultado
  if (r == 1) println("Correlación positiva perfecta.")
  else if (r >= 0.7) println("Correlación positiva fuerte.")
  else if (r >= 0.4) println("Correlación positiva moderada.")
  else if (r >= 0.1) println("Correlación positiva débil.")
  else if (r == 0) println("No hay correlación lineal.")
  else if (r > -0.4) println("Correlación negativa débil.")
  else if (r > -0.7) println("Correlación negativa moderada.")
  else if (r > -1) println("Correlación negativa fuerte.")
  else println("Correlación negativa perfecta.")

  def at100(lists: List[List[Int]]): List[List[Int]] = {
    // Filtrar listas donde el máximo valor sea al menos 100
    lists.filter(_.max >= 100)
  }
  // Prueba de la función
  val resultado = at100(List(List(0, 1, 100), List(60, 80), List(1000)))
  println(resultado)

}

