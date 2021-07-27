
package ammonite
package $file.week6
import _root_.ammonite.interp.api.InterpBridge.{
  value => interp
}
import _root_.ammonite.interp.api.InterpBridge.value.{
  exit,
  scalaVersion
}
import _root_.ammonite.interp.api.IvyConstructor.{
  ArtifactIdExt,
  GroupIdExt
}
import _root_.ammonite.compiler.CompilerExtensions.{
  CompilerInterpAPIExtensions,
  CompilerReplAPIExtensions
}
import _root_.ammonite.runtime.tools.{
  browse,
  grep,
  time,
  tail
}
import _root_.ammonite.compiler.tools.{
  desugar,
  source
}
import _root_.mainargs.{
  arg,
  main
}
import _root_.ammonite.repl.tools.Util.{
  PathRead
}


object `poly.workbook`{
/*<script>*/class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
        val (exp, coeff) = term
        terms + (exp -> (coeff + terms(exp)))
    }
    override def toString = {
        (for ((exp, coeff) <- terms.toList.sorted.reverse) 
        yield coeff + "x^" + exp) mkString " + "
    }
}



val p = new Poly(1->2, 2->3)
val p2 = new Poly(1->5, 5->6)



/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "poly$u002Eworkbook"
  /*</generated>*/
}
