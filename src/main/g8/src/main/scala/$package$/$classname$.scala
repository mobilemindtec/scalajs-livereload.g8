package $package$

import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}

val nameVar = Var(initial = "world")

val rootElement = div(
  label("Your name: "),
  input(
    onMountFocus,
    placeholder := "Enter your name here",
    onInput.mapToValue --> nameVar
  ),
  span(
    "Hello, ",
    child.text <-- nameVar.signal.map(_.toUpperCase)
  )
)

@main def main(args: String*) =
  println("scala rocks!! =)")
  val containerNode = dom.document.querySelector("#app")
  render(containerNode, rootElement)
